package fechas;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;

public class App {

	public static void main(String[] args) {

		// Usa el formato ISO_LOCAL_DATE: 2024-01-01
		LocalDate fecha1 = LocalDate.parse("2024-01-01");
		System.out.println(fecha1);

		// Parseo con error DateTimeParseException
		try {
			LocalDate fecha2 = LocalDate.parse("01/01/2024");
			System.out.println(fecha2);
		} catch (DateTimeParseException ex) {
			System.err.println("Error en el parseo de la fecha");
		}

		// Parseo con otro formato predefinido diferente
		String strFecha3 = "2024-05-01T10:15:30";
		LocalDateTime fecha3 = LocalDateTime.parse(strFecha3, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(fecha3);

		// FormatStyle
		String strFecha4LocaleMadrid = "01/5/24 15:00";
		LocalDateTime fecha4 = LocalDateTime.parse(strFecha4LocaleMadrid,
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
		System.out.println(fecha4);

		String strFecha4LocaleUs = "5/01/24, 3:00 PM";
		LocalDateTime fecha4v2 = LocalDateTime.parse(strFecha4LocaleUs,
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.US));
		System.out.println(fecha4v2);

		// ofPattern
		LocalDateTime fecha5 = LocalDateTime.parse("01/05/2024 15:00:32",
				DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		System.out.println(fecha5);
		System.out.println();

		// Formateo

		// También podemos almacenarlo en una variable para reusarlo
		DateTimeFormatter dtf = DateTimeFormatter.ISO_ORDINAL_DATE; // Año-Día del año
		String strFecha1 = fecha1.format(dtf);
		System.out.println(strFecha1);

		
		// Formateo con DateTimeException
		DateTimeFormatter completo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		try {
			System.out.println(LocalDate.now()
					.format(completo));
		} catch (DateTimeException ex) {
			System.err.println("Error al formatear la fecha");
		}
		
		System.out.println(LocalDateTime.now().format(completo));
		

	}

}
