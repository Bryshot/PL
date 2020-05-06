package ast;

public class Not extends EUnaria {
   private E exp;
   public Not(E exp) {this.exp = exp;}
   public E exp() {return exp;}
   public TipoE tipo(){return TipoE.NOT;} 
   public String toString()
   {
     return "NodoNot("+this.exp().toString() +")";
   }
}