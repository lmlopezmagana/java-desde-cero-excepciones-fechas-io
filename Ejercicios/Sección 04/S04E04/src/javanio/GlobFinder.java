package javanio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class GlobFinder {

	public static void main(String[] args) {
		if (args.length < 2) {
            System.err.println("Uso: java GlobFinder <directorio> <patrón_glob>");
            System.exit(1);
        }

        Path startingDir = Paths.get(args[0]);
        String pattern = args[1];

        GlobFileVisitor visitor = new GlobFileVisitor(pattern);

        try {
            Files.walkFileTree(startingDir, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor);
        } catch (IOException e) {
            System.err.println("Error al recorrer el árbol de directorios: " + e.getMessage());
        }
	}

}
