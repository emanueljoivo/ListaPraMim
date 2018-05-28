package factory;

import entities.item.Item;

public interface ItemFactory {
	
	public Item cria(String nome, String categoria);

}
