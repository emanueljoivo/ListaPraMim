package _factories;

import _entities.item.Item;
import _entities.item.ItemPorQuilo;
import _entities.item.ItemPorUnidade;
import _entities.item.ItemQntdFixa;
import enums.ItemCategoria;

public class ItemFactoryImpl implements ItemFactory {
	private int itemCounter;
	
	public ItemFactoryImpl() {
		this.itemCounter = 0;
	}

	@Override
	public Item create(String nome, String categoria, int qtd, String unidadeDeMedida) {
		ItemCategoria ic;
		 try {
		 	ic = ItemCategoria.valueOf( categoria );
		 } catch (IllegalArgumentException ex) {
		 	throw new IllegalArgumentException ();
		 }

		return new ItemQntdFixa(generateId(), nome, ic, qtd, unidadeDeMedida);
	}
	
	@Override
	public Item create(String nome, String categoria, int unidade) {
		ItemCategoria ic;
		 try {
		 	ic = ItemCategoria.valueOf( categoria );
		 } catch (IllegalArgumentException ex) {
		 	throw new IllegalArgumentException ();
		 }

		return new ItemPorUnidade(generateId(), nome, ic, unidade);
	}
	
	@Override
	public Item create(String nome, String categoria, double kg) {
		ItemCategoria ic;
		 try {
		 	ic = ItemCategoria.valueOf( categoria );
		 } catch (IllegalArgumentException ex) {
		 	throw new IllegalArgumentException ();
		 }

		return new ItemPorQuilo(generateId(), nome, ic, kg);
	}	
	
	private int generateId() {
		return this.itemCounter += 1;
	}

	
}