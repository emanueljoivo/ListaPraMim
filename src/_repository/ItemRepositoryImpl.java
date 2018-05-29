package _repository;

import java.util.HashSet;
import java.util.Set;

import _entities.item.Item;

public class ItemRepositoryImpl implements ItemRepository {
	private Set<Item> itens;	
	
	public ItemRepositoryImpl() {
		this.itens = new HashSet<>();
	}
	
	@Override
	public void save(Item item) {
		itens.add(item);		
	}

	@Override
	public boolean delete(long id) {
		Item o = findById(id);		
		return (o != null) && (itens.remove(o));
	}
	
	private Item findById(long id) {
		for (Item item : itens) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	@Override
	public Item read(long id) {
		return findById(id);
	}
	
	public boolean containsById(long id) {		
		return findById(id) != null;
	}	
}