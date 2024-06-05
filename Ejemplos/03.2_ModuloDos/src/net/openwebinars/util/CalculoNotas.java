package net.openwebinars.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.openwebinars.lib.Libreria;

public class CalculoNotas {
	
	public static Map<String, Double> notasMedias(List<Nota> listaNotas) {
		
		Map<String, List<Double>> notasPorAsignatura = new HashMap<>();
		
		for(Nota n : listaNotas) {
			if (notasPorAsignatura.containsKey(n.asignatura())) {
				notasPorAsignatura.get(n.asignatura()).add(n.nota());
			} else {
				notasPorAsignatura.put(n.asignatura(), new ArrayList<>(List.of(n.nota())));
			}
		}
		
		Map<String, Double> result = new HashMap<>();
		
		for (String asignatura : notasPorAsignatura.keySet()) {
			double media = Libreria.media(notasPorAsignatura.get(asignatura));
			result.put(asignatura, media);
		}
		
		return result;
		
		
	}

}
