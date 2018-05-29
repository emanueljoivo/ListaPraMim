package _repositories;

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
	public boolean delete(int id) {
		Item o = findById(id);		
		return (o != null) && (itens.remove(o));
	}
	
	@Override
	public Item read(int id) {
		return findById(id);
	}
	
	@Override
	public boolean contains(int id) {		
		return findById(id) != null;
	}
	
	private Item findById(int id) {
		for (Item item : itens) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
}