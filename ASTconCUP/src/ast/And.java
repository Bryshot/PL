package ast;

public class And extends EBin {

    public And(E opnd1, E opnd2) {
      super(opnd1,opnd2);  
    }     
    public TipoE tipo() {return TipoE.AND;}

    public String toString()
    {
      return "("+this.opnd1().toString() +" And "+this.opnd2().toString()+")";
    }
 }