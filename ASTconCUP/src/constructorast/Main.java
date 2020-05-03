package constructorast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoCore;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream("a.txt"));
	 AnalizadorLexicoCore alex = new AnalizadorLexicoCore(input);
	 parser constructorast = new parser(alex);
	 System.out.println(constructorast.parse().value);
 }
}   
   
