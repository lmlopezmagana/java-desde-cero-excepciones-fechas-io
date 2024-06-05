package excepciones;

public class CuentaCorriente {
	private double saldo;

    public CuentaCorriente(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException(
            		"Saldo insuficiente. No se pueden retirar %.2f€. El saldo es de %.2f€"
            											.formatted(cantidad, saldo));
        }
        saldo -= cantidad;
        System.out.println("Se retiró %.2f€. Saldo restante: %.2f€".formatted(cantidad, saldo));
    }

    public void transferir(CuentaCorriente destino, double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException(
            		"Saldo insuficiente para transferencia. No se pueden transferir %.2f€. El saldo es de %.2f"
            									.formatted(cantidad, saldo));
        }
        saldo -= cantidad;
        destino.saldo += cantidad;
        System.out.println("Se transfirió %.2f€ a la cuenta destino. Saldo restante: %.2f€".formatted(cantidad, saldo));
    }

}
