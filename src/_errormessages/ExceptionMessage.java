package _errormessages;

public interface ExceptionMessage {
	
	/**
	 * Método para pegar a mensagem de erro.
	 * 
	 * @return uma string que representa o erro que aconteceu.
	 */
	String getMessage();
	
	/**
	 * Método para setar o enum das mensagens de erro.
	 * 
	 * @param e enum passado para as mensagens.
	 */
	void setEnum(Enum e);
}
