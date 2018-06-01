package _repositories;

import java.util.*;

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
	 */
	@Override
	public boolean save(Item item) {
		return itens.add(item);		
	}

	/**
	 * Deleta um item do banco de dados pelo id.
	 * @return <code> true </code> caso o item seja removido com sucesso,
	 * <code> false </code> no caso contrário.
	 */
	@Override
	public boolean delete(int id) {
		Item o = findById(id);		
		return (o != null) && (itens.remove(o));
	}
	
	/**
	 * Recupera um item do banco de dados pelo id.

	 * @return o item correspondente ao id, caso exista.
	 */
	@Override
	public Item recovery(int id) {
		return findById(id);
	}
	
	/**
	 * Verifica se um item está contido na base de dados a partir do id.

	 * @return true se existe ou false se não existe o tem na base de dados.
	 */
	@Override
	public boolean contains(int id) {		
		return findById(id) != null;
	}
	
	/**
	 * Retorna Item a partir de id.
	 * @return um Item correspondente ao id.
	 */
	private Item findById(int id) {
		for (Item item : itens) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	@Override
	public List<Item> getItens() {
		return toList(this.itens);
	}

	private List toList(Collection c) {
		List novaLista = new ArrayList();
		novaLista.addAll(c);
		return novaLista;
	}
}