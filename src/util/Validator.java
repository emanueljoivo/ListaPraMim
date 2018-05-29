package util;

import _errormessages.ExceptionMessage;

/**
 * Classe criada para realizar a validação de dados antes que sejam cadastrados no sistema.
 * 
 * @author lucas
 */

public abstract class Validator implements Validation {
	
	protected ExceptionMessage errorMessage;

	@Override
	public void validatorString(String str) throws IllegalArgumentException, NullPointerException {
		this.validatorEmptyString(str);
		this.validatorNullObject(str);
	}

	@Override
	public void validatorEmptyString(String str) throws IllegalArgumentException {
		if (str.trim().isEmpty())
			throw new IllegalArgumentException();
	}

	@Override
	public void validatorNullObject(Object o) throws NullPointerException {
		if (o == null)
			throw new NullPointerException();
	}

	@Override
	public void validatorNumber(double n) throws IllegalArgumentException {
		this.validatorNumber(n, 0);
	}

	@Override
	public void validatorNumber(double n, int value) throws IllegalArgumentException {
		this.validatorNumber(n, value, Integer.MAX_VALUE);
	}

	@Override
	public void validatorNumber(double n, int start, int end) throws IllegalArgumentException {
		if ((n < start || n > end))
			throw new IllegalArgumentException();
	}
}
