package ast;

public class Num extends E {
    private String num;
    public Num(String num) {
     this.num = num;   
    }
    public String num() {return num;}
    public TipoE tipo() {return TipoE.NUM;}    
    public String toString()
    {
      return "{"+this.num.toString()+"}";
    }
  }