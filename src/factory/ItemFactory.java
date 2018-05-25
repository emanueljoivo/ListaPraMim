package factory;

import model.Item;

public interface ItemFactory {
	
	public Item cria(String nome, String categoria);

}
