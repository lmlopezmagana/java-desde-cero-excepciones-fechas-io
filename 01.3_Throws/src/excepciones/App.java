package excepciones;

import java.io.IOException;
import java.util.List;

public class App {

	
	public static void main(String[] args) {
		
		DataInput dataInput = new DataInput();
		
		try {
			List<Player> players = dataInput.readData();
			for(Player p : players)
				p.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	


}
