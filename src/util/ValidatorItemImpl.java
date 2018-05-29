package util;

import _errormessages.ItemExceptionMessage;
import enums.ItemErrors;

public class ValidatorItemImpl extends Validator {
	
	public ValidatorItemImpl() {
		this.errorMessage = new ItemExceptionMessage();
	}
	
	@SuppressWarnings("rawtypes")
	private void generalValidatorString(String str, Enum e) 
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
	private void generalValidatorNumber(double n, Enum e) 
			throws IllegalArgumentException {
		errorMessage.setEnum(e);
		try {
			this.validatorNumber(n);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(errorMessage.getMessage());
		}
	}
	
	private void validaCategoriaENome(String nome, String categoria) 
			throws NullPointerException, IllegalArgumentException {
		this.generalValidatorString(nome, ItemErrors.NOME_INVALIDO);
		this.generalValidatorString(nome, ItemErrors.CATEGORIA_INVALIDA);
	}

	public void validaItem(String nome, String categoria, int unidade) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(unidade, ItemErrors.UNIDADE_INVALIDA);
	}
	
	public void validaItem(String nome, String categoria, double kg) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(kg, ItemErrors.QUILO_INVALIDO);
	}
	
	public void validaItem(String nome, String categoria, int qtd, String unidadeDeMedida) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(qtd, ItemErrors.QUANTIDADE_INVALIDA);
		this.generalValidatorString(unidadeDeMedida, ItemErrors.UNIDADE_DE_MEDIDA_INVALIDA);
	}
}
