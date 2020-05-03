package ast;

public class Programa extends Prog{
    private LIs insts;
    private LDs decs;
	public Programa(LDs decs, LIs insts) 
    {
        this.insts = insts; 
        this.decs = decs;
    }
    public LIs exp() {return insts;}
    public LDs decs() {return decs;}
    public TipoProg tipo(){return TipoProg.PROGRAMA;} 

    public String toString()
    {
        return this.decs.toString() + "\n"+this.insts.toString();
    }
}
