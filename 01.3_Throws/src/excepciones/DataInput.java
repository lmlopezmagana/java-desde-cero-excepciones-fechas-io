package excepciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataInput {
	
	private PlayerReaderv2 playerReader;
	
	public DataInput() {
		playerReader = new PlayerReaderv2();
	}
	
	public List<Player> readData() throws IOException {
		List<String> list = playerReader.readPlayers("players.dat");
		List<Player> result = new ArrayList<>();
		
		for (String s : list) {
			result.add(new Player(s.split(",")[1], s.split(",")[0]));
		}
		return result;
	}

}
