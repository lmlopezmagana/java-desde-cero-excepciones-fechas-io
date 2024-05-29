package excepciones;

public class App {

	public static void main(String[] args) {
        CuentaCorriente cuenta1 = new CuentaCorriente(1000);
        CuentaCorriente cuenta2 = new CuentaCorriente(500);

        try {
            cuenta1.retirar(200);
            cuenta1.transferir(cuenta2, 300);
            cuenta2.retirar(1000); // Esto debería lanzar una SaldoInsuficienteException
        } catch (SaldoInsuficienteException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
