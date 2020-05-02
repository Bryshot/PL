package ast;

public class ASTiny {//Poner todas las constructoras

  public E suma(E opnd1, E opnd2) {return new Suma(opnd1,opnd2);}  
  public E resta(E opnd1, E opnd2) {return new Resta(opnd1,opnd2);}  
  public E mul(E opnd1, E opnd2) {return new Mul(opnd1,opnd2);}  
  public E div(E opnd1, E opnd2) {return new Div(opnd1,opnd2);}  
  public E and(E opnd1, E opnd2) {return new And(opnd1,opnd2);}   
  public E or(E opnd1, E opnd2) {return new Or(opnd1,opnd2);}   
  public E eq(E opnd1, E opnd2) {return new Eq(opnd1,opnd2);}   
  public E ne(E opnd1, E opnd2) {return new Ne(opnd1,opnd2);}  
  public E lt(E opnd1, E opnd2) {return new Lt(opnd1,opnd2);}   
  public E le(E opnd1, E opnd2) {return new Le(opnd1,opnd2);}   
  public E ge(E opnd1, E opnd2) {return new Ge(opnd1,opnd2);}   
  public E gt(E opnd1, E opnd2) {return new Gt(opnd1,opnd2);}   

  public E neg(E opnd1) {return new Neg(opnd1);}  
  
  public E num(String num) {return new Num(num);}  
  public E var(String var) {return new Var(var);}  
  public E trueFalse(String trueFalse) {return new TrueFalse(trueFalse);} 

  public Inst asig(String var, E exp){return new Asig(var,exp);}

  public LIs lSimple(Inst inst){return new LSimple(inst);}
  public LIs lCompuesta(LIs insts,Inst lSimple){return new LCompuesta(insts,lSimple);}

  public Dec decBool(String var){return new DecBool(var);}
  public Dec decInt(String var){return new DecInt(var);}
  public Dec decReal(String var){return new DecReal(var);}

  public LDs dSimple(Dec dec){return new DSimple(dec);}
  public LDs dCompuesta(LDs decs, Dec dec){return new DCompuesta(decs, dec);}

  public Prog programa(LDs decs, LIs insts){return new Programa(decs,insts);};

    
}
