package ast;

public class LSimple  extends LIs {
    
   private Inst inst;
    public LSimple(Inst inst) {
      this.inst = inst;
    }
    
    public Inst inst() {return inst;}
    public TipoLIs tipo() {return TipoLIs.LSIMPLE;} 

    public String toString()
    {
      return "{"+this.inst.toString()+"}";
    }
 }
 
