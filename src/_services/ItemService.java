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
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 * @throws ItemExistException 
	 */
	void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws ItemExistException;
	
	/**
	 * Gerencia adição de itens do tipo ItemPorUnidade.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 */
	void adicionaItem(String nome, String categoria, int unidade) throws ItemExistException;
	
	/**
	 * Gerencia adição de itens do tipo ItemPorQuilo.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 */
	void adicionaItem(String nome, String categoria, double kg) throws ItemExistException;
	
	/**
	 * Atualiza atributo de um item.
	 * @param categoria
	 * @param id
	 * @throws ItemNotExistException 
	 */
	void atualizaItem(int id, String atributo, String novoValor) throws ItemNotExistException;
	
	/**
	 * Pega um item a partir do seu id.
	 * @param id
	 * @return o Item correspondente ao id.
	 * @throws ItemNotExistException 
	 */
	Item recuperaItem(int id) throws ItemNotExistException;	
	
	/**
	 * Apaga um item pelo id.
	 * @param id
	 * @throws ItemNotExistException 
	 */
	void deletaItem(int id) throws ItemNotExistException;
	
	
	
}
