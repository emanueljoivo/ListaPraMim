package factory;

import model.item.Item;

public interface ItemFactory {
	
	public Item cria(String nome, String categoria);

}
