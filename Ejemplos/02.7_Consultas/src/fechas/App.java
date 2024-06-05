package fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;

public class App {

	public static void main(String[] args) {
		
		
		// Temporal.query
		
		LocalDateTime ahora = LocalDateTime.now();
		
		System.out.println("Fecha: " +  ahora.query(TemporalQueries.localDate()));
		System.out.println("Hora: " + ahora.query(TemporalQueries.localTime()));
		System.out.println("Precisión: " + ahora.query(TemporalQueries.precision()));
		System.out.println("Huso horario: " + ahora.query(TemporalQueries.zoneId()));
		
		ZonedDateTime ahoraZona = ahora.atZone(ZoneId.systemDefault());
		System.out.println("Huso horario: " + ahoraZona.query(TemporalQueries.zoneId()));
		System.out.println();

		// TemporalQuery.queryFrom
		
		System.out.println("Fecha: " + TemporalQueries.localDate().queryFrom(ahora));
		System.out.println("Hora: " + TemporalQueries.localTime().queryFrom(ahora));
		System.out.println();
		
		
		// Consultas personalizadas
		
		LocalDate unDiaQueSi = LocalDate.of(2024, 1, 1);
		TemporalQuery<Boolean> q = new VacacionesFamiliaresQuery();
		
		String msgSi = "El día %s estoy de vacaciones";
		String msgNo = "Lo siento, pero el día %s no estoy de vacaciones";
		
		if (unDiaQueSi.query(q))
			System.out.println(msgSi.formatted(unDiaQueSi));
		else
			System.out.println(msgNo.formatted(unDiaQueSi));
		
		LocalDate unDiaQueNo = LocalDate.of(2024, 5, 24);
		if (unDiaQueNo.query(q))
			System.out.println(msgSi.formatted(unDiaQueNo));
		else
			System.out.println(msgNo.formatted(unDiaQueNo));
		
		
		
	}

}
