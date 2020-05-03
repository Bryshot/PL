package ast;

public abstract class Inst  {
    public abstract TipoInst tipo();
     public String var() {throw new UnsupportedOperationException("var");} 
     public E exp() {throw new UnsupportedOperationException("exp");}           
  }