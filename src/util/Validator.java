package util;

import _errormessages.MensagemDeErro;
import enums.MensagensDeErro;

/**
 * Classe criada para realizar a validação de dados antes que sejam cadastrados no sistema.
 * 
 * @author lucas
 */

public class Validator {
	
	private MensagemDeErro mensagem;
	
	public Validator(MensagemDeErro msg) {
		this.mensagem = msg;
	}
	
	public void validaItemPorQuantidade(String nome, String categoria, String unidadeDeMedida, int qtd) 
			throws IllegalArgumentException, NullPointerException {
		validatorString(nome, MensagensDeErro.NOME_INVALIDO);
		validatorString(categoria, MensagensDeErro.CATEGORIA_INVALIDA);
		validatorString(unidadeDeMedida, MensagensDeErro.UNIDADE_DE_MEDIDA_INVALIDA);
		validatorNumber(qtd, MensagensDeErro.QUANTIDADE_INVALIDA);
	}

	/**
	 * Analisa uma string verificando se é vazia ou nula.
	 * 
	 * @param str string a ser avaliada.
	 * @param msg enum com a mensagem que deve ser exibida caso a exceção seja lançada.
	 * @throws IllegalArgumentException exceção lançada quando a string for vazia.
	 * @throws NullPointerException exceção lançada quando a string for nula.
	 */
	private void validatorString(String str, MensagensDeErro msg) throws IllegalArgumentException, NullPointerException {
		validatorEmptyString(str, msg);
		validatorNullObject(str, msg);
	}
	
	/**
	 * Método que faz a validação de uma String, garantindo que não seja vazia.
	 * 
	 * @param str string a ser validada.
	 * @param msg enum com a mensagem que deve ser exibida caso a exceção seja lançada.
	 * @throws IllegalArgumentException exceção lançada quando a string for vazia.
	 */
	private void validatorEmptyString(String str, MensagensDeErro msg) throws IllegalArgumentException {
		if (str.trim().isEmpty())
			throw new IllegalArgumentException(mensagem.getMessage(msg));
	}
	
	/**
	 * Método que faz a validação de um objeto, garantindo que não seja nulo.
	 * 
	 * @param o objeto a ser validado.
	 * @param msg enum com a mensagem que deve ser exibida caso a exceção seja lançada.
	 * @throws NullPointerException exceção lançada quando o objeto for nulo.
	 */
	private void validatorNullObject(Object o, MensagensDeErro msg) throws NullPointerException {
		if (o == null)
			throw new NullPointerException(mensagem.getMessage(msg));
	}
	
	/**
	 * Método que valida um número, garantindo que não seja menor que zero.
	 * 
	 * @param n número a ser validado.
	 * @param msg enum com a mensagem que deve ser exibida caso a exceção seja lançada.
	 */
	private void validatorNumber(double n, MensagensDeErro msg) throws IllegalArgumentException {
		validatorNumber(n, 0, msg);
	}
	
	/**
	 * Método que valida um número, garantindo que não seja menor que certo valor.
	 * 
	 * @param n número a ser validado.
	 * @param value valor a ser comparado com o número.
	 * @param msg enum com a mensagem que deve ser exibida caso a exceção seja lançada.
	 */
	private void validatorNumber(double n, int value, MensagensDeErro msg) throws IllegalArgumentException {
		validatorNumber(n, value, Integer.MAX_VALUE, msg);
	}
	
	/**
	 * Método que valida um número, garantindo que esteja dentro de determinado intervalo.
	 * OBS: inclui os limites do intervalo.
	 * 
	 * @param n número a ser validado.
	 * @param start valor inicial do intervalo.
	 * @param end valor final do intervalo.
	 * @param msg enum com a mensagem que deve ser exibida caso a exceção seja lançada.
	 * @throws IllegalArgumentException
	 */
	private void validatorNumber(double n, int start, int end, MensagensDeErro msg) throws IllegalArgumentException {
		if ((n < start || n > end))
			throw new IllegalArgumentException(mensagem.getMessage(msg));
	}
}
