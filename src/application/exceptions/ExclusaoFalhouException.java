package application.exceptions;

public class ExclusaoFalhouException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Exclusão falhou!";
	}

}
