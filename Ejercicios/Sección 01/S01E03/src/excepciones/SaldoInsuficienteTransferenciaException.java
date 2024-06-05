package excepciones;

public class SaldoInsuficienteTransferenciaException extends SaldoInsuficienteException {

	public SaldoInsuficienteTransferenciaException(String mensaje) {
		super(mensaje);
	}
	
	
	public SaldoInsuficienteTransferenciaException(double saldo, double cantidad) {
		super("Saldo insuficiente para transferencia. No se pueden transferir %.2f€. El saldo es de %.2f"
				.formatted(cantidad, saldo));
	}
	
	
	

}
