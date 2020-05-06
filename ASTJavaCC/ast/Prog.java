package ast;

public abstract class Prog {

    public LIs insts() {throw new UnsupportedOperationException("insts");}
    public LDs decs() {throw new UnsupportedOperationException("decs");}
    public abstract TipoProg tipo();
    
}
