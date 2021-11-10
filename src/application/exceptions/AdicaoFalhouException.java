package application.exceptions;

public class AdicaoFalhouException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "A adição falhou!";
	}
}
