package ast;

public class Suma extends EBin {
   public Suma(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public TipoE tipo() {return TipoE.SUMA;}
   public String toString()
   {
     return "NodoSuma("+this.opnd1().toString() +", "+this.opnd2().toString()+")";
   }
}
