package javanio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CifradoCesar {

	public static void main(String[] args) {
		
		if (args.length < 4) {
            System.out.println("Uso: java CifradoCesar <modo> <origen> <destino> <desplazamiento>");
            System.exit(1);
        }

		String mode = args[0];
		Path inputFile = Paths.get(args[1]);
        Path outputFile = Paths.get(args[2]);
        int shift = Integer.parseInt(args[3]);
        
        
        try {
        	
        	List<String> contenido = Files.readAllLines(inputFile);

        	List<String> result = new ArrayList<>();
        	
        	if (mode.equalsIgnoreCase("cifrado")) {
        		for(String s : contenido) {
            		result.add(cifrado(s, shift));
            	}
        	} else if (mode.equalsIgnoreCase("descifrado")) {
        		for(String s : contenido) {
            		result.add(descifrado(s, shift));
            	}
        	} else {
        		System.out.println("Modo desconocido %s".formatted(mode));
        		System.exit(1);
        	}
        	
        	Files.write(outputFile, result, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        	
        	System.out.println("Archivo procesado con éxito");
        	
        } catch(IOException e) {
        	System.err.println("Error en el procesamiento del archivo (%s)".formatted(e));
        }
		

	}

	
	public static String cifrado(String text, int shift) {
		StringBuilder result = new StringBuilder();

        // Alfabeto español incluyendo Ñ
        String alphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnñopqrstuvwxyz";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    int index = alphabet.indexOf(ch);
                    if (index != -1) {
                        //result.append(alphabet.charAt((index + shift) % alphabet.length()));
                        result.append(alphabet.charAt(mod(index+shift, alphabet.length())));
                    } else {
                        result.append(ch); // Para caracteres fuera del alfabeto (como letras con tildes)
                    }
                } else {
                    int index = alphabetLower.indexOf(ch);
                    if (index != -1) {
                        //result.append(alphabetLower.charAt((index + shift) % alphabetLower.length()));
                        result.append(alphabetLower.charAt(mod(index+shift, alphabetLower.length())));
                    } else {
                        result.append(ch); // Para caracteres fuera del alfabeto (como letras con tildes)
                    }
                }
            } else {
                result.append(ch); // No cifrar caracteres que no son letras
            }
        }

        return result.toString();
	}
	
	public static String descifrado(String text, int shift) {
		return cifrado(text, -shift);
	}
	
	public static int mod(int a, int b) {
		int resto = a % b;
		
		if (resto < 0) {
			resto += b;
		}
		
		return resto;
	}
	
	
	
}
