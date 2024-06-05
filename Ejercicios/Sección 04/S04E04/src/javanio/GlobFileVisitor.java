package javanio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class GlobFileVisitor extends SimpleFileVisitor<Path> {
	
	// PathMatcher nos permite comprobar si un fichero cumple un patrón glob
	private final PathMatcher matcher;

    public GlobFileVisitor(String pattern) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (matcher.matches(file.getFileName())) {
            System.out.println(file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("Failed to access file: " + file + " (" + exc.getMessage() + ")");
        return FileVisitResult.CONTINUE;
    }

}
