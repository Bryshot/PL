package eval;

import java.util.HashMap;
import java.util.Map;
import ast.*;
import java.io.FileReader;


public class Eval {
  private Map<String,Double> binds;
  public Eval() {
    binds = new HashMap<String,Double>();  
  }
  public double eval(Prog s) {
   binds(s);
   return eval(s.insts());    
  }  
  private void binds(Prog s) {
     binds.clear();   
     mkBinds(s.decs());
  }
  private void mkBinds(LDs decs) {
     if (decs.tipo() == TipoLDs.DCOMPUESTA) mkBinds(decs.decs());
     binds.put(decs.dec().var(),0.0);
  }
 
  private double valorDe(String id) {
    Double v = binds.get(id);
    if (v==null) v=0.0;
    return v;
  } 
  private void actualiza(String id, double v) {
    binds.put(id,v);
  } 
  private double eval(E exp) {
     switch(exp.tipo()) {
        // case REAL: return Double.valueOf(exp.val()).doubleValue();
        // case ENTERO: return Integer.valueOf(exp.val()).intValue();
        // case ID: return valorDe(exp.id()); 
         case TrueFalse: return eval(exp.opnd1())/eval(exp.opnd2());   
         case VAR: return valorDe(exp.var());
         case NUM: return Double.valueOf(exp.num()).intValue();
         case SUMA: return eval(exp.opnd1())+eval(exp.opnd2());    
         case RESTA: return eval(exp.opnd1())-eval(exp.opnd2());    
         case MUL: return eval(exp.opnd1())*eval(exp.opnd2());    
         case DIV: return eval(exp.opnd1())/eval(exp.opnd2());    
         case AND: return eval(exp.opnd1())/eval(exp.opnd2());    
         case OR: return eval(exp.opnd1())-eval(exp.opnd2());    
         case GE: return eval(exp.opnd1())*eval(exp.opnd2());    
         case GT: return eval(exp.opnd1())/eval(exp.opnd2());     
         case LE: return eval(exp.opnd1())+eval(exp.opnd2());    
         case LT: return eval(exp.opnd1())-eval(exp.opnd2());    
         case EQ: return eval(exp.opnd1())*eval(exp.opnd2());    
         case NE: return eval(exp.opnd1())/eval(exp.opnd2()); 
         case NEG: return eval(exp.opnd1())/eval(exp.opnd2());
         default: return -1;    
     } 
  }
  

  public static void main(String[] args) throws Exception {
    ConstructorASTTiny cast = new ConstructorASTTiny(new FileReader(args[0]));
    Eval eval = new Eval();
    System.out.println(eval.eval(cast.Sp()));
  }
}
