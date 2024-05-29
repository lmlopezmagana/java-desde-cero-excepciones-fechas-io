package fechas;

import java.time.LocalDate;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("José", "Pérez Muñoz", LocalDate.of(2000, 6, 1));
		Cliente c2 = new Cliente("Ana", "García Jiménez", LocalDate.of(1999, 5, 30));
		Cliente c3 = new Cliente("María", "Martín Sánchez", LocalDate.of(1998, 12, 23));

		
		System.out.println("Descuento %.2f%%".formatted(CalculadoraDescuentos.descuentoHoy(c1) * 100));
		System.out.println("Descuento %.2f%%".formatted(CalculadoraDescuentos.descuentoHoy(c2) * 100));
		System.out.println("Descuento %.2f%%".formatted(CalculadoraDescuentos.descuentoHoy(c3) * 100));



	}
}
