package _factory;

import _entities.item.Item;

public interface ItemFactory {
	
	Item criaItem(String nome, String categoria);

}
