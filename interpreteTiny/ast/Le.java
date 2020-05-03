package ast;

public class Le extends EBin {
    public Le(E opnd1, E opnd2) {
      super(opnd1,opnd2);  
    }     
    public TipoE tipo() {return TipoE.LE;}
    public String toString()
    {
      return "{"+this.opnd1().toString() +" LE "+this.opnd2().toString()+"}";
    }
 }
