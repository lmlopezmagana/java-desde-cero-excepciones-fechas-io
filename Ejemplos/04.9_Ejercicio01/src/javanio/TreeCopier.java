package javanio;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class TreeCopier implements FileVisitor<Path> {

	private Path origen, destino;

	public TreeCopier(Path origen, Path destino) {
		super();
		this.origen = origen;
		this.destino = destino;
	}

	// Antes de visitar el fichero, creamos el nuevo directorio
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

		Path newDir = destino.resolve(origen.relativize(dir));

		try {
			Files.copy(dir, newDir);
		} catch (FileAlreadyExistsException e) {
			// La ignoramos. El directorio ya existe
		} catch (IOException e) {
			System.err.println("Error. No se puede crear el directorio %s (%s)".formatted(newDir, e));
			return SKIP_SUBTREE; // Dejamos sin copiar este subdirectorio
		}

		return CONTINUE;

	}

	// Copiamos el fichero
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		//CopyOption[] opciones = new CopyOption[] { REPLACE_EXISTING, ATOMIC_MOVE };

		Path destinoFichero = destino.resolve(origen.relativize(file));

		try {
			Files.copy(file, destinoFichero, REPLACE_EXISTING);
		} catch (IOException e) {
			System.err.println("Error al copiar el fichero %s (%s)".formatted(file, e));
		}

		return CONTINUE;

	}

	// Establecemos metadatos
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		Path newDir = destino.resolve(origen.relativize(dir));

		try {
			FileTime time = Files.getLastModifiedTime(dir);
			Files.setLastModifiedTime(dir, time);
		} catch (IOException e) {
			System.err.println("Error al copiar lo atributos de %s (%s)".formatted(newDir, e));
		}

		return CONTINUE;

	}

	// Gestionamos error
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		if (exc instanceof FileSystemLoopException) {
			System.err.println("Ciclo detectado: " + file);
		} else {
			System.err.println("Imposible copiar: %s: %s".formatted(file, exc));
		}
		return CONTINUE;

	}

}
