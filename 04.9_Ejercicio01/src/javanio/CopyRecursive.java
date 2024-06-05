package javanio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.Scanner;

public class CopyRecursive {
	
	public static void main(String[] args) {
		
		
		
		if (args.length != 2) {
			System.err.println("Error en el número de argumentos. java CopyRecursive <origen> <destino>");
			System.exit(-1);
		}
		
		Path origen = Paths.get(args[0]);
		
		Path destino = Paths.get(args[1]);
		Path absoluteDestino = destino.toAbsolutePath().normalize();
		
		if (Files.exists(origen) && Files.isDirectory(origen)) {
			boolean overwrite = false;
			
			if (Files.exists(destino)) {
				System.out.println("La carpeta de destino (%s) existe. ¿Desea sobreescribirla? (Sí/No)".formatted(absoluteDestino));
				var sc = new Scanner(System.in);
				boolean continuar = true;
				while(continuar) {
					String op = sc.nextLine().toLowerCase();
					if (op.contentEquals("s") || op.contentEquals("sí") || op.contentEquals("si")) {
						overwrite = true;
						continuar = false;
					} else if (op.contentEquals("n") || op.contentEquals("no")) {
						continuar = false;
					} else {
						System.out.println("La carpeta de destino (%s) existe. ¿Desea sobreescribirla? (Sí/No)".formatted(absoluteDestino));
					}
				}
			}
			
			if ((Files.exists(destino) && overwrite) || Files.notExists(destino)) {
				EnumSet<FileVisitOption> opciones = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
				TreeCopier treeCopier = new TreeCopier(origen, destino);
				try {
					Files.walkFileTree(origen, opciones, Integer.MAX_VALUE, treeCopier);
				} catch (IOException e) {
					System.err.println("Error en el proceso de copiado: %s".formatted(e));
				}
			}
			
		} else {
			System.out.println("No existe la ruta %s o no es un directorio".formatted(origen));
		}
		
		
		
		
	}
	
	

}
