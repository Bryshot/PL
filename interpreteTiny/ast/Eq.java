package ast;

public class Eq extends EBin {
    public Eq(E opnd1, E opnd2) {
      super(opnd1,opnd2);  
    }     
    public TipoE tipo() {return TipoE.EQ;}

    public String toString()
    {
      return "{"+this.opnd1().toString() +" EQ "+this.opnd2().toString()+"}";
    }
 }
