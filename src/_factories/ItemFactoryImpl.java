package _factories;

import _entities.item.Item;
import _entities.item.ItemPorQuilo;
import _entities.item.ItemPorUnidade;
import _entities.item.ItemPorQntdFixa;
import enums.ItemCategoria;

/**
 * Classe responsável pela implementação da criação de itens. *
 */
public class ItemFactoryImpl implements ItemFactory {
	private int itemCounter;
	private final int INCREMENT_VALUE = 1;
	
	public ItemFactoryImpl() {
		this.itemCounter = 0;
	}
	
	/**
	 * Cria um item do tipo ItemPorQndtFixa.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 * @return uma instância de ItemPorQndtFixa
	 */
	@Override
	public Item create(String nome, String categoria, int qtd, String unidadeDeMedida) {
		ItemCategoria ic;
		 try {
		 	ic = ItemCategoria.valueOf( categoria );
		 } catch (IllegalArgumentException ex) {
		 	throw new IllegalArgumentException ();
		 }

		return new ItemPorQntdFixa(generateId(), nome, ic, qtd, unidadeDeMedida);
	}
	
	/**
	 * Cria um item do tipo ItemPorUnidade.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @return uma instância de ItemPorUnidade
	 */
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
	
	/**
	 * Cria um item do tipo ItemPorQuilo.
	 * @param nome
	 * @param categoria
	 * @param kg
	 * @return uma instância de ItemPorQuilo
	 */
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
	
	/**
	 * Gera um id para Item de acordo com o valor de incremento
	 * e de um contador.
	 * @return um id para Item.
	 */
	private int generateId() {
		return this.itemCounter += INCREMENT_VALUE;
	}

	
}