package javanio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class App {

	public static void main(String[] args) {

		// COMPROBACIONES

		Path p1 = Paths.get("fichero1.txt");
		Path p2 = Paths.get("otrofichero1.txt");

		if (Files.exists(p1)) {
			System.out.println("El fichero %s existe".formatted(p1));
		} else if (Files.notExists(p1)) {
			System.out.println("El fichero %s no existe".formatted(p1));
		} else {
			System.out.println("No se puede confirmar la existencia de %s".formatted(p1));
		}

		if (Files.exists(p2)) {
			System.out.println("El fichero %s existe".formatted(p2));
		} else if (Files.notExists(p2)) {
			System.out.println("El fichero %s no existe".formatted(p2));
		} else {
			System.out.println("No se puede confirmar la existencia de %s".formatted(p2));
		}

		// COPIAR
		
		Path c = Paths.get("carpeta");
		Path f = Paths.get("fichero1.txt");
		Path c2 = Paths.get("carpeta2");
		
		try {
			if (Files.notExists(c))
				Files.createDirectory(c);
			
			Files.copy(Paths.get("fichero1.txt"), c.resolve(f), StandardCopyOption.REPLACE_EXISTING);
			
			// Copia el directorio pero no el contenido del mismo
			// Para copia recursiva se debería usar walkFileTree
			Files.copy(c, c2, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// BORRAR
		
		try {
			Files.delete(c2);
			//Files.delete(c2); // Error ya que no existe
			Files.deleteIfExists(c2); // No falla
			Files.delete(c.resolve(f));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
