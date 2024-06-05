package javanio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class App {

	public static void main(String[] args) {

		// MOVER
		/*
		 * Path f = Paths.get("fichero1.txt"); Path c = Paths.get("carpeta"); Path c2 =
		 * Paths.get("carpeta2");
		 * 
		 * try { Files.move(f, c.resolve(f), StandardCopyOption.REPLACE_EXISTING); }
		 * catch (IOException e) {
		 * System.err.println("Error al mover el archivo %s: %s".formatted(f,
		 * e.getLocalizedMessage())); }
		 * 
		 * 
		 * try { // Puede que no funcione igual en diferentes sistemas de ficheros o
		 * sistemas operativos Files.move(c, c2.resolve(c),
		 * StandardCopyOption.REPLACE_EXISTING); } catch (IOException e) {
		 * System.err.println("Error al mover el directorio %s: %s".formatted(c,
		 * e.getLocalizedMessage()));
		 * 
		 * }
		 */

		// LEER y ESCRIBIR

		try {
			List<String> contenido = Files.readAllLines(Paths.get("quijote.txt"));
			for (String s : contenido)
				System.out.println(s);

			contenido.add(0, "EL QUIJOTE");

			Files.write(Paths.get("quijote2.txt"), contenido, StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// LEER CON VERSIÓN INTEROPERABLE CON java.io

		
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("quijote2.txt"))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// CREAR UN FICHERO
		
		try {
			Path f3 = Paths.get("fichero3.txt");
			if (Files.notExists(f3))
				Files.createFile(f3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// CREAR DIRECTORIOS
		
		
		try {
			Path dir = Paths.get(".", "dir1", "dir2", "dir3");
			Files.createDirectories(dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// LISTAR DIRECTORIOS
		
		Path dirActual = Paths.get(".");
		try (DirectoryStream<Path> content = Files.newDirectoryStream(dirActual)) {
			
			System.out.println("Contenido del directorio %s".formatted(dirActual));
			for (Path p : content)
				System.out.println(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// LISTAR DIRECTORIOS CON FILTRO GLOB
		
		String pattern = "*.txt";
		try (DirectoryStream<Path> content = Files.newDirectoryStream(dirActual, pattern)) {
			
			System.out.println("Contenido del directorio %s que cumple con el patrón %s".formatted(dirActual, pattern));
			for (Path p : content)
				System.out.println(p.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// OPERACIONES RECURSIVAS Y FILEVISITOR
		
		try {
			System.out.println();
			System.out.println("Mostrando el contenido de %s".formatted(dirActual));
			Files.walkFileTree(dirActual, new PrintFiles(dirActual));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
