package fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

public class App {

	public static void main(String[] args) {
		Month month = null;

		int mes = 7;

        month = Month.of(mes);

        
        // Obtenemos la fecha del primer lunes del mes
        LocalDate date = Year.now().atMonth(month).atDay(1).
              with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        
        // Obtenemos el mes para poder compararlo
        Month mi = date.getMonth();
        
        // Mientras el mes no cambie...
        while (mi == month) {
            System.out.println(date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            mi = date.getMonth();
        }
        

	}


}
