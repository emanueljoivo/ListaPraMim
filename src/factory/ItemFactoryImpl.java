package factory;

import model.Item;

public class ItemFactoryImpl implements ItemFactory {
	private long itemCounter;
	
	public ItemFactoryImpl() {
		this.itemCounter = 0;
	}

	@Override
	public Item cria(String nome, String categoria) {
		return new Item(generateId(), nome, categoria);		
	}
	
	private long generateId() {
		return this.itemCounter += 1;
	}
}