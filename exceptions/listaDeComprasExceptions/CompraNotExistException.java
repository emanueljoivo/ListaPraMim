package listaDeComprasExceptions;

public class CompraNotExistException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompraNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
