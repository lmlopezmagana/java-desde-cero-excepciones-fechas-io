package flujos;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class App {

	public static void main(String[] args) {
		
		// Escribir los 256 bytes en un fichero
		try (FileOutputStream fos = new FileOutputStream("fichero1.dat");){
			
			for(int i = 0; i < 256; i++) {
				fos.write(i);
			}
					
		} catch (FileNotFoundException e) {  
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// Escribir un array de bytes aleatorios en un fichero
		// usando buffering
		try (BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream("fichero2.dat"));) {
			
			int tamArray = (1024 * 16) + 123; // 16kb y pico, para que no sea múltiplo de 2 
			
			byte[] arr = new byte[tamArray]; 
			Random r = new Random();
			r.nextBytes(arr);
			
			// Escribimos de 8kb en 8b
			int TAM_BUFFER = 8*1024;
			
			int contador = 0;
			while (contador < tamArray) {
				int len = (tamArray - contador > TAM_BUFFER) ?
						TAM_BUFFER : tamArray - contador;
				bos.write(arr, contador, len);
				contador += TAM_BUFFER;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
