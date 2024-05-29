package fechas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class App {

	public static void main(String[] args) {

		LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		System.out.println("%d %s %d at %d:%d%n".formatted(ldt.getDayOfMonth(), ldt.getMonth(), ldt.getYear(),
				ldt.getHour(), ldt.getMinute()));

		Instant ahora = Instant.now();
		System.out.println(ahora.atZone(ZoneId.systemDefault())); // toString devuelve una representación con fecha/hora

		Instant epoch = Instant.ofEpochSecond(0);
		System.out.println(epoch);

		Instant parseado = Instant.parse("1970-01-01T00:00:00.00Z");
		System.out.println(parseado);

		System.out.println(epoch.plus(50, ChronoUnit.DAYS));
		System.out.println(ahora.minusMillis(1000).atZone(ZoneId.systemDefault()));

		long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(), 
				ChronoUnit.SECONDS);
		System.out.println("Segundos desde 1-1-1970: %,d".formatted(secondsFromEpoch));

		
		System.out.println(ahora
				.with(ChronoField.NANO_OF_SECOND, 1234)
				.atZone(ZoneId.systemDefault()));
		
		
		
	}

}
