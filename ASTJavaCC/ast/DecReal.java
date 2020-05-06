package ast;

public class DecReal extends Dec {
    private String var;
    public DecReal(String var) {
      this.var = var;
    }
    
    public String var() {return var;}
    public TipoDec tipo() {return TipoDec.REAL;} 
    public String toString()
    {
      return "NodoDecReal("+this.var.toString()+")";
    }
}