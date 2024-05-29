package net.openwebinars;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class FechasSemanaSanta {

	public static TemporalAdjuster domingoPascuaCursoFecha() {
		return new TemporalAdjuster() {

			@Override
			public Temporal adjustInto(Temporal temporal) {
				LocalDate ld = LocalDate.from(temporal);
				int year = ld.getYear();
				return calcularDomingoDePascua(year);
			}

		};

	}

	public static TemporalAdjuster lunesPascuaCursoFecha() {
		return new TemporalAdjuster() {

			@Override
			public Temporal adjustInto(Temporal temporal) {
				LocalDate ld = LocalDate.from(temporal);
				int year = ld.getYear();
				return calcularDomingoDePascua(year).plusDays(1);
			}

		};
	}

	public static TemporalAdjuster viernesDoloresCursoFecha() {
		return new TemporalAdjuster() {

			@Override
			public Temporal adjustInto(Temporal temporal) {
				LocalDate ld = LocalDate.from(temporal);
				int year = ld.getYear();
				return calcularDomingoDePascua(year).minusWeeks(1).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
			}

		};
	}

	public static LocalDate calcularDomingoDePascua(int year) {
		int a = year % 19;
		int b = year / 100;
		int c = year % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = (19 * a + b - d - g + 15) % 30;
		int i = c / 4;
		int k = c % 4;
		int l = (32 + 2 * e + 2 * i - h - k) % 7;
		int m = (a + 11 * h + 22 * l) / 451;
		int month = (h + l - 7 * m + 114) / 31;
		int day = ((h + l - 7 * m + 114) % 31) + 1;

		return LocalDate.of(year, month, day);
	}

	

}
