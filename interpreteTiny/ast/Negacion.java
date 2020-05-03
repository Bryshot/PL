package ast;

public class Negacion extends EUnaria {
    private E exp;
    public Negacion(E exp) {
        this.exp = exp;
    }
    public E exp() {return exp;}
    public TipoE tipo(){return TipoE.NEGACION;} 
    public String toString()
    {
      return "("+"-"+this.exp().toString() +")";
    }
 }