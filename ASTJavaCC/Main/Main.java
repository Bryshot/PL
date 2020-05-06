package Main;

import java.io.FileReader;

import constructorast.ConstructorASTCore;

public class Main {
	public static void main(String[] args) throws Exception {
	    ConstructorASTCore cast = new ConstructorASTCore(new FileReader(args[0]));
	    cast.Sp();
	    
	  }
}
