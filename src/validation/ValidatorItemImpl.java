package validation;

import _entities.item.Item;
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
	private void validaCadastro(String nome, String categoria, String localDeCompra, Double precoItem) {
		this.genericValidatorString(nome,
				ItemExceptionsMessages.CADASTRO_INVALIDO_NOME.getErrorMessage());
		this.genericValidatorString(categoria,
				ItemExceptionsMessages.CADASTRO_INVALIDO_CATEGORIA_VN.getErrorMessage());
		this.validaCategoria(categoria,
				ItemExceptionsMessages.CADASTRO_INVALIDO_CATEGORIA.getErrorMessage());
		this.genericValidatorString(localDeCompra,
                ItemExceptionsMessages.CADASTRO_INVALIDO_LOCAL.getErrorMessage());

		this.genericValidatorNumber(precoItem,
                ItemExceptionsMessages.CADASTRO_INVALIDO_PRECO.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaCadastro(String, String, int, String, double)}
	 */
	@Override
	public void validaCadastro(String nome, String categoria, int unidade, String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException {
		validaCadastro(nome, categoria, localDeCompra, precoItem);
		this.genericValidatorNumber(unidade,
				ItemExceptionsMessages.CADASTRO_INVALIDO_UNIDADE.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaCadastro(String, String, double, String, double)}
	 */
	@Override
	public void validaCadastro(String nome, String categoria, double kg, String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException {
		validaCadastro(nome, categoria, localDeCompra, precoItem);
		this.genericValidatorNumber(kg,
				ItemExceptionsMessages.CADASTRO_INVALIDO_QUILO.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaCadastro(String, String, int, String, String, double)}
	 */
	@Override
	public void validaCadastro(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra,
							   double precoItem)
			throws NullPointerException, IllegalArgumentException {

		validaCadastro(nome, categoria, localDeCompra, precoItem);
		this.genericValidatorNumber(qtd,
				ItemExceptionsMessages.CADASTRO_INVALIDO_QUANTIDADE.getErrorMessage());

		this.genericValidatorString(unidadeDeMedida,
				ItemExceptionsMessages.CADASTRO_INVALIDO_UNI_DE_MEDIDA.getErrorMessage());
	}

	/**
	 * {@link ValidatorItem#validaExclusao(int)}
	 *
	 */
	@Override
	public void validaExclusao(int id)
			throws IllegalArgumentException, NullPointerException {

		this.genericValidatorNumber(id,
				ItemExceptionsMessages.EXCLUSAO_INVALIDA_ID.getErrorMessage());
	}

	@Override
	public void validaPesquisa(String strPesquisada)
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

    @Override
    public void validaAdicaoDePreco(int id, String localDeCompra, double precoItem)
            throws IllegalArgumentException, NullPointerException{

	    this.genericValidatorNumber(id,
                ItemExceptionsMessages.CADASTRO_DE_PRECO_ID.getErrorMessage());
	    this.genericValidatorString(localDeCompra,
                ItemExceptionsMessages.CADASTRO_DE_PRECO_LOCAL.getErrorMessage());
	    this.genericValidatorNumber(precoItem,
                ItemExceptionsMessages.CADASTRO_DE_PRECO_PRECO.getErrorMessage());
    }

	@Override
	public void validaGetItem(int posicao) {
		this.genericValidatorNumber(posicao,
				ItemExceptionsMessages.PESQUISA_INVALIDA_POSICAO.getErrorMessage());
	}

	@Override
	public void validaGetItem(String strPesquisada, int posicao) {
		this.genericValidatorString(strPesquisada,
				ItemExceptionsMessages.PESQUISA_INVALIDA_STR.getErrorMessage());
		validaGetItem(posicao);
	}

	@Override
	public void validaGetItemByCategory(String categoria, int posicao) {
		this.validaCategoria(categoria,
				ItemExceptionsMessages.LISTAGEM_INVALIDA_CATEGORIA.getErrorMessage());

		validaGetItem(posicao);
	}

	@Override
	public void validaListagem(int id) {
		this.genericValidatorNumber(id,
				ItemExceptionsMessages.LISTAGEM_INVALIDA_ID.getErrorMessage());
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
		this.validaAtributo(atributo,
				ItemExceptionsMessages.ATUALIZACAO_INVALIDA_ATRIBUTO.getErrorMessage());
		this.genericValidatorString(novoValor,
				ItemExceptionsMessages.ATUALIZACAO_INVALIDA_VALOR.getErrorMessage());

		if (atributo.equalsIgnoreCase(ItemAtributos.UNIDADES.getValue())) {
			this.genericValidatorNumber(Integer.parseInt(novoValor),
					ItemExceptionsMessages.ATUALIZACAO_INVALIDA_UNIDADE.getErrorMessage());
		}

		if (atributo.equalsIgnoreCase(ItemAtributos.QUILOS.getValue())) {
			this.genericValidatorNumber(Double.parseDouble(novoValor),
					ItemExceptionsMessages.ATUALIZACAO_INVALIDA_KG.getErrorMessage());
		}

		if (atributo.equalsIgnoreCase(ItemAtributos.CATEGORIA.getValue())) {
			this.validaCategoria(novoValor,
					ItemExceptionsMessages.ATUALIZACAO_INVALIDA_CATEGORIA.getErrorMessage());
		}
	}

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
}