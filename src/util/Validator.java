package util;

/**
 * Classe criada para realizar a validação de dados antes que sejam cadastrados no sistema.
 * 
 * @author Lucas de Medeiros
 */

public class Validator {
	
	/**
	 * Método que faz a validação de uma String, garantindo que não seja vazia.
	 * 
	 * @param str string a ser validada.
	 * @param msg mensagem a ser exibida caso a exceção seja lançada.
	 * @throws IllegalArgumentException exceção lançada quando a string for vazia.
	 */
	public static void validatorEmptyString(String str, String msg) throws IllegalArgumentException {
		if (str != null)
			if (str.trim().isEmpty())
				throw new IllegalArgumentException(msg);
	}
	
	/**
	 * Método que faz a validação de uma String, garantindo que não seja nula.
	 * 
	 * @param str string a ser validada.
	 * @param msg mensagem a ser exibida caso a exceção seja lançada.
	 * @throws NullPointerException exceção lançada quando a string for nula.
	 */
	public static void validatorNullString(String str, String msg) throws NullPointerException {
		if (str == null)
			throw new NullPointerException(msg);
	}
	
	/**
	 * Método que valida um número, garantindo que não seja menor que zero.
	 * 
	 * @param n número a ser validado.
	 * @param msg mensagem a ser exibida caso a exceção seja lançada.
	 */
	public static void validatorNumber(int n, String msg) throws IllegalArgumentException {
		validatorNumber(n, 0, msg);
	}
	
	/**
	 * Método que valida um número, garantindo que não seja menor que certo valor.
	 * 
	 * @param n número a ser validado.
	 * @param value valor a ser comparado com o número.
	 * @param msg mensagem a ser exibida caso a exceção seja lançada.
	 */
	public static void validatorNumber(int n, int value, String msg) throws IllegalArgumentException {
		validatorNumber(n, value, Integer.MAX_VALUE, msg);
	}
	
	/**
	 * Método que valida um número, garantindo que esteja dentro de determinado intervalo.
	 * OBS: inclui os limites do intervalo.
	 * 
	 * @param n número a ser validado.
	 * @param start valor inicial do intervalo.
	 * @param end valor final do intervalo.
	 * @param msg mensagem a ser exibida caso a exceção seja lançada.
	 * @throws IllegalArgumentException
	 */
	public static void validatorNumber(int n, int start, int end, String msg) throws IllegalArgumentException {
		if ((n < start || n > end))
			throw new IllegalArgumentException(msg);
	}
}
