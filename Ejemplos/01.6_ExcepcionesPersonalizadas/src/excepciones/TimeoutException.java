package excepciones;

public class TimeoutException extends Exception {

	public TimeoutException() {
		super("Se ha superado el tiempo permitido para realizar la operación");
	}

	public TimeoutException(String message) {
		super(message);
	}
	
	
	

}
