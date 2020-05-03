package ast;

public class Var extends E {
    private String  var;
    public Var(String var) {
     this.var = var;   
    }
    public String var() {return var;}
    public TipoE tipo() {return TipoE.VAR;}     
    public String toString()
    {
      return "{"+this.var.toString() +"}";
    }
  }
