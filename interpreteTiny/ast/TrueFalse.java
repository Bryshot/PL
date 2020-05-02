package ast;

public class TrueFalse extends E{
    private String trueFalse;
    public TrueFalse(String trueFalse) {
     this.trueFalse = trueFalse;   
    }
    public String trueFalse() {return trueFalse;}
    public TipoE tipo() {return TipoE.TrueFalse;}    
}
