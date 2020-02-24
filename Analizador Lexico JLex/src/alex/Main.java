package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
     Reader input = new InputStreamReader(new FileInputStream("input.txt"));
     AnalizadorLexicoCore al = new AnalizadorLexicoCore(input);
     UnidadLexica unidad;
     do {
       unidad = al.yylex();
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);
    }        
} 
