package application.exceptions;

public class BuscaFalhouException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "A busca falhou!";
	}

}
