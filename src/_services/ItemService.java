package _services;

import _entities.item.Item;

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
	 */
	void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida);
	
	/**
	 * Gerencia adição de itens do tipo ItemPorUnidade.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 */
	void adicionaItem(String nome, String categoria, int unidade);
	
	/**
	 * Gerencia adição de itens do tipo ItemPorQuilo.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 */
	void adicionaItem(String nome, String categoria, double kg);
	
	/**
	 * Pega um item a partir do seu id.
	 * @param id
	 * @return o Item correspondente ao id.
	 */
	Item recuperaItem(int id);
	
	/**
	 * Atualiza nome de um item.
	 * @param id
	 * @param novoNome
	 */
	void atualizaItem(int id, String novoNome);
	
	/**
	 * Atualiza categoria de um item.
	 * @param categoria
	 * @param id
	 */
	void atualizaItem(String categoria, int id);
	
	/**
	 * Apaga um item pelo id.
	 * @param id
	 */
	void deletaItem(int id);
	
}
