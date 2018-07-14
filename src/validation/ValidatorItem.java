package validation;

import java.io.Serializable;

public interface ValidatorItem extends Serializable {
	
	/**
	 * Método que faz a validação dos dados do cadastro de um ItemPorUnidade.
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item.
	 * @param unidade quantidade de items por unidade.
	 * @throws NullPointerException exceção lançada caso nome e categoria sejam strings nulas.
	 * @throws IllegalArgumentException exceção lançada caso nome e categoria sejam strings vazias,
	 * ou unidade for menor que zero.
	 */
	void validaCadastro(String nome, String categoria, int unidade, String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException;
	
	/**
	 * Método que faz a validação dos dados do cadastro de um item do tipo ItemPorQuilo.
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item.
	 * @param kg valor em quilos do item.
	 * @throws NullPointerException exceção lançada caso nome e categoria sejam strings nulas.
	 * @throws IllegalArgumentException exceção lançada caso nome e categoria sejam strings vazias,
	 * ou kg for menor que zero.
	 */
	void validaCadastro(String nome, String categoria, double kg, String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException;
	
	/**
	 * Método que faz a validação dos dados do cadastro de um item do tipo ItemPorQntdFixa
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
	void validaCadastro(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException;

	/**
	 * Verifica se o id e o atributo são válido para a operação de atualização de item.
	 * @throws IllegalArgumentException caso algum parâmetro seja inválido.
	 */
	void validaAtualizacao(int id, String atributo, String novoValor) throws IllegalArgumentException;
	
	/**
	 * Verifica se o id é válido para a operação de exclusão de item.
	 */
	void validaExclusao(int id) throws IllegalArgumentException;	

	/**
	 * Verifica se uma dada string para pesquisa no sistema é válida.
	 * @param strPesquisada
	 */
	void validaPesquisa(String strPesquisada) throws IllegalArgumentException;

	void validaListagem(String categoria) throws IllegalArgumentException;

	void validaAdicaoDePreco(int id, String localDeCompra, double precoItem);

    void validaGetItem(int posicao);

    void validaGetItem(String strPesquisada, int posicao);

    void validaGetItemByCategory(String categoria, int posicao);

    void validaListagem(int id);
}
