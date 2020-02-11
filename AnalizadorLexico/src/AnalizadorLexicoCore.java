import java.io.IOException;
import java.io.Reader;

public class AnalizadorLexicoCore {

	enum Estado {
		INICIO, REC_POR, REC_DIV, REC_PAP, REC_PCIERR, REC_COMA, REC_IGUAL,
		REC_MAS, REC_MENOS, REC_ID, REC_ENT, REC_0, REC_IDEC, REC_DEC,
		REC_COM,REC_EOF
		}
	
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
	
	/*public UnidadLexica sigToken() throws IOException 
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
		...
		case REC_POR: return unidadPor();
		...
		}
		}
		}*/
}
