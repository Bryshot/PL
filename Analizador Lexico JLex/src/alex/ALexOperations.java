package alex;

public class ALexOperations {
	private AnalizadorLexicoCore alex;
	public ALexOperations(AnalizadorLexicoCore alex) {
		this.alex = alex;   
	}
  
	
	public UnidadLexica unidadEnt() {return new UnidadLexicaMultivaluada(alex.fila(), ClaseLexica.ENT,alex.lexema());}
	public UnidadLexica unidadReal() {return new UnidadLexicaMultivaluada(alex.fila(), ClaseLexica.REAL, alex.lexema());}
	public UnidadLexica unidadPComa() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.PCOMA);}
	public UnidadLexica unidadMas() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.MAS);}
	public UnidadLexica unidadPor() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.POR);}
	public UnidadLexica unidadPAper() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.PAPER);}
	public UnidadLexica unidadPCie() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.PCIE);}
	public UnidadLexica unidadIgual() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.EQ);}
	public UnidadLexica unidadSeparador() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.SEPARADOR);}
	public UnidadLexica unidadLT() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.LT);}
	public UnidadLexica unidadLE() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.LE);}
	public UnidadLexica unidadGT() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.GT);}
	public UnidadLexica unidadGE() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.GE);}
	public UnidadLexica unidadNEQ() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.NE);}
	public UnidadLexica unidadMenos() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.MENOS);}
	public UnidadLexica unidadDIV() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.DIV);}
	public UnidadLexica unidadAsignacion() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.ASIG);}
	public UnidadLexica unidadEof() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.EOF);}
	public UnidadLexica unidadId() {return new UnidadLexicaMultivaluada(alex.fila(), ClaseLexica.IDEN,alex.lexema());}
	public UnidadLexica unidadTEnt() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.TENT);}
	public UnidadLexica unidadTReal() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.TREAL);}
	public UnidadLexica unidadTBool() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.TBOOL);}
	public UnidadLexica unidadTrue() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.TRUE);}
	public UnidadLexica unidadFalse() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.FALSE);}
	public UnidadLexica unidadAnd() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.AND);}
	public UnidadLexica unidadOr() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.OR);}
	public UnidadLexica unidadNot() {return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.NOT);}
	
	public void error() {
		System.err.println("***"+alex.fila()+" Caracter inesperado: "+alex.lexema());
	}
}
