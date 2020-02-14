import java.io.IOException;
import java.io.Reader;

public class AnalizadorLexicoCore {

	private static String NL = System.getProperty("line.separator");
	
	enum Estado {
		INICIO,REC_MAS,REC_MENOS, REC_POR, REC_DIV,INT_EX,REC_NE,REC_GT, REC_GE,REC_LT,REC_LE,REC_PCIERRE, REC_PAP, 
		REC_NOMBRE,INT_SEP,REC_SEP, REC_PCOMA, REC_ENT, REC_0, REC_ASIG,REC_IGUAL,REC_EOF
		}// REC_IDEC, REC_DEC,REC_COM,
	
	private Reader input; // flujo de entrada
	private StringBuffer lex; // cadena para almacenar el lexema de la u. léxica
	private int sigCar; // siguiente carácter a procesar
	private int filaInicio; // fila inicio de la u. léxica
	private int columnaInicio; // col. inicio de la u. léxica
	private int filaActual;
	private int columnaActual;
	private Estado estado; // estado del autómata

	public AnalizadorLexicoCore(Reader input) throws IOException 
	{
		this.input = input;
		lex = new StringBuffer();
		sigCar = input.read();
		filaActual=1;
		columnaActual=1;
	}
	
	public UnidadLexica sigToken() throws IOException 
	{
		// Fase de inicialización
		estado = Estado.INICIO;
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		lex.delete(0,lex.length());
		// Fase de reconocimiento
		while(true)
		{
			switch(estado)
			{
			case INICIO:
				if(hayLetra()) transita(Estado.REC_NOMBRE);
				else if (hayDigitoPos()) transita(Estado.REC_ENT);
				else if (hayCero()) transita(Estado.REC_0);
				else if (hayMas()) transita(Estado.REC_MAS);
				else if (hayMenos()) transita(Estado.REC_MENOS);
				else if (haySeparador()) transita(Estado.INT_SEP);
				else if (hayPComa()) transita(Estado.REC_PCOMA);
				else if (hayPApertura())transita(Estado.REC_PAP);
				else if (hayPCierre())transita(Estado.REC_PCIERRE);
				else if (hayMenor())transita(Estado.REC_LT);
				else if (hayMayor())transita(Estado.REC_GT);
				else if (hayEx())transita(Estado.INT_EX);
				else if (hayDiv())transita(Estado.REC_DIV);
				else if (hayPor())transita(Estado.REC_POR);
				else if (hayIgual())transita(Estado.REC_ASIG);
				else if (hayEOF()) transita(Estado.REC_EOF);
				else error();
				break;
			case REC_NOMBRE:
				if (hayLetra() || hayDigito()) transita(Estado.REC_NOMBRE);
				else return unidadId();
				break;
			case REC_PCOMA:
				return unidadPComa();
				break;
			case INT_SEP:
				if(haySeparador())transita(Estado.REC_SEP);
				break;
			case REC_PAP:
				return unidadPAP();
				break;
			case REC_PCIERRE:
				return unidadPCierre();
				break;
			case REC_LT:
				if(hayIgual())transita(Estado.REC_LE);
				else return unidadLT();
				break;
			case REC_LE:
				return unidadLE();
				break;
			case REC_GT:
				if(hayIgual())transita(Estado.REC_GE);
				else return unidadGT();
				break;
			case REC_GE:
				return unidadGE(); 
				break;
			case INT_EX:
				if(hayIgual())transita(Estado.REC_NE);
				break;
			case REC_DIV:
				return unidadDIV();
				break;
			case REC_POR:
				return unidadPor();
				break;
			case REC_ASIG:
				if(hayIgual())transita(Estado.REC_IGUAL);
				else return unidadAsignacion();
				break;
			case REC_IGUAL:
				return unidadIgual();
				break;
				
			case REC_ENT:
				if (hayDigito()) transita(Estado.REC_ENT);
				else if (hayPunto()) transita(Estado.REC_IDEC);
				else return unidadEnt();
				break;
			case REC_0:
				if (hayPunto()) transita(Estado.REC_IDEC);
				else return unidadEnt();
				break;
				
			case REC_MAS:
				if (hayDigitoPos()) transita(Estado.REC_ENT);
				else if(hayCero()) transita(Estado.REC_0);
				else return unidadMas();
				break;
			case REC_EOF:
				break;
			case REC_MENOS:
				break;
			case REC_NE:
				return unidadNEQ();
				break;
			case REC_SEP:
				return unidadSeparador();
				break;
			}
		}
	}
	private boolean hayEOF() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hayLetra() {return this.sigCar >= 'a' && this.sigCar <= 'z' || this.sigCar >= 'A' && this.sigCar <= 'z';}
	private boolean hayCero(){return this.sigCar == '0' ;}
	private boolean hayDigitoPos(){return this.sigCar >= '1'&& this.sigCar <= '9' ;}
	private boolean hayDigito(){return this.hayDigitoPos() || this.hayCero() ;}
	private boolean hayPunto(){return this.sigCar == '.' ;}
	private boolean haySeparador(){return this.sigCar == '&' ;}
	private boolean hayPComa(){return this.sigCar == ';' ;}
	private boolean hayPApertura(){return this.sigCar == ')' ;}
	private boolean hayPCierre(){return this.sigCar == ')' ;}
	private boolean hayMenor(){return this.sigCar == '<';}
	private boolean hayMayor(){return this.sigCar == '>' ;}
	private boolean hayIgual(){return this.sigCar == '=' ;}
	private boolean hayEx(){return this.sigCar == '!' ;}
	private boolean hayDiv(){return this.sigCar == '/' ;}
	private boolean hayMas(){return this.sigCar == '+' ;}
	private boolean hayMenos(){return this.sigCar == '-' ;}
	private boolean hayPor(){return this.sigCar == '*' ;}
	private void error() 
	{
		System.err.println("("+filaActual+','+columnaActual+ "):Caracter inexperado");
		System.exit(1);
	}
	
	private void transita(Estado sig) throws IOException 
	{
		lex.append((char)sigCar);
		sigCar();
		estado = sig;
	}

	private void transitaIgnorando(Estado sig) throws IOException
	{
		sigCar();
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		estado = sig;
	}
	
	private void sigCar() throws IOException
	{
		sigCar = input.read();
		// Si es el comienzo del fin de línea,
		// reconocerlo... Como resultado, sigCar se fijará a '\n'
		if (sigCar == NL.charAt(0)) saltaFinDeLinea();
		if (sigCar == '\n') 
		{
			filaActual++;
			columnaActual=0;
		}
		else columnaActual++;
	}
	
	private void saltaFinDeLinea() throws IOException
	{
		for (int i=1; i < NL.length(); i++) 
		{
			sigCar = input.read();
			if (sigCar != NL.charAt(i)) error();
		}
		sigCar = '\n';
	}
	
	private UnidadLexica unidadEnt() 
	{
		return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.ENT,lex.toString());
	}
	private UnidadLexica unidadPComa() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCOMA);}
	private UnidadLexica unidadMas() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAS);}
	private UnidadLexica unidadPor() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,	ClaseLexica.POR);}
	private UnidadLexica unidadPAP() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAP);}
	private UnidadLexica unidadPCierre() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCIERRE);}
	private UnidadLexica unidadIgual() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUAL);}
	private UnidadLexica unidadSeparador() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.SEPARADOR);}
	private UnidadLexica unidadLT() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.LT);}
	private UnidadLexica unidadLE() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.LE);}
	private UnidadLexica unidadGT() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.GT);}
	private UnidadLexica unidadGE() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.GE);}
	private UnidadLexica unidadEQ() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EQ);}
	private UnidadLexica unidadNEQ() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NEQ);}
	private UnidadLexica unidadMenos() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);}
	private UnidadLexica unidadDIV() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);}
	private UnidadLexica unidadAsignacion() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.ASIGNACION);}
	private UnidadLexica unidadId() 
	{
		switch(lex.toString())
		{
			case "OR":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.OR);
			case "AND":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.AND);
			case "NOT":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOT);
			case "TRUE":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TRUE);
			case "FALSE":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.FALSE);
			default:return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.IDEN,lex.toString());
		}
	}
}
