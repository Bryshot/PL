package ast;

public class DecInt  extends Dec {
    private String var;
    public DecInt(String var) {
      this.var = var;
    }
    
    public String var() {return var;}
    public TipoDec tipo() {return TipoDec.INT;} 
    
    public String toString()
    {
      return "NodoDecInt("+this.var.toString()+")";
    }
 }
 
