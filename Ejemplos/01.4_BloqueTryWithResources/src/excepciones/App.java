package excepciones;

public class App {

	public static void main(String[] args) {
		ListWriter listWriter = new ListWriter();
		listWriter.writeList();
		
		ListReader listReader = new ListReader();
		listReader.readList();
	}

}
