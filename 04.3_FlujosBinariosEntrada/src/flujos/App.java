package flujos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

	public static final int EOF = -1;

	public static void main(String[] args) {

		// Escribir los 256 bytes en un fichero
		try (FileInputStream fis = new FileInputStream("fichero1.dat");) {
			int b;
			System.out.println("Contenido de fichero1.dat");
			System.out.println("============================");
			while ((b = fis.read()) != EOF) {
				System.out.println(b);
			}
			System.out.println("\n\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Leer los 1000 primeros bytes de un fichero con readNBytes()
		try (FileInputStream fis = new FileInputStream("fichero2.dat");) {

			byte[] arr = fis.readNBytes(1000);
			int contador = 0;
			System.out.println("Contenido parcial de fichero2.dat");
			System.out.println("==================================");
			for (byte b : arr) {
				System.out.print("%2X ".formatted(b));
				contador++;
				if (contador == 30) {
					System.out.println();
					contador = 0;
				}
			}
			System.out.println("\n\n");


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Leer los 1000 primeros bytes (aproximadamente) de un fichero con BufferedInputStream
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("fichero2.dat"));) {

			// Aunque no es lo más operativo de cara a la lectura
			// leemos de 30 en 30 para dibujarlos mejor
			
			int TAM = 30;
			
			byte[] arr = new byte[TAM];
			
			int cantidadBytes = 0;
			int cantidadLeida = 0;
			
			System.out.println("Contenido parcial de fichero2.dat");
			System.out.println("==================================");

			while ((cantidadBytes = bis.read(arr)) != EOF && cantidadLeida <= 1000) {
				cantidadLeida += cantidadBytes;
				for(int i = 0; i < cantidadBytes; i++) {
					System.out.print("%2X ".formatted(arr[i]));
				}
				System.out.println();
			}
			System.out.println("\n\n");

			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
