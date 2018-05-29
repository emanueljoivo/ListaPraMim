package util;

/**
 * Interface que define métodos de validação gerais.
 * 
 * @author lucas
 */

public interface Validation {
	
	/**
	 * Analisa uma string verificando se é vazia ou nula.
	 * 
	 * @param str string a ser avaliada.
	 * @throws IllegalArgumentException exceção lançada quando a string for vazia.
	 * @throws NullPointerException exceção lançada quando a string for nula.
	 */
	void validatorString(String str) throws IllegalArgumentException, NullPointerException;
	
	/**
	 * Método que faz a validação de uma String, garantindo que não seja vazia.
	 * 
	 * @param str string a ser validada.
	 * @throws IllegalArgumentException exceção lançada quando a string for vazia.
	 */
	void validatorEmptyString(String str) throws IllegalArgumentException;
	
	/**
	 * Método que faz a validação de um objeto, garantindo que não seja nulo.
	 * 
	 * @param o objeto a ser validado.
	 * @throws NullPointerException exceção lançada quando o objeto for nulo.
	 */
	void validatorNullObject(Object o) throws NullPointerException;
	
	/**
	 * Método que valida um número, garantindo que não seja menor que zero.
	 * 
	 * @param n número a ser validado.
	 * @throws IllegalArgumentException exceção lançada quando o número for menor que zero.
	 */
	void validatorNumber(double n) throws IllegalArgumentException;
	
	/**
	 * Método que valida um número, garantindo que não seja menor que certo valor.
	 * 
	 * @param n número a ser validado.
	 * @param value valor a ser comparado com o número.
	 * @throws IllegalArgumentException exceção lançada quando o número for menor que o valor passado.
	 */
	void validatorNumber(double n, int value) throws IllegalArgumentException;
	
	/**
	 * Método que valida um número, garantindo que esteja dentro de determinado intervalo.
	 * OBS: inclui os limites do intervalo.
	 * 
	 * @param n número a ser validado.
	 * @param start valor inicial do intervalo.
	 * @param end valor final do intervalo.
	 * @throws IllegalArgumentException exceção lançada quando o número não estiver no intervalo.
	 */
	void validatorNumber(double n, int start, int end) throws IllegalArgumentException;

}
