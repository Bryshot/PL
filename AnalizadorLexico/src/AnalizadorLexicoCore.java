import java.io.IOException;
import java.io.Reader;

public class AnalizadorLexicoCore {

	private static String NL = System.getProperty("line.separator");
	
	enum Estado {
		INICIO, REC_POR, REC_DIV, REC_PAP, REC_PCIERR, REC_PCOMA, REC_IGUAL,REC_LT,REC_LE,REC_GT, REC_GE,REC_NE,REC_ASIG,REC_EX,
		REC_MAS, REC_MENOS, REC_NOMBRE, REC_ENT, REC_0,
		}// REC_IDEC, REC_DEC,REC_COM,REC_EOF,
	
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
				if(hayLetra()) transita(Estado.REC_ID);
				else if (hayDigitoPos()) transita(Estado.REC_ENT);
				else if (hayCero()) transita(Estado.REC_0);
				else if (haySuma()) transita(Estado.REC_MAS);
				else if (hayAlmohadilla()) transitaIgnorando(Estado.REC_COM);
				else if (haySep()) transitaIgnorando(Estado.INICIO);
				else if (hayEOF()) transita(Estado.REC_EOF);
				else error();
				break;
			case REC_ID:
				if (hayLetra() || hayDigito()) transita(Estado.REC_ID);
				else return unidadId();
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
			case REC_POR: return unidadPor();
			}
		}
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
		return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,
		ClaseLexica.ENT,lex.toString());
	}
	
	private UnidadLexica unidadMas() 
	{
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,
		ClaseLexica.MAS);
	}
	
	private UnidadLexica unidadId() 
	{
		switch(lex.toString()) {
		case "evalua":
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,
		ClaseLexica.EVALUA);
		case "donde":return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,
				ClaseLexica.DONDE);
		default:
		return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,
		ClaseLexica.IDEN,lex.toString());
		}
	}
}
