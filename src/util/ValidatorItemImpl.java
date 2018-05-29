package util;

import _errormessages.ItemExceptionMessage;
import enums.ItemException;

/**
 * Implementação da classe que valida os dados de itens compráveis do sistema.
 * 
 * @author lucas
 */

public class ValidatorItemImpl extends Validator {
	
	/**
	 * Construtor de ValidatorItemImpl, que atribui valor ao atributo errorMessage, que é o responsável
	 * por definir qual mensagem de erro será mostrada.
	 */
	public ValidatorItemImpl() {
		this.errorMessage = new ItemExceptionMessage();
	}
	
	/**
	 * Método que valida categoria e nome de um item (atributos gerais)
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item
	 * @throws NullPointerException exceção que será lançada caso algum dos dois seja nulo.
	 * @throws IllegalArgumentException exceção que será lançada caso algum dos dois seja vazio.
	 */
	private void validaCategoriaENome(String nome, String categoria) 
			throws NullPointerException, IllegalArgumentException {
		this.generalValidatorString(nome, ItemException.NOME_INVALIDO.getValue());
		this.generalValidatorString(nome, ItemException.CATEGORIA_INVALIDA.getValue());
	}

	/**
	 * Método que faz a validação dos dados de um item do tipo ItemPorUnidade
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item.
	 * @param unidade quantidade de items por unidade.
	 * @throws NullPointerException exceção lançada caso nome e categoria sejam strings nulas.
	 * @throws IllegalArgumentException exceção lançada caso nome e categoria sejam strings vazias,
	 * ou unidade for menor que zero.
	 */
	public void validaItem(String nome, String categoria, int unidade) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(unidade, ItemException.UNIDADE_INVALIDA.getValue());
	}
	
	/**
	 * Método que faz a validação dos dados de um item do tipo ItemPorQuilo.
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item.
	 * @param kg valor em quilos do item.
	 * @throws NullPointerException exceção lançada caso nome e categoria sejam strings nulas.
	 * @throws IllegalArgumentException exceção lançada caso nome e categoria sejam strings vazias,
	 * ou kg for menor que zero.
	 */
	public void validaItem(String nome, String categoria, double kg) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(kg, ItemException.QUILO_INVALIDO.getValue());
	}
	
	/**
	 * Método que faz a validação dos dados de um item do tipo ItemPorQntdFixa
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item.
	 * @param qtd quantidade de items desse tipo.
	 * @param unidadeDeMedida unidade de medida usada no cadastro.
	 * @throws NullPointerException exceção lançada caso nome, categoria 
	 * ou unidadeDeMedida sejam strings nulas.
	 * @throws IllegalArgumentException exceção lançada caso nome, categoria 
	 * ou unidadeDeMedida sejam strings vazias, ou qtd for menor que zero.
	 */
	public void validaItem(String nome, String categoria, int qtd, String unidadeDeMedida) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(qtd, ItemException.QUANTIDADE_INVALIDA.getValue());
		this.generalValidatorString(unidadeDeMedida, ItemException.UNIDADE_DE_MEDIDA_INVALIDA.getValue());
	}
}
