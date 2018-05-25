package repository;

import java.util.Set;

import model.Item;

public class ItemRepositoryImpl implements ItemRepository {
	private Set<Item> itens;	
	
	@Override
	public void save(Item item) {
		itens.add(item);		
	}
}