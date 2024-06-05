package excepciones;

import java.util.List;

public class ReadData {
	
	private static final int EXPECTED = 5 * 1000; 
	
	public List<String> readData() throws TimeoutException {
		
		long init = System.currentTimeMillis();
		// Simulamos tardar más tiempo del deseado
		List<String> result = getDataFromInternet();
		long finish = System.currentTimeMillis();
		
		if (finish - init > EXPECTED) {
			throw new TimeoutException();
		}
		
		return result;
		
	}
	
	private List<String> getDataFromInternet() {

		try {
			for(int i = 0; i < 6 + 1; i++) {
				Thread.sleep(1 * 1000);
				System.out.println("Esperando datos...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return List.of("One", "Two", "Three");
	}

}
