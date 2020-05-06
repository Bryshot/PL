package ast;

public class DecBool  extends Dec {
    private String var;
    public DecBool(String var) {
      this.var = var;
    }
    
    public String var() {return var;}
    public TipoDec tipo() {return TipoDec.BOOL;} 

    public String toString()
    {
      return "NodoDecBool("+this.var.toString()+")";
    }
 }