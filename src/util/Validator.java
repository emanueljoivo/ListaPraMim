package util;

/**
 * Classe criada para realizar a validação de dados antes que sejam cadastrados no sistema.
 * 
 * @author lucas
 */

public class Validator {
	
	/**
	 * Analisa duas strings verificando se são vazias ou nulas.
	 * @param str1 primeira string a ser avaliada.
	 * @param str2 segunda string a ser avaliada.
	 * @throws IllegalArgumentException Exceção lançanda caso pelo menos das strings serem vazia ou nula.
	 */
	public static void validatorString(String str1, String str2, String msg) throws IllegalArgumentException {
		validatorString( str1, str2, msg );
	}

	/**
	 * Analisa uma string verificando se é vazia ou nula.
	 * @param str string a ser avaliada.
	 * @param msg
	 * @throws IllegalArgumentException
	 */
	public static void validatorString(String str, String msg) throws IllegalArgumentException {
		validatorEmptyString( str, msg );
		validatorNullObject(str, msg);
	}
	
	/**
	 * Método que faz a validação de uma String, garantindo que não seja vazia.
	 * 
	 * @param str string a ser validada.
	 * @param msg mensagem a ser exibida caso a exceção seja lançada.
	 * @throws IllegalArgumentException exceção lançada quando a string for vazia.
	 */
	public static void validatorEmptyString(String str, String msg) throws IllegalArgumentException {
		if (str.trim().isEmpty())
			throw new IllegalArgumentException(msg);
	}
	
	/**
	 * Método que faz a validação de um objeto, garantindo que não seja nulo.
	 * 
	 * @param o objeto a ser validado.
	 * @param msg mensagem a ser exibida caso a exceção seja lançada.
	 * @throws NullPointerException exceção lançada quando o objeto for nulo.
	 */
	public static void validatorNullObject(Object o, String msg) throws NullPointerException {
		if (o == null)
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
