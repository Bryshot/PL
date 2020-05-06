package ast;

public class Asig  extends Inst {
    private String var;
    private E exp;
    public Asig(String var, E exp) {
      this.var = var;
      this.exp = exp;
    }
    
    public String var() {return var;}
    public E exp() {return exp;}
    public TipoInst tipo() {return TipoInst.ASIG;} 

    public String toString()
    {
      return "NodoAsig("+this.var.toString()+ ", "+ this.exp.toString()+")";
    }
 }
 
