package excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListReader {
	
	private List<Integer> list;
	private static final int SIZE = 10;
	
	public ListReader() {
		list = new ArrayList<>(SIZE);
	}

	public void readList() {
		try (FileReader fr = new FileReader("salida.txt");
		         BufferedReader br = new BufferedReader(fr)) {
			String linea;
			while ((linea = br.readLine()) != null) {
				int num = Integer.valueOf(linea);
				System.out.println("Número leído del fichero: %d".formatted(num));
				list.add(num);
			}
		} catch (IOException e) {
			System.err.println("Error en la lectura del fichero");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Error al convertir en número");
			e.printStackTrace();
		}
	}
	

}
