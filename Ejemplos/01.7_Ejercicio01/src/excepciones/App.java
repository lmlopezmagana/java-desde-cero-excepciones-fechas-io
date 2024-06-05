package excepciones;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		
		System.out.print("Ingrese el primer número: ");
        double num1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = sc.nextDouble();

        System.out.print("Ingrese la operación (+, -, *, /): ");
        String operator = sc.next();

        try {
            double result = 0;
            switch (operator) {
                case "+":
                    result = Calculadora.add(num1, num2);
                    break;
                case "-":
                    result = Calculadora.subtract(num1, num2);
                    break;
                case "*":
                    result = Calculadora.multiply(num1, num2);
                    break;
                case "/":
                    result = Calculadora.divide(num1, num2);
                    break;
                default:
                    throw new IllegalArgumentException("Operación no válida");
            }
            System.out.println("Resultado: " + result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

}
