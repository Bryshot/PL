package ast;

public class Entero extends Numero {
    private String num;
    public Entero(String num) {
         this.num = num;   
    }
    public String num() {return num;}
    public TipoE tipo() {return TipoE.ENTERO;}    
    public String toString()
    {
      return "NodoEntero("+this.num.toString()+")";
    }
}