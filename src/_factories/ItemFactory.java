package _factories;

import _entities.item.Item;

public interface ItemFactory {
	
	Item create(String nome, String categoria, int qtd, String unidadeDeMedida);

	Item create(String nome, String categoria, int unidade);

	Item create(String nome, String categoria, double kg);

}
