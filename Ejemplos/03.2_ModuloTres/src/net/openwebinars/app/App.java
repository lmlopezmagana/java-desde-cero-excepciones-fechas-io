package net.openwebinars.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.openwebinars.lib.Libreria;
import net.openwebinars.util.CalculoNotas;
import net.openwebinars.util.Nota;

public class App {
	
	public static void main(String[] args) {
		
		// No es visible porque no está exportada
		// OtraClase c = new OtraClase();
		
		Nota[] notas = {
	            // Matemáticas
	            new Nota("Matemáticas", 8.5),
	            new Nota("Matemáticas", 9.3),
	            new Nota("Matemáticas", 7.8),
	            new Nota("Matemáticas", 6.2),

	            // Física
	            new Nota("Física", 7.1),
	            new Nota("Física", 8.0),
	            new Nota("Física", 6.7),
	            new Nota("Física", 9.4),

	            // Computación
	            new Nota("Computación", 8.8),
	            new Nota("Computación", 7.5),
	            new Nota("Computación", 9.9),
	            new Nota("Computación", 6.3)
	        };
		
		
		Map<String, Double> resultados = CalculoNotas.notasMedias(Arrays.asList(notas));
		
		for(String asignatura : resultados.keySet()) {
			System.out.println("La nota media de %s es %.2f".formatted(asignatura, resultados.get(asignatura)));
		}
		
		
		System.out.println("La media de todas las asignaturas es %.2f"
				.formatted(
							Libreria.media(List.copyOf(resultados.values()))
							)
				);
		
	}

}
