package _repositories;

import java.util.HashSet;
import java.util.Set;

import _entities.item.Item;

/**
 * Implementação de repositório de itens. Representa comunicação
 * do sistema com o banco de dados.
 *
 */
public class ItemRepositoryImpl implements ItemRepository {
	private Set<Item> itens;	
	
	/**
	 * Construtor que inicializa estruturas em memória utilizadas para
	 * persistência.
	 */	
	public ItemRepositoryImpl() {
		this.itens = new HashSet<>();
	}
	
	/**
	 * Salva um item no banco de dados.
	 * @param o
	 */
	@Override
	public void save(Item item) {
		itens.add(item);		
	}

	/**
	 * Deleta um item do banco de dados pelo id.
	 * @param id
	 * @return
	 */
	@Override
	public boolean delete(int id) {
		Item o = findById(id);		
		return (o != null) && (itens.remove(o));
	}
	
	/**
	 * Recupera um item do banco de dados pelo id.
	 * @param id
	 * @return
	 */
	@Override
	public Item recovery(int id) {
		return findById(id);
	}
	
	/**
	 * Verifica se um item está contido na base de dados a partir do id.
	 * @param id
	 * @return true se existe ou false se não existe o tem na base de dados.
	 */
	@Override
	public boolean contains(int id) {		
		return findById(id) != null;
	}
	
	/**
	 * Retorna Item a partir de id.
	 * @param id
	 * @return um Item.
	 */
	private Item findById(int id) {
		for (Item item : itens) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
}