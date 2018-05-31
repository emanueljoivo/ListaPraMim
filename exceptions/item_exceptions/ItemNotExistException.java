package item_exceptions;

public class ItemNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNotExistException(String msg) {super(msg);}
}