package net.openwebinars.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.TemporalAdjusters;

import net.openwebinars.util.intenal.FechasSemanaSanta;

public class FechasUtil {
	
	private int anioInicioCurso;
	
	public FechasUtil(int year) {
		anioInicioCurso = year;
	}
	
	public LocalDate getInicioCursoPeques() {
		return getFechaConfiguradaSiguienteLunes(MonthDay.of(9, 10));
	}
	
	public LocalDate getInicioCursoMayores() {
		return getFechaConfiguradaSiguienteLunes(MonthDay.of(9, 15));
	}
	
	public LocalDate getFinTrimestre1() {
		return getFechaConfiguradaAnteriorViernes(MonthDay.of(12, 22));
	}
	
	public LocalDate getInicioTrimestre2() {
		return getFechaConfiguradaSiguienteLunes(MonthDay.of(1, 7), anioInicioCurso+1);
	}
	
	
	public LocalDate getFinTrimestre2() {
		return LocalDate.of(anioInicioCurso+1, 1,1)
					.with(FechasSemanaSanta.viernesDoloresCursoFecha());
	}
	
	public LocalDate getInicioTrimestre3() {
		return LocalDate.of(anioInicioCurso+1, 1, 1)
				.with(FechasSemanaSanta.lunesPascuaCursoFecha());
	}
	
	public LocalDate getFinCurso() {
		return getFechaConfiguradaAnteriorViernes(MonthDay.of(6, 24), anioInicioCurso+1);
	}
	
	public boolean isFinDeSemana(LocalDate fecha) {
		return fecha.getDayOfWeek() == DayOfWeek.SATURDAY
			|| fecha.getDayOfWeek() == DayOfWeek.SUNDAY;	
	}
	
	private LocalDate getFechaConfiguradaSiguienteLunes(MonthDay monthDay, int year) {
		LocalDate result = monthDay.atYear(year);
		if (isFinDeSemana(result))
			result = result.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		return result;
	}
	
	private LocalDate getFechaConfiguradaSiguienteLunes(MonthDay monthDay) {
		return getFechaConfiguradaSiguienteLunes(monthDay, anioInicioCurso);
	}

	private LocalDate getFechaConfiguradaAnteriorViernes(MonthDay monthDay, int year) {
		LocalDate result = monthDay.atYear(year);
		if (isFinDeSemana(result))
			result = result.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		return result;
	}
	
	private LocalDate getFechaConfiguradaAnteriorViernes(MonthDay monthDay) {
		return getFechaConfiguradaAnteriorViernes(monthDay, anioInicioCurso);
	}
}
