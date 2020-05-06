package ast;

public class Ge extends EBin {
    public Ge(E opnd1, E opnd2) {
      super(opnd1,opnd2);  
    }     
    public TipoE tipo() {return TipoE.GE;}
    public String toString()
    {
      return "NodoGE("+this.opnd1().toString()+", "+this.opnd2().toString()+")";
    }
 }