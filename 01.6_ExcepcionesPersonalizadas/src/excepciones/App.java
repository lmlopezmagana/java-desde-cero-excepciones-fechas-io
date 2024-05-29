package excepciones;

import java.util.List;

public class App {
	
	public static void main(String[] args) {
		
		
		ReadData readData = new ReadData();
		
		try {
			List<String> result = readData.readData();
			for(String s : result)
				System.out.println(s);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		
	}

}
