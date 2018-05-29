package _errormessages;

/**
 * Interface que define os métodos de uma mensagem de exceção.
 * 
 * @author lucas
 */

public interface ExceptionMessage {
	
	/**
	 * Método para pegar a mensagem correspondente ao erro ocorrido.
	 * 
	 * @return uma string que representa a mensagem do erro que aconteceu.
	 */
	String getMessage();
	
	/**
	 * Método para setar o enum das mensagens de erro.
	 * 
	 * @param e enum com os possíveis erros que podem acontecer.
	 */
	void setEnum(int value);
}
