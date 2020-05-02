package ast;

public class Neg extends E {
   private E exp;
   public Neg(E exp) {this.exp = exp;}
   public E exp() {return exp;}
   public TipoE tipo(){return TipoE.NEG;} 
}