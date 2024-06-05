package fechas;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class VacacionesFamiliaresQuery implements TemporalQuery<Boolean> {

	// 23 Diciembre - 2 Enero
	// 20 Julio - 10 Agosto
	
	
	@Override
	public Boolean queryFrom(TemporalAccessor temporal) {
		
		// Comprobamos que la fecha soporta meses y días
		if (!temporal.isSupported(ChronoField.MONTH_OF_YEAR) || 
				!temporal.isSupported(ChronoField.EPOCH_DAY))
			return false;
		
		// Transformamos la fecha en un LocalDate, que tiene 
		// los campos que vamos a consultar
		LocalDate date = LocalDate.ofEpochDay(temporal.getLong(ChronoField.EPOCH_DAY));
		
		Month month = date.getMonth();
	    int day   = temporal.get(ChronoField.DAY_OF_MONTH);
	    
	    // Si se dan las condiciones, devolvemos true
	    
	    if (month == Month.DECEMBER && (day >= 23 || day <= 31))
	    	return Boolean.TRUE;
	    
	    if (month == Month.JANUARY && (day == 1 || day == 2))
	    	return Boolean.TRUE;
	    
	    if (month == Month.JULY && (day >= 20 || day <= 31))
	    	return Boolean.TRUE;
	    
	    if (month == Month.AUGUST && (day >= 1 || day <= 10))
	    	return Boolean.TRUE;

	    return false;
	    
	}

}
