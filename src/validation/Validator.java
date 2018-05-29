package validation;

/**
 * Classe abstrata que faz a implementação da validação mais geral de dados.
 * 
 * @author lucas
 */

public abstract class Validator implements Validation {

	/**
	 * See {@link validation.Validation#validatorString(String)}
	 */
	@Override
	public void validatorString(String str) throws IllegalArgumentException, NullPointerException {
		this.validatorEmptyString(str);
		this.validatorNullObject(str);
	}

	/**
	 * See {@link validation.Validation#validatorEmptyString(String)}
	 */
	@Override
	public void validatorEmptyString(String str) throws IllegalArgumentException {
		if (str.trim().isEmpty())
			throw new IllegalArgumentException();
	}

	/**
	 * See {@link validation.Validation#validatorNullObject(Object)}
	 */
	@Override
	public void validatorNullObject(Object o) throws NullPointerException {
		if (o == null)
			throw new NullPointerException();
	}

	/**
	 * See {@link validation.Validation#validatorNumber(double)}
	 */
	@Override
	public void validatorNumber(double n) throws IllegalArgumentException {
		this.validatorNumber(n, 0);
	}

	/**
	 * See {@link validation.Validation#validatorNumber(double, int)}
	 */
	@Override
	public void validatorNumber(double n, int value) throws IllegalArgumentException {
		this.validatorNumber(n, value, Integer.MAX_VALUE);
	}

	/**
	 * See {@link validation.Validation#validatorNumber(double, int, int)}
	 */
	@Override
	public void validatorNumber(double n, int start, int end) throws IllegalArgumentException {
		if ((n < start || n > end))
			throw new IllegalArgumentException();
	}
	
	/**
	 * Método para validar uma string, retornando a devida mensagem do erro, caso aconteça um problema na validação.
	 * 
	 * @param str string a ser validada.
	 * @param value valor do enum que vai definir a mensagem de erro a ser mostrada. 
	 * @throws IllegalArgumentException exceção que será lançada caso a string seja vazia.
	 * @throws NullPointerException exceção que será lançada caso a string seja nula.
	 */
	protected void generalValidatorString(String str, String value) 
			throws IllegalArgumentException, NullPointerException {
		try {
			this.validatorString(str);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(value);
		} catch (NullPointerException npe) {
			throw new NullPointerException(value);
		}
	}
	
	/**
	 * Método para validar um numero menor que zero, retornando a devida mensagem do erro, 
	 * caso aconteça um problema na validação.
	 * 
	 * @param n número a ser validado.
	 * @param value valor do enum que vai definir a mensagem de erro a ser mostrada.
	 * @throws IllegalArgumentException exceção que será lançada caso o número seja menor que zero.
	 */
	protected void generalValidatorNumber(double n, String value) 
			throws IllegalArgumentException {
		try {
			this.validatorNumber(n);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(value);
		}
	}
}
