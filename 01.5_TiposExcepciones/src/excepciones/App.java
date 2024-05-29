package excepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		
		// Excepcion no chequeada -> NullPointerException
		//int[] a = null;
		//System.out.println("Tamaño del array: %d".formatted(tam(a)));
		
		// Error -> StackOverflowError
		//long result = fibonacciInfinito(5);
		//System.out.println("El termino %d de la sucesión de Fibonacci es %d".formatted(5, result));
		
		// Excepcion chequeada -> IOException
		try {
			mostrarFicheroTexto("fichero.txt");
		} catch (NoSuchFileException e) {
			System.err.println("El fichero no existe");
		} catch (IOException e) {
			System.err.println("Error en la lectura del fichero");
		}
	}
	
	
	public static int tam(int[] array) {
		return array.length;
	}
	
	public static long fibonacciInfinito(long n) {
		if (n <= 1) 
			return fibonacciInfinito(n-1) + fibonacciInfinito(n-2);
		else 
			return fibonacciInfinito(n-1) + fibonacciInfinito(n-2);
		
	}
	
	public static void mostrarFicheroTexto(String path) throws IOException {
		
		List<String> contenido = Files.readAllLines(Paths.get(path));
		for(String linea : contenido)
			System.out.println(linea);
		
	}

}
