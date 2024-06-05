package excepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PlayerReader {
	
	public List<String> readPlayers(String filename) throws IOException {
		Path path = Paths.get(filename);
	    List<String> players = Files.readAllLines(path);
	    return players;
	}

}
 