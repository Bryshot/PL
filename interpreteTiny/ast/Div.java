package ast;

public class Div extends EBin {
   public Div(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public TipoE tipo() {return TipoE.DIV;}

   public String toString()
   {
     return "("+this.opnd1().toString() +"/"+this.opnd2().toString()+")";
   }
}
