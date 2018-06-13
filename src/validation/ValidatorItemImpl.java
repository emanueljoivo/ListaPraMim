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

	private void validaAtributo(String atributo, String errorMessage) throws IllegalArgumentException{
		if (!atributoEhValido(atributo)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	/**
	 * Método que valida categoria e nome de um item (atributos gerais)
	 * @param categoria categoria do item
	 * @throws NullPointerException exceção que será lançada caso algum dos dois seja nulo.
	 * @throws IllegalArgumentException exceção que será lançada caso algum dos dois seja vazio.
	 */
	private void validaCategoria(String categoria, String errorMessage)
			throws NullPointerException, IllegalArgumentException {
		if (!this.categoriaEhValida(categoria))
			throw new IllegalArgumentException(errorMessage);
	}

	/**
	 * Faz validacao dos principais atributos usados em um cadastro de itens.
	 */
	private void validaCadastro(String nome, String categoria) {
		this.genericValidatorString(nome,
				ItemExceptionsMessages.CADASTRO_INVALIDO_NOME.getErrorMessage());
		this.validaCategoria(categoria,
				ItemExceptionsMessages.CADASTRO_INVALIDO_CATEGORIA.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaCadastro(String, String, int)}
	 */
	@Override
	public void validaCadastro(String nome, String categoria, int unidade)
			throws NullPointerException, IllegalArgumentException {
		validaCadastro(nome, categoria);
		this.genericValidatorNumber(unidade,
				ItemExceptionsMessages.CADASTRO_INVALIDO_UNIDADE.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaCadastro(String, String, double)}
	 */
	@Override
	public void validaCadastro(String nome, String categoria, double kg)
			throws NullPointerException, IllegalArgumentException {
		validaCadastro(nome, categoria);
		this.genericValidatorNumber(kg,
				ItemExceptionsMessages.CADASTRO_INVALIDO_QUILO.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaCadastro(String, String, int, String)}
	 */
	@Override
	public void validaCadastro(String nome, String categoria, int qtd, String unidadeDeMedida)
			throws NullPointerException, IllegalArgumentException {

		validaCadastro(nome, categoria);
		this.genericValidatorNumber(qtd,
				ItemExceptionsMessages.CADASTRO_INVALIDO_QUANTIDADE.getErrorMessage());

		this.genericValidatorString(unidadeDeMedida,
				ItemExceptionsMessages.CADASTRO_INVALIDO_UNI_DE_MEDIDA.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaExclusao(int)}
	 *
	 */
	public void validaExclusao(int id)
			throws IllegalArgumentException, NullPointerException {

		this.genericValidatorNumber(id,
				ItemExceptionsMessages.EXCLUSAO_INVALIDA_ID.getErrorMessage());
	}

	@Override
	public void ValidaPesquisa(String strPesquisada)
			throws IllegalArgumentException, NullPointerException {

		this.genericValidatorString(strPesquisada,
				ItemExceptionsMessages.PESQUISA_INVALIDA_STR.getErrorMessage());
	}

	@Override
	public void validaListagem(String categoria)
			throws IllegalArgumentException, NullPointerException {

		this.genericValidatorString(categoria,
				ItemExceptionsMessages.LISTAGEM_INVALIDA_CATEGORIA_VN.getErrorMessage());
		this.validaCategoria(categoria,
				ItemExceptionsMessages.LISTAGEM_INVALIDA_CATEGORIA.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaAtualizacao(int, String, String)}
	 */
	@Override
	public void validaAtualizacao(int id, String atributo, String novoValor)
			throws IllegalArgumentException, NullPointerException {

		this.genericValidatorNumber(id,
				ItemExceptionsMessages.ATUALIZACAO_INVALIDA_ID.getErrorMessage());
		this.genericValidatorString(atributo,
				ItemExceptionsMessages.ATUALIZACAO_INVALIDA_ATRIBUTO_VN.getErrorMessage());
		validaAtributo(atributo,
				ItemExceptionsMessages.ATUALIZACAO_INVALIDA_ATRIBUTO.getErrorMessage());
		this.genericValidatorString(novoValor,
				ItemExceptionsMessages.ATUALIZACAO_INVALIDA_VALOR.getErrorMessage());
	}
}