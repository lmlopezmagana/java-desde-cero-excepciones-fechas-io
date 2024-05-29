package net.openwebinars.app;

import net.openwebinars.model.Mundo;
import net.openwebinars.model.Saludable;
import net.openwebinars.service.Saludador;

public class App {

	public static void main(String[] args) {
	
		Saludable s = new Mundo();
		
		Saludador.saludar(s);
		

	}

}
