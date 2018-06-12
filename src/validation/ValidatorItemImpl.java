package validation;

import enums.ItemAtributos;
import enums.ItemCategorias;
import enums.ItemExceptionsMessages;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementação da classe que valida os dados de itens compráveis do sistema.
 *
 * @author lucas
 */

public class ValidatorItemImpl extends Validator implements ValidatorItem {

	/**
	 * Construtor de ValidatorItemImpl, que atribui valor ao atributo errorMessage, que é o responsável
	 * por definir qual mensagem de erro será mostrada.
	 */
	public ValidatorItemImpl() {}

	/**
	 * Método que verifica se o enum de categorias contém o valor passado pelo usuário.
	 *
	 * @param categoria string passada pelo usuario.
	 * @return <code>true</code> se o valor existir no enum, <code>falso</code> senão.
	 */
	private boolean categoriaEhValida(String categoria) {
		Map<String, ItemCategorias> auxMap = new HashMap<>();
		ItemCategorias[] auxArr = ItemCategorias.values();

		for (int i = 0; i < auxArr.length; i++) {
			auxMap.put(auxArr[i].getValue(), auxArr[i]);
		}
		return auxMap.containsKey(categoria);
	}

	/**
	 * Verifica se um dado atributo corresponde a algum valor no enum de ItemAtributos.
	 * @return <code> true </code> caso haja o atributo no enum e <code> false </code> no caso contrário.
	 */
	private boolean atributoEhValido(String atributo) {
		ItemAtributos[] auxArr = ItemAtributos.values();
		Map<String, ItemAtributos> auxMap = new HashMap<>();

		for (int i = 0; i < auxArr.length; i++) {
			auxMap.put(auxArr[i].getValue() , auxArr[i]);
		}
		return auxMap.containsKey(atributo);
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
		this.generalValidatorString(nome, ItemExceptionsMessages.NOME_INVALIDO.getErrorMessage());
		this.generalValidatorString(categoria, ItemExceptionsMessages.CATEGORIA_INVALIDA.getErrorMessage());

		if (!this.categoriaEhValida(categoria))
			throw new IllegalArgumentException(ItemExceptionsMessages.CATEGORIA_VALOR_INVALIDO.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaItem(String, String, int)}
	 */
	@Override
	public void validaItem(String nome, String categoria, int unidade)
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(unidade, ItemExceptionsMessages.UNIDADE_INVALIDA.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaItem(String, String, double)}
	 */
	@Override
	public void validaItem(String nome, String categoria, double kg)
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(kg, ItemExceptionsMessages.QUILO_INVALIDO.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaItem(String, String, int, String)}
	 */
	@Override
	public void validaItem(String nome, String categoria, int qtd, String unidadeDeMedida)
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(qtd, ItemExceptionsMessages.QUANTIDADE_INVALIDA.getErrorMessage());
		this.generalValidatorString(unidadeDeMedida, ItemExceptionsMessages.UNIDADE_DE_MEDIDA_INVALIDA.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaExclusao(int)}
	 *
	 */
	public void validaExclusao(int id) throws IllegalArgumentException {
		validatorNumber(id);
	}

	@Override
	public void validaCategoria(String categoria) throws IllegalArgumentException {
		if (!categoriaEhValida(categoria)) {
		    throw new IllegalArgumentException(ItemExceptionsMessages.CATEGORIA_INVALIDA.getErrorMessage());
        }
	}

	@Override
	public void ValidaPesquisa(String strPesquisada) {
		validatorString(strPesquisada);
	}

	/**
	 * {@link ValidatorItem#validaAtualizacao(int, String)}
	 */
	@Override
	public void validaAtualizacao(int id, String atributo) throws IllegalArgumentException {
		validatorNumber(id);

		validaAtributoItem(atributo);
	}

	/**
	 * Valida se um dado atributo pertence a algum tipo de item.
	 */
	private void validaAtributoItem(String atributo) {
			if (!atributoEhValido(atributo)) {
				throw new IllegalArgumentException(ItemExceptionsMessages.ATRIBUTO_INVALIDO.getErrorMessage());
			}
	}
}