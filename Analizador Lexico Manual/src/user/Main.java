package user;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import alex.AnalizadorLexicoCore;
import alex.ClaseLexica;
import alex.UnidadLexica;

public class Main {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.err.println("Se debe proporcionar como argumento un único archivo para procesar");
			System.exit(-1);
		}
		
		try {
			FileReader fr = new FileReader(args[0]);
			AnalizadorLexicoCore alex = new AnalizadorLexicoCore(fr);
			UnidadLexica sigToken = alex.sigToken();
			while(sigToken.clase() != ClaseLexica.EOF) {
				System.out.println(sigToken);
				sigToken = alex.sigToken();
			}
		} 
		catch (FileNotFoundException e) {
			System.err.println("No se encontró el archivo especificado");
			System.exit(-1);
		} 
		catch (IOException e) {
			System.err.println("Error mientras se leía el archivo");
			System.exit(-1);
		}

	}

}
