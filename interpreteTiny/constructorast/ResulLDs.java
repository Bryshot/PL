package constructorast;

import ast.LDs;

public class ResulLDs {
  private LDs a;
  private boolean hayDefinicion;   
  public ResulLDs() {
    hayDefinicion = false;
    a = null;
  }
  public ResulLDs(LDs def) {
    hayDefinicion = true;
    this.a = def;
  }
  public LDs a() {return a;}
  public boolean hayDefinicion() {return hayDefinicion;}
}
