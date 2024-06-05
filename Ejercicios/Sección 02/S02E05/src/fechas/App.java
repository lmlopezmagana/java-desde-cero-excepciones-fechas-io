package fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class App {

	public static void main(String[] args) {
		LocalDate fecha = LocalDate.now();
		
		String respuesta = fecha.query(martes13()) ? "sí" : "no";
		
		System.out.println("El %s %s es martes y 13".formatted(fecha, respuesta));
		
		System.out.println("El siguiente martes y 13 será %s".formatted(proximoMartes13()));

	}
	
	
	
	public static TemporalQuery<Boolean> martes13() {
		return new TemporalQuery<Boolean>() {

			@Override
			public Boolean queryFrom(TemporalAccessor date) {
				return ((date.get(ChronoField.DAY_OF_MONTH) == 13) &&
		                (date.get(ChronoField.DAY_OF_WEEK) == 5));
			}
			
		};
	}
	
	public static LocalDate siguienteMartes13(LocalDate fecha) {
		LocalDate fechaBusq = fecha.withDayOfMonth(13);
		
		if (fechaBusq.isBefore(fecha) || fechaBusq.isEqual(fecha)) {
			fechaBusq = fechaBusq.plusMonths(1).withDayOfMonth(13);
		}
		
		while (fechaBusq.getDayOfWeek() != DayOfWeek.TUESDAY) {
			fechaBusq = fechaBusq.plusMonths(1).withDayOfMonth(13);			
		}
		
		return fechaBusq;
	}
	
	public static LocalDate proximoMartes13() {
		return siguienteMartes13(LocalDate.now());
	}

}
