package net.openwebinars;

public class App {

	public static void main(String[] args) {

		int anioInicioCurso = 2024;
		
		FechasUtil fechasUtil = new FechasUtil(anioInicioCurso);
		
		
		System.out.println("FECHAS DEL CALENDARIO ESCOLAR PARA EL CURSO %d-%d".formatted(anioInicioCurso, anioInicioCurso+1));
		System.out.println("======================================================");
		System.out.println();
		
		System.out.println("- Inicio del curso para la enseñanza primaria: " + fechasUtil.getInicioCursoPeques());
		System.out.println("- Inicio del curso para la enseñanza secundaria: " + fechasUtil.getInicioCursoMayores());
		System.out.println("- Fin del 1º Trimestre: " + fechasUtil.getFinTrimestre1());
		System.out.println("- Inicio del 2º Trimestre: " + fechasUtil.getInicioTrimestre2());
		System.out.println("- Fin del 2º Trimestre: "  +  fechasUtil.getFinTrimestre2());
		System.out.println("- Incio del 3º Trimestre: " + fechasUtil.getInicioTrimestre3());
		System.out.println("- Final de curso: " + fechasUtil.getFinCurso());

	}

}
