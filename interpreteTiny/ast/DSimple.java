package ast;

public class DSimple extends LDs {
   private Dec dec;
   public DSimple(Dec dec) {
     this.dec = dec;
   }
   
   public Dec dec() {return dec;}
   public TipoLDs tipo() {return TipoLDs.DSIMPLE;} 

   public String toString()
   {
     return "("+this.dec.toString()+")";
   }
}
