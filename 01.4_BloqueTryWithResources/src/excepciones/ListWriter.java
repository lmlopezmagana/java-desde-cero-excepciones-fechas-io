		package excepciones;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListWriter {
	
	private List<Integer> list;
	private static final int SIZE = 10;
	
	public ListWriter() {
		list = new ArrayList<>(SIZE);
		Random r = new Random();
		for (int i = 0; i < SIZE; i++) {
			list.add(r.nextInt(1000));
		}
	}
	
	public void writeList() {
		
		//PrintWriter out = null;
		//FileWriter f = null;
		try (FileWriter f = new FileWriter("salida.txt");
			 PrintWriter out = new PrintWriter(f))
		{
			System.out.println("Hemos entrado en el bloque try");
			//f = new FileWriter("salida.txt");
			//out = new PrintWriter(f);
			for(int i = 0; i < SIZE; i++) {
				System.out.println("Valor en la posición %d = %d".formatted(i, list.get(i)));
				out.println(list.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
		    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
		    System.err.println("IOException: " + e.getMessage());
		} finally {
		    // No es necesario cerrar los flujos abiertos
			// Java se encarga por haberlos declarado y abierto
			// en try(...)
		}

		
	}
	

}
