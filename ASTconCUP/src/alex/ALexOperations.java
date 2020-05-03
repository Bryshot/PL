package alex;

import constructorast.ClaseLexica;

public class ALexOperations {
	private AnalizadorLexicoCore alex;
	public ALexOperations(AnalizadorLexicoCore alex) {
		this.alex = alex;   
	}
  
	
	public UnidadLexica unidadEnt() {return new UnidadLexica(alex.fila(), ClaseLexica.ENT,alex.lexema());}
	public UnidadLexica unidadReal() {return new UnidadLexica(alex.fila(), ClaseLexica.REAL, alex.lexema());}
	public UnidadLexica unidadPComa() {return new UnidadLexica(alex.fila(), ClaseLexica.PCOMA,";");}
	public UnidadLexica unidadMas() {return new UnidadLexica(alex.fila(), ClaseLexica.MAS,"+");}
	public UnidadLexica unidadPor() {return new UnidadLexica(alex.fila(), ClaseLexica.POR,"*");}
	public UnidadLexica unidadPAper() {return new UnidadLexica(alex.fila(), ClaseLexica.PAPER,"(");}
	public UnidadLexica unidadPCie() {return new UnidadLexica(alex.fila(), ClaseLexica.PCIE,")");}
	public UnidadLexica unidadIgual() {return new UnidadLexica(alex.fila(), ClaseLexica.EQ,"=");}
	public UnidadLexica unidadSeparador() {return new UnidadLexica(alex.fila(), ClaseLexica.SEPARADOR,"&&");}
	public UnidadLexica unidadLT() {return new UnidadLexica(alex.fila(), ClaseLexica.LT,"<");}
	public UnidadLexica unidadLE() {return new UnidadLexica(alex.fila(), ClaseLexica.LE,"<=");}
	public UnidadLexica unidadGT() {return new UnidadLexica(alex.fila(), ClaseLexica.GT,">");}
	public UnidadLexica unidadGE() {return new UnidadLexica(alex.fila(), ClaseLexica.GE,">=");}
	public UnidadLexica unidadNEQ() {return new UnidadLexica(alex.fila(), ClaseLexica.NE,"!=");}
	public UnidadLexica unidadMenos() {return new UnidadLexica(alex.fila(), ClaseLexica.MENOS,"-");}
	public UnidadLexica unidadDIV() {return new UnidadLexica(alex.fila(), ClaseLexica.DIV,"/");}
	public UnidadLexica unidadAsignacion() {return new UnidadLexica(alex.fila(), ClaseLexica.ASIG,"=");}
	public UnidadLexica unidadEof() {return new UnidadLexica(alex.fila(), ClaseLexica.EOF,"<EOF>");}
	public UnidadLexica unidadId() {return new UnidadLexica(alex.fila(), ClaseLexica.IDEN,alex.lexema());}
	public UnidadLexica unidadTEnt() {return new UnidadLexica(alex.fila(), ClaseLexica.TENT,alex.lexema());}
	public UnidadLexica unidadTReal() {return new UnidadLexica(alex.fila(), ClaseLexica.TREAL,alex.lexema());}
	public UnidadLexica unidadTBool() {return new UnidadLexica(alex.fila(), ClaseLexica.TBOOL,alex.lexema());}
	public UnidadLexica unidadTrue() {return new UnidadLexica(alex.fila(), ClaseLexica.TRUE,alex.lexema());}
	public UnidadLexica unidadFalse() {return new UnidadLexica(alex.fila(), ClaseLexica.FALSE,alex.lexema());}
	public UnidadLexica unidadAnd() {return new UnidadLexica(alex.fila(), ClaseLexica.AND,alex.lexema());}
	public UnidadLexica unidadOr() {return new UnidadLexica(alex.fila(), ClaseLexica.OR,alex.lexema());}
	public UnidadLexica unidadNot() {return new UnidadLexica(alex.fila(), ClaseLexica.NOT,alex.lexema());}
	
}
