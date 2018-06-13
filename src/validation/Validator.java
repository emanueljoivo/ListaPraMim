package validation;

/**
 * Classe abstrata que faz a implementação da validação mais geral de dados.
 * 
 * @author lucas
 */

public abstract class Validator {

	/**
	 * Analisa uma string verificando se é vazia ou nula.
	 * 
	 * @param str string a ser avaliada.
	 * @throws IllegalArgumentException exceção lançada quando a string for vazia.
	 * @throws NullPointerException exceção lançada quando a string for nula.
	 */
	private void validatorString(String str) throws IllegalArgumentException, NullPointerException {
		this.validatorEmptyString(str);
		this.validatorNullObject(str);
	}

	/**
	 * Método que faz a validação de uma String, garantindo que não seja vazia.
	 * 
	 * @param str string a ser validada.
	 * @throws IllegalArgumentException exceção lançada quando a string for vazia.
	 */
	private void validatorEmptyString(String str) throws IllegalArgumentException {
		if (str.trim().isEmpty())
			throw new IllegalArgumentException();
	}

	/**
	 * Método que faz a validação de um objeto, garantindo que não seja nulo.
	 * 
	 * @param o objeto a ser validado.
	 * @throws NullPointerException exceção lançada quando o objeto for nulo.
	 */
	private void validatorNullObject(Object o) throws NullPointerException {
		if (o == null)
			throw new NullPointerException();
	}

	/**
	 * Método que valida um número, garantindo que não seja menor que zero.
	 * 
	 * @param n número a ser validado.
	 * @throws IllegalArgumentException exceção lançada quando o número for menor que zero.
	 */
	private void validatorNumber(double n) throws IllegalArgumentException {
		this.validatorNumber(n, 0);
	}

	/**
	 * Método que valida um número, garantindo que não seja menor que certo valor.
	 * 
	 * @param n número a ser validado.
	 * @param value valor a ser comparado com o número.
	 * @throws IllegalArgumentException exceção lançada quando o número for menor que o valor passado.
	 */
	private void validatorNumber(double n, int value) throws IllegalArgumentException {
		this.validatorNumber(n, value, Integer.MAX_VALUE);
	}

	/**
	 * Método que valida um número, garantindo que esteja dentro de determinado intervalo.
	 * OBS: inclui os limites do intervalo.
	 * 
	 * @param n número a ser validado.
	 * @param start valor inicial do intervalo.
	 * @param end valor final do intervalo.
	 * @throws IllegalArgumentException exceção lançada quando o número não estiver no intervalo.
	 */
	private void validatorNumber(double n, int start, int end) throws IllegalArgumentException {
		if ((n < start || n > end))
			throw new IllegalArgumentException();
	}
	
	/**
	 * Método para validar uma string, retornando a devida mensagem do erro, caso aconteça um problema na validação.
	 * 
	 * @param str string a ser validada.
	 * @param errorMessage valor do enum que vai definir a mensagem de erro a ser mostrada.
	 * @throws IllegalArgumentException exceção que será lançada caso a string seja vazia.
	 * @throws NullPointerException exceção que será lançada caso a string seja nula.
	 */
	protected void genericValidatorString(String str, String errorMessage)
			throws IllegalArgumentException, NullPointerException {
		try {
			this.validatorString(str);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(errorMessage);
		} catch (NullPointerException npe) {
			throw new NullPointerException(errorMessage);
		}
	}
	
	/**
	 * Método para validar um numero menor que zero, retornando a devida mensagem do erro, 
	 * caso aconteça um problema na validação.
	 * 
	 * @param n número a ser validado.
	 * @param errorMessage valor do enum que vai definir a mensagem de erro a ser mostrada.
	 * @throws IllegalArgumentException exceção que será lançada caso o número seja menor que zero.
	 */
	protected void genericValidatorNumber(double n, String errorMessage)
			throws IllegalArgumentException {
		try {
			this.validatorNumber(n);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
}
