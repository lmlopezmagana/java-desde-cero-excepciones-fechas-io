package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("\n--- Calculadora ---");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                double num1, num2;
                switch (opcion) {
                    case 1:
                        num1 = obtenerNumero(scanner, "Introduzca el primer número: ");
                        num2 = obtenerNumero(scanner, "Introduzca el segundo número: ");
                        System.out.println("Resultado: " + Calculadora.add(num1, num2));
                        break;
                    case 2:
                        num1 = obtenerNumero(scanner, "Introduzca el primer número: ");
                        num2 = obtenerNumero(scanner, "Introduzca el segundo número: ");
                        System.out.println("Resultado: " + Calculadora.subtract(num1, num2));
                        break;
                    case 3:
                        num1 = obtenerNumero(scanner, "Introduzca el primer número: ");
                        num2 = obtenerNumero(scanner, "Introduzca el segundo número: ");
                        System.out.println("Resultado: " + Calculadora.multiply(num1, num2));
                        break;
                    case 4:
                        num1 = obtenerNumero(scanner, "Introduzca el primer número: ");
                        num2 = obtenerNumero(scanner, "Introduzca el segundo número: ");
                        System.out.println("Resultado: " + Calculadora.divide(num1, num2));
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static double obtenerNumero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

}
