package javanio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

	public static void main(String[] args) {
		
		// CREAR
		
		// Una ruta absoluta que no existe
		Path p1 = Paths.get("/tmp/foo"); 
		
		// Misma ruta de antes sin separador
		Path p2 = Paths.get("tmp","foo"); 
		
		// Una ruta relativa que sí existe
		Path p3 = Paths.get("fichero1.txt"); 
		
		// Paths.get es un atajo de este método
		Path p4 = FileSystems.getDefault().getPath("fichero1.text"); 
		
		// Usando variables de entorno
		Path p5 = Paths.get(System.getProperty("user.home"), "logs", "foo.log"); 

		
		System.out.println(p3.toAbsolutePath());
		System.out.println(p5.toAbsolutePath());
		
		// OBTENER INFORMACIÓN
		
		System.out.println();
		System.out.println("Filename %s".formatted(p5.getFileName()));
		System.out.println("Parent %s".formatted(p5.getParent()));
		System.out.println("Root %s".formatted(p5.getRoot()));
		
		// UNIR, NORMALIZAR, ...
		
		Path p6 = Paths.get(System.getProperty("user.home"), "Documents", "..", "Documents");
		Path p7 = Paths.get("fichero.txt");
		Path union = p6.resolve(p7);
		
		System.out.println();
		System.out.println(union.toAbsolutePath());
		
		// Elimina redundancias
		System.out.println(union.normalize().toAbsolutePath());
		
		// Falla si el fichero no existe
		
		try {
			System.out.println(union.toRealPath());
		} catch (IOException e) {
			System.err.println("Error. Probablemente el fichero no existe");
		}
		
		// Como el fichero sí existe, no falla.
		// Elimina redundancias, sigue enlaces simbólicos
		
		try {
			System.out.println(p3.toRealPath());
		} catch (IOException e) {
			System.err.println("Error. Probablemente el fichero no existe");
		}
		
	
		// COMPARAR
		
		Path p8 = Paths.get(System.getProperty("user.home"), "Documents", "fichero.txt");
		
		if (union.equals(p8))
			System.out.println("%s y %s son iguales".formatted(union, p8));
		else
			System.out.println("%s y %s NO son iguales".formatted(union, p8));

		if (union.normalize().equals(p8))
			System.out.println("%s y %s son iguales".formatted(union.normalize(), p8));
		else
			System.out.println("%s y %s NO son iguales".formatted(union.normalize(), p8));
		
		
	}

}
