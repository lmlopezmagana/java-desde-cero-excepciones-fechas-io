package fechas;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Set;

public class App {

	public static void main(String[] args) {

		// DayOfWeek
		System.out.println(DayOfWeek.MONDAY.plus(3));
		System.out.println(DayOfWeek.from(LocalDate.now()));

		DayOfWeek dow = DayOfWeek.MONDAY;
		Locale locale = Locale.getDefault();
		System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
		System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
		System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
		System.out.println();

		// Month
		System.out.println(Month.MAY.minus(1));
		System.out.println(Month.from(LocalDate.now()));
		System.out.println(Month.JUNE.firstMonthOfQuarter());
		System.out.println(Month.MARCH.firstDayOfYear(true)); // 31 + 29 + 1

		Month month = Month.AUGUST;
		locale = Locale.getDefault();
		System.out.println(month.getDisplayName(TextStyle.FULL, locale));
		System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
		System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
		System.out.println();
		// Fechas parciales

		// Year
		Year anio = Year.now();
		System.out.println(anio);
		System.out.println(anio.atDay(256));
		System.out.println(anio.atMonth(12));
		System.out.println(anio.isLeap());
		System.out.println(anio.isValidMonthDay(MonthDay.parse("--02-29"))); // --MM-dd
		System.out.println();

		// YearMonth
		YearMonth yearMonth = YearMonth.of(2024, 2);
		System.out.println(yearMonth);
		System.out.println(yearMonth.atEndOfMonth());
		System.out.println();

		// MonthDay
		System.out.println(MonthDay.now().atYear(2030));
		System.out.println();

		// LocalTime
		LocalTime horaActual = LocalTime.now();
		System.out.println("Hora actual: " + horaActual);

		LocalTime masHoras = horaActual.plusHours(2);
		System.out.println("Hora actual más 2 horas: " + masHoras);

		LocalTime menosMinutos = horaActual.minusMinutes(30);
		System.out.println("Hora actual menos 30 minutos: " + menosMinutos);
		System.out.println();
		
		// Intervalos
		
		// Period
        Period period = Period.of(1, 2, 3);
        System.out.println("Período: " + period);

        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFin = LocalDate.of(2024, 3, 15);

        Period periodoEntreFechas = Period.between(fechaInicio, fechaFin);
        System.out.println("Período entre " + fechaInicio + " y " + fechaFin + ": " + periodoEntreFechas);

        LocalDate nuevaFecha = fechaInicio.plus(periodoEntreFechas);
        System.out.println("Nueva fecha después de sumar el período: " + nuevaFecha);
        System.out.println();
        
        // Duration
        
        Duration duration = Duration.ofHours(2).plusMinutes(30).plusSeconds(45);
        System.out.println("Duración: " + duration);

        LocalDateTime fechaHoraInicio = LocalDateTime.of(2023, 5, 20, 10, 0);
        LocalDateTime fechaHoraFin = LocalDateTime.of(2023, 5, 20, 13, 0);

        // Calcular la duración entre dos fechas y horas
        Duration duracionEntreFechas = Duration.between(fechaHoraInicio, fechaHoraFin);
        System.out.println("Duración entre " + fechaHoraInicio + " y " + fechaHoraFin + ": " + duracionEntreFechas);

        // Sumar una duración a una hora específica
        horaActual = LocalTime.of(10, 0);
        LocalTime nuevaHora = horaActual.plus(duration);
        System.out.println("Nueva hora después de sumar la duración: " + nuevaHora);
        System.out.println();

		// Zone y Offset
        
        // Zona por defecto
        ZoneId zonaActual = ZoneId.systemDefault();
        System.out.println("Zona horaria actual: " + zonaActual);
        
        // Otra Zona por su id
        ZoneId zonaNuevaYork = ZoneId.of("America/New_York");
        System.out.println("Zona horaria de Nueva York: " + zonaNuevaYork);
        
        // Zonas disponibles
        Set<String> zonasDisponibles = ZoneId.getAvailableZoneIds();
        System.out.println("Zonas horarias disponibles: " + zonasDisponibles);

        // Obtener la hora actual pero adaptada a una zona horaria
        LocalDateTime fechaHora = LocalDateTime.now();
        ZonedDateTime fechaHoraNuevaYork = fechaHora.atZone(zonaNuevaYork);
        System.out.println("Fecha y hora en Nueva York: " + fechaHoraNuevaYork);

        // Obtener la hora actual de una zona horaria concreta
        ZonedDateTime fechaHoraNY = ZonedDateTime.now(zonaNuevaYork);
        System.out.println("Fecha y hora actual en Nueva York " + fechaHoraNY);
        System.out.println();
        
        // Offset
        ZoneOffset offsetNuevaYork = fechaHoraNY.getOffset();
        System.out.println("Desplazamiento de la zona horaria de Nueva York: " + offsetNuevaYork);
        
        ZoneOffset offsetMasDos = ZoneOffset.of("+02:00");
        System.out.println("Desplazamiento +02:00: " + offsetMasDos);

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        OffsetDateTime fechaHoraConOffset = fechaHora.atOffset(offsetMasDos);
        System.out.println("Fecha y hora con desplazamiento +02:00: " + fechaHoraConOffset);

      
	}

}
