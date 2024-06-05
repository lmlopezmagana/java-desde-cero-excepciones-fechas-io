package javanio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintFiles extends SimpleFileVisitor<Path> {
	
	private Path basedir;
	
	public PrintFiles(Path basedir) {
		this.basedir = basedir;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		
		Path parent = basedir.toAbsolutePath().getParent();
		
		System.out.println("%s (%s) (%d bytes)"
				.formatted(file.getFileName(), 
							file.toAbsolutePath().normalize().subpath(basedir.toAbsolutePath().normalize().getNameCount()-1, file.toAbsolutePath().normalize().getNameCount()-1),
							attrs.size()));
		return FileVisitResult.CONTINUE;
		
		
	}
	
	

}
