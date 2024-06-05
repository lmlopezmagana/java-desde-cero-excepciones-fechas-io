package fechas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime dosMilMedioDia = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
		LocalDateTime fromInstant = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC); 
		LocalDateTime parseada = LocalDateTime.parse("2022-12-03T10:15:30");
		
		List<LocalDateTime> fechas = List.of(ahora, dosMilMedioDia, fromInstant, parseada);
		
		for(LocalDateTime l : fechas)
			System.out.println(l);
		System.out.println();
		
		LocalDateTime unMinutoMas = ahora.plusMinutes(1);
		LocalDateTime casiDosMilMedioDia = dosMilMedioDia.minusSeconds(1);
		
		List<LocalDateTime> otrasFechas = List.of(unMinutoMas, casiDosMilMedioDia);
		
		for(LocalDateTime l : otrasFechas)
			System.out.println(l);
		System.out.println();
		
		
		LocalDateTime fecha = LocalDateTime.of(2010, 1, 1, 0,0,0);
		long diferencia = fecha.until(fromInstant, ChronoUnit.DAYS);
		System.out.println("Diferencia en días entre %s y %s: %d"
							.formatted(fecha, fromInstant, diferencia));
		System.out.println();
		
		LocalDateTime con12horas = LocalDateTime.now().withHour(12);
		System.out.println(con12horas.toString());
		System.out.println();
		
		LocalDate hoyFecha = LocalDateTime.now().toLocalDate();
		LocalTime ahoraHora = LocalDateTime.now().toLocalTime();
		
		System.out.println("Fecha: %s, Hora: %s".formatted(hoyFecha.toString(), ahoraHora.toString()));
		
		
		
	}

}
