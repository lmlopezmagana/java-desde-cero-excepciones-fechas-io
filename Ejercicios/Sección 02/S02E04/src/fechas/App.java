package fechas;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class App {
	
	public static void main(String[] args) {
		// Definimos el Locale para España
        Locale localeES = new Locale("es", "ES");

        // Obtenemos y mostramos los nombres de los días de la semana
        for (DayOfWeek dia : DayOfWeek.values()) {
            String nombreDia = dia.getDisplayName(TextStyle.FULL, localeES);
            System.out.println(nombreDia);
        }
	}

}
