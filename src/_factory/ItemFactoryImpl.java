package _factory;

import _entities.enums.ItemCategoria;
import _entities.item.Item;

import java.util.EnumSet;

public class ItemFactoryImpl implements ItemFactory {
	private long itemCounter;
	
	public ItemFactoryImpl() {
		this.itemCounter = 0;
	}

	@Override
	public Item criaItem(String nome, String categoria) {
		ItemCategoria ic;
		 try {
		 	ic = ItemCategoria.valueOf( categoria );
		 } catch (IllegalArgumentException ex) {
		 	throw new IllegalArgumentException (ex.getMessage ());
		 }

		return new Item(generateId(), nome, ic);
	}
	
	private long generateId() {
		return this.itemCounter += 1;
	}
}