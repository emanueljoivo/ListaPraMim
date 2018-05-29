package util;

import _errormessages.ExceptionMessage;

/**
 * Classe abstrata que faz a implementação da validação mais geral de dados.
 * 
 * @author lucas
 */

public abstract class Validator implements Validation {
	
	protected ExceptionMessage errorMessage;

	/**
	 * See {@link util.Validation#validatorString(String)}
	 */
	@Override
	public void validatorString(String str) throws IllegalArgumentException, NullPointerException {
		this.validatorEmptyString(str);
		this.validatorNullObject(str);
	}

	/**
	 * See {@link util.Validation#validatorEmptyString(String)}
	 */
	@Override
	public void validatorEmptyString(String str) throws IllegalArgumentException {
		if (str.trim().isEmpty())
			throw new IllegalArgumentException();
	}

	/**
	 * See {@link util.Validation#validatorNullObject(Object)}
	 */
	@Override
	public void validatorNullObject(Object o) throws NullPointerException {
		if (o == null)
			throw new NullPointerException();
	}

	/**
	 * See {@link util.Validation#validatorNumber(double)}
	 */
	@Override
	public void validatorNumber(double n) throws IllegalArgumentException {
		this.validatorNumber(n, 0);
	}

	/**
	 * See {@link util.Validation#validatorNumber(double, int)}
	 */
	@Override
	public void validatorNumber(double n, int value) throws IllegalArgumentException {
		this.validatorNumber(n, value, Integer.MAX_VALUE);
	}

	/**
	 * See {@link util.Validation#validatorNumber(double, int, int)}
	 */
	@Override
	public void validatorNumber(double n, int start, int end) throws IllegalArgumentException {
		if ((n < start || n > end))
			throw new IllegalArgumentException();
	}
	
	@SuppressWarnings("rawtypes")
	/**
	 * Método para validar uma string, retornando a devida mensagem do erro, caso aconteça um problema na validação.
	 * 
	 * @param str string a ser validada.
	 * @param e valor do enum que vai definir a mensagem de erro a ser mostrada. 
	 * @throws IllegalArgumentException exceção que será lançada caso a string seja vazia.
	 * @throws NullPointerException exceção que será lançada caso a string seja nula.
	 */
	protected void generalValidatorString(String str, Enum e) 
			throws IllegalArgumentException, NullPointerException {
		errorMessage.setEnum(e);
		try {
			this.validatorString(str);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(errorMessage.getMessage());
		} catch (NullPointerException npe) {
			throw new NullPointerException(errorMessage.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	/**
	 * Método para validar um numero menor que zero, retornando a devida mensagem do erro, 
	 * caso aconteça um problema na validação.
	 * 
	 * @param n número a ser validado.
	 * @param e valor do enum que vai definir a mensagem de erro a ser mostrada.
	 * @throws IllegalArgumentException exceção que será lançada caso o número seja menor que zero.
	 */
	protected void generalValidatorNumber(double n, Enum e) 
			throws IllegalArgumentException {
		errorMessage.setEnum(e);
		try {
			this.validatorNumber(n);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(errorMessage.getMessage());
		}
	}
}
