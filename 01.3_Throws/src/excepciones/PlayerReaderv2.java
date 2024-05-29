package excepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PlayerReaderv2 {
	
	public List<String> readPlayers(String filename) throws IOException {
		Path path = Paths.get(filename);
		List<String> players;
		try {
			players = Files.readAllLines(path);
		} catch (NoSuchFileException e) {
			System.err.println("Fichero no encontrado");
			throw e;
		}
	    		
	    return players;
	}

}
 