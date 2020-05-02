package constructorast;

import ast.E;

public class ResulD {
  private String id;
  private E exp;
  public ResulD(String id, E exp) {
     this.id = id;
     this.exp  = exp;
  }
  public E exp() {return exp;}  
  public String id() {return id;}  
}
