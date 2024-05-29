package fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		LocalDate hoy = LocalDate.now();
		LocalDate dosMil = LocalDate.of(2000, 1, 1);
		LocalDate fecha = LocalDate.ofYearDay(2024, 256); 
		LocalDate fecha2 = LocalDate.parse("2024-01-01");
		
		List<LocalDate> fechas = List.of(hoy, dosMil, fecha, fecha2);
		
		for(LocalDate l : fechas)
			System.out.println(l);
		System.out.println();
		
		LocalDate manana = hoy.plusDays(1);
		LocalDate dosMilMenosUno = dosMil.minusDays(1);
		
		List<LocalDate> otrasFechas = List.of(manana, dosMilMenosUno);
		
		for(LocalDate l : otrasFechas)
			System.out.println(l);
		System.out.println();
		
		LocalDate fecha3 = fecha.plus(110, ChronoUnit.DAYS);
		LocalDate fecha4 = fecha.minus(Period.ofDays(256));
		
		List<LocalDate> otrasFechas2 = List.of(fecha3, fecha4);
		
		for(LocalDate l : otrasFechas2)
			System.out.println(l);
		System.out.println();
		
		
		if (fecha3.isAfter(fecha4))
			System.out.println("La fecha %s es posterior a la fecha %s".formatted(fecha3, fecha4));
		System.out.println();
		
		
		long diferencia = fecha4.until(fecha3, ChronoUnit.MONTHS);
		System.out.println("Diferencia en meses entre %s y %s: %d"
							.formatted(fecha4, fecha3, diferencia));
		System.out.println();
		
		LocalDate dosMilTreinta = LocalDate.now().withYear(2030);
		System.out.println(dosMilTreinta.toString());
		System.out.println();
		
		System.out.println("Ejemplos de TemporalAdjusters");
		System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));
		System.out.println();
		
		
		
	}

}
