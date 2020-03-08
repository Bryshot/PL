package asin;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main{
	public static void main(String[] args) throws Exception {
		if(args.length != 1)
			System.err.println("Es necesario determinar el archivo de entrada");
		else {
			try {
				AnalizadorSintactico asint = new AnalizadorSintactico(new FileReader(args[0]));
				asint.Sp();
			}
			catch(FileNotFoundException e) {
				System.err.println("No se encontró el archivo");
			}
		}
	}
}