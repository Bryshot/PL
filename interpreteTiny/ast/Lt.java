package ast;

public class Lt extends EBin {
    public Lt(E opnd1, E opnd2) {
      super(opnd1,opnd2);  
    }     
    public TipoE tipo() {return TipoE.LT;}
    public String toString()
    {
      return "("+this.opnd1().toString() +" < "+this.opnd2().toString()+")";
    }
 }
