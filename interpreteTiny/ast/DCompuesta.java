package ast;

public class DCompuesta extends LDs {
   private Dec dec;
   private LDs decs;
   public DCompuesta(LDs decs,Dec dec) {
     this.decs = decs;  
     this.dec = dec;
   }
   
   public LDs decs() {return decs;}
   public Dec dec() {return dec;}
   public TipoLDs tipo() {return TipoLDs.DCOMPUESTA;} 
}
