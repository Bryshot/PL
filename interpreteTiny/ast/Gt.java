package ast;

public class Gt extends EBin {
    public Gt(E opnd1, E opnd2) {
      super(opnd1,opnd2);  
    }     
    public TipoE tipo() {return TipoE.GT;} 
    public String toString()
    {
      return "{"+this.opnd1().toString() +" GT "+this.opnd2().toString()+"}";
    }
 }
