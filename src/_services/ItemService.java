package _services;

import _entities.item.Item;
import item_exceptions.ItemExistException;
import item_exceptions.ItemNotExistException;

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
	void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws ItemExistException;
	
	/**
	 * Gerencia adição de itens do tipo ItemPorUnidade.
	 */
	void adicionaItem(String nome, String categoria, int unidade) throws ItemExistException;
	
	/**
	 * Gerencia adição de itens do tipo ItemPorQuilo.
	 * @throws ItemExistException caso o item já exista na base de dados.
	 */
	void adicionaItem(String nome, String categoria, double kg) throws ItemExistException;
	
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


	/**
	 * Lista todos os itens cadastrados no sistema.
	 * @return uma representação em string de uma lista de todos os itens
	 * cadastrados no sistema.
	 */
    String listaItems();
}
