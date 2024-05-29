package net.openwebinars.service;

import net.openwebinars.model.Saludable;

public class Saludador {

	public static void saludar() {
		System.out.println("¡¡Saludos!!");
	}

	public static void saludar(Saludable s) {
		System.out.println("¡Hola, %s!%n".formatted(s.nombre()));
	}
	
	
}
