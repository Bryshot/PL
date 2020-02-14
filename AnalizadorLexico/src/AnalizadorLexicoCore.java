import java.io.IOException;
import java.io.Reader;

public class AnalizadorLexicoCore {

	private static String NL = System.getProperty("line.separator");
	
	enum Estado {
		INICIO,REC_MAS,REC_MENOS, REC_POR, REC_DIV,INT_EX,REC_NE,REC_GT, REC_GE,REC_LT,REC_LE,REC_PCIERRE, REC_PAP, 
		REC_NOMBRE,INT_SEP,REC_SEP, REC_PCOMA, REC_ENT, REC_0, REC_ASIG,REC_IGUAL,REC_EOF, INT_REAL, REC_REAL,
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
			case INT_SEP:
				if(haySeparador())transita(Estado.REC_SEP);
				break;
			case REC_PAP:
				return unidadPAP();
			case REC_PCIERRE:
				return unidadPCierre();
			case REC_LT:
				if(hayIgual())transita(Estado.REC_LE);
				else return unidadLT();
				break;
			case REC_LE:
				return unidadLE();
			case REC_GT:
				if(hayIgual())transita(Estado.REC_GE);
				else return unidadGT();
				break;
			case REC_GE:
				return unidadGE(); 
			case INT_EX:
				if(hayIgual())transita(Estado.REC_NE);
				break;
			case REC_DIV:
				return unidadDIV();
			case REC_POR:
				return unidadPor();
			case REC_ASIG:
				if(hayIgual())transita(Estado.REC_IGUAL);
				else return unidadAsignacion();
				break;
			case REC_IGUAL:
				return unidadIgual();
			case REC_ENT:
				if (hayDigito()) transita(Estado.REC_ENT);
				else if (hayPunto()||hayExponente()) transita(Estado.INT_REAL);
				else return unidadEnt();
				break;
			case REC_REAL:
				if(hayDigito()) transita(Estado.REC_REAL);
				break;
			case INT_REAL:
				if(hayDigitoPos())transita(Estado.REC_REAL);
				else error();
			case REC_0:
				return unidadEnt();
			case REC_MAS:
				if (hayDigitoPos()) transita(Estado.REC_ENT);
				else if(hayCero()) transita(Estado.REC_0);
				else return unidadMas();
				break;
			case REC_EOF:
				break;
			case REC_MENOS:
				if (hayDigitoPos()) transita(Estado.REC_ENT);
				else if(hayCero()) transita(Estado.REC_0);
				else return unidadMenos();
				break;
			case REC_NE:
				return unidadNEQ();
			case REC_SEP:
				return unidadSeparador();
			
			default:
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
	private boolean hayExponente(){return this.sigCar == 'e'|| this.sigCar == 'E' ;}
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
	private UnidadLexica unidadNEQ() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NEQ);}
	private UnidadLexica unidadMenos() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);}
	private UnidadLexica unidadDIV() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);}
	private UnidadLexica unidadAsignacion() {return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.ASIGNACION);}
	private UnidadLexica unidadId() 
	{
		switch(lex.toString().toLowerCase())
		{
			case "or":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.OR);
			case "and":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.AND);
			case "not":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOT);
			case "true":	return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TRUE);
			case "false":	return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.FALSE);
			case "real":	return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TREAL);
			case "bool":	return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TINT);
			case "int":		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TBOOL);
			default:return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.IDEN,lex.toString());
		}
	}
}
