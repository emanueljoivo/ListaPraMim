package _services;

import _entities.item.Item;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;

/**
 * Interface que representa contrato de serviços oferecidos sobre itens.
 * 
 * @author Emanuel Joivo
 *
 */
public interface ItemService {
	
	/**
	 * Gerencia adição de itens do tipo ItemPorQntdFixa.
	 * @throws ItemExistException caso o item já exista na base de dados.
	 */
	int adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra,
					 double precoItem) throws ItemExistException;
	/**
	 * Gerencia adição de itens do tipo ItemPorUnidade.
	 */
	int adicionaItem(String nome, String categoria, int unidade, String localDeCompra, double precoItem)
			throws ItemExistException;
	
	/**
	 * Gerencia adição de itens do tipo ItemPorQuilo.
	 * @throws ItemExistException caso o item já exista na base de dados.
	 */
	int adicionaItem(String nome, String categoria, double kg, String localDeCompra, double precoItem)
			throws ItemExistException;
	
	/**
	 * Atualiza atributo de um item.
	 * @throws ItemNotExistException caso o item não exista na base de dados.
	 */
	void atualizaItem(int id, String atributo, String novoValor) throws ItemNotExistException;
	
	/**
	 * Pega um item a partir do seu id.
	 * @return o Item correspondente ao id.
	 * @throws ItemNotExistException caso o item não exista na base de dados.
	 */
	Item recuperaItem(int id) throws ItemNotExistException;	
	
	/**
	 * Apaga um item pelo id.
	 * @throws ItemNotExistException caso o item não exista na base de dados.
	 */
	void deletaItem(int id) throws ItemNotExistException;

    void adicionaPrecoItem(int id, String localDeCompra, double precoItem) throws ItemNotExistException;

    String getItem(int posicao) throws ItemNotExistException;

	String getItemPorCategoria(String categoria, int posicao) throws ItemNotExistException;

	String getItemPorMenorPreco(int posicao) throws ItemNotExistException;

	String getItemPorPesquisa(String strPesquisada, int posicao) throws ItemNotExistException;
}
