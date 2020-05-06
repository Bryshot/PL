package ast;

public class LCompuesta extends LIs{

    private Inst inst;
    private LIs lInst;
    public LCompuesta(LIs lInst,Inst inst) {
      this.lInst = lInst;  
      this.inst = inst;
    }
    
    public LIs lInst() {return lInst;}
    public Inst inst() {return inst;}
    public TipoLIs tipo() {return TipoLIs.LCOMPUESTA;} 
    public String toString()
    {
      return "NodoListaInstComp("+this.lInst().toString() +", "+this.inst.toString()+")";
    }
}
