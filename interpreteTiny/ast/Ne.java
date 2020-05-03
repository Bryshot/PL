package ast;

public class Ne extends EBin {
    public Ne(E opnd1, E opnd2) {
      super(opnd1,opnd2);  
    }     
    public TipoE tipo() {return TipoE.NE;}
    public String toString()
    {
      return "{"+this.opnd1().toString() +" != "+this.opnd2().toString()+"}";
    }
 }
