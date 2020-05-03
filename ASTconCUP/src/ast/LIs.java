package ast;

public abstract class LIs  {
    public abstract TipoLIs tipo();
     public Inst inst() {throw new UnsupportedOperationException("inst");} 
     public LIs lInst(){throw new UnsupportedOperationException("lInst");}
     public String id() {throw new UnsupportedOperationException("id");}           
     public E exp() {throw new UnsupportedOperationException("exp");}  
  }
