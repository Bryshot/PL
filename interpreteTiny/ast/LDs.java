package ast;
public abstract class LDs  {
  public abstract TipoLDs tipo();
   public LDs decs() {throw new UnsupportedOperationException("decs");} 
   public Dec dec() {throw new UnsupportedOperationException("dec");}     
}
