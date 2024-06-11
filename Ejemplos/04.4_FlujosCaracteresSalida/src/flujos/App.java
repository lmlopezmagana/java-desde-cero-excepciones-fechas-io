package flujos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class App {

	public static void main(String[] args) {

		List<String> quijoteLines = List.of("En un lugar de la Mancha,", 
				"de cuyo nombre no quiero acordarme,",
				"no ha mucho tiempo que vivía", 
				"un hidalgo de los de lanza en astillero,",
				"adarga antigua, rocín flaco y galgo corredor.");

		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("quijote.txt")))) {
			for (String s : quijoteLines) {
				pw.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
