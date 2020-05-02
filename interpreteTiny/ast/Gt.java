package ast;

public class Gt extends EBin {
    public Gt(E opnd1, E opnd2) {
      super(opnd1,opnd2);  
    }     
    public TipoE tipo() {return TipoE.GT;}
 }
