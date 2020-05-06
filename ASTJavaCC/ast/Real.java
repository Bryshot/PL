package ast;

public class Real extends Numero{
        private String num;
        public Real(String num) {
         this.num = num;   
        }
        public String num() {return num;}
        public TipoE tipo() {return TipoE.REAL;}    
        public String toString()
        {
          return "NodoReal("+this.num.toString()+")";
        }
}