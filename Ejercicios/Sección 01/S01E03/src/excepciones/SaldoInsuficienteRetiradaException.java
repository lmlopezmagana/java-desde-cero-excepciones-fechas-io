package excepciones;

public class SaldoInsuficienteRetiradaException extends SaldoInsuficienteException {

	public SaldoInsuficienteRetiradaException(String mensaje) {
		super(mensaje);
	}
	
	public SaldoInsuficienteRetiradaException(double saldo, double cantidad) {
		super("Saldo insuficiente. No se pueden retirar %.2f€. El saldo es de %.2f€"
            											.formatted(cantidad, saldo));
	}

}
