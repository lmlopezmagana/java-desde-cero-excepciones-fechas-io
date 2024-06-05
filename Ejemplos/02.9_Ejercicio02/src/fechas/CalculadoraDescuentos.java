package fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;

public class CalculadoraDescuentos {
	
	public static final double DESCUENTO_CUMPLE = 0.2;
	public static final double DESCUENTO_EDAD_REDONDA = 0.05;
	
	
	public static double descuentoHoy(Cliente c) {
		
		double descuento = 0.0;
				
		if (monthDayBetween(c.getFechaNacimiento(), 
				LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)),
				LocalDate.now().plusWeeks(1).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))) 
				 
			|| monthDayBetween(c.getFechaNacimiento(), 
						LocalDate.now().minusWeeks(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)),
						LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))) ) {
			descuento = DESCUENTO_CUMPLE;
			
			// Descuento especial para edad redonda en la semana del cumpleaños
			if (edadRedonda(c) && 
					(monthDayBetween(c.getFechaNacimiento(), 
							LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)),
							LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))))) {
				descuento += DESCUENTO_EDAD_REDONDA;
			}
			
			
			
		}
		return descuento;
	}
	
	public static void periodoDescuentoAnioActual(Cliente c) {
		
		// Calculamos la fecha del cumpleaños en el año actual
		LocalDate cumple = MonthDay.from(c.getFechaNacimiento()).atYear(Year.now().getValue());

		// Calculamos los intervalos de la semana del cumpleaños y la siguiente
		LocalDate inicioSemana1 = cumple.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		LocalDate finSemana1 = cumple.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		LocalDate inicioSemana2 = finSemana1.plusDays(1);
		LocalDate finSemana2 = inicioSemana2.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		if (edadRedonda(c)) {
			
			System.out.println("Desde el %s hasta el %s el descuento es de %.2f%%".formatted(
					inicioSemana1.format(dtf),
					finSemana1.format(dtf),
					(DESCUENTO_CUMPLE + DESCUENTO_EDAD_REDONDA)*100));
			System.out.println("Desde el %s hasta el %s el descuento es de %.2f%%".formatted(
					inicioSemana2.format(dtf),
					finSemana2.format(dtf),
					DESCUENTO_CUMPLE*100));
			
		} else {
			System.out.println("Desde el %s hasta el %s el descuento es del %.2f%%".formatted(
					inicioSemana1.format(dtf),
					finSemana2.format(dtf),
					DESCUENTO_CUMPLE*100));
			
		}
		
	}
	
		
	public static boolean monthDayBetween(LocalDate fecha, LocalDate fechaInicio, LocalDate fechaFin) {
		
		MonthDay md = MonthDay.from(fecha);
		MonthDay inicio = MonthDay.from(fechaInicio);
		MonthDay fin = MonthDay.from(fechaFin);
		
		return (md.equals(inicio) || md.isAfter(inicio)) &&
				(md.equals(fin) || md.isBefore(fin));
						
		
    }
	
	public static boolean edadRedonda(Cliente c) {
		return c.getEdadFinAnio() % 5 == 0 || c.getEdadFinAnio() % 10 == 0;
	}
	
	

}
