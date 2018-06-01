package _factories;

import _entities.item.Item;

import _entities.item.ItemPorQuilo;
import _entities.item.ItemPorUnidade;
import util.Util;
import _entities.item.ItemPorQntdFixa;

/**
 * Classe responsável pela implementação da criação de itens. 
 */
public class ItemFactoryImpl implements ItemFactory {
	private int itemCounter;
	private final int INCREMENT_VALUE = 1;	
	
	public ItemFactoryImpl() {
		this.itemCounter = 0;
	}	
	
	/**
	 * {@link ItemFactory#create(String, String, int, String)}
	 */
	@Override
	public Item create(String nome, String categoria, int qtd, String unidadeDeMedida) {
		return new ItemPorQntdFixa(generateId(), nome, Util.generateCategoria(categoria), qtd, unidadeDeMedida);
	}
	
	/**
	 * {@link ItemFactory#create(String, String, int)}
	 */
	@Override
	public Item create(String nome, String categoria, int unidade) {
		return new ItemPorUnidade(generateId(), nome, Util.generateCategoria(categoria), unidade);
	}
	
	/**
	 * {@link ItemFactory#create(String, String, double)}
	 */
	@Override
	public Item create(String nome, String categoria, double kg) {
		return new ItemPorQuilo(generateId(), nome, Util.generateCategoria(categoria), kg);
	}
	
	/**
	 * Gera um identificador único inteiro para um Item de acordo com o valor de incremento
	 * e de um contador.
	 * @return um identificador único para Item.
	 */
	private int generateId() {
		return this.itemCounter += INCREMENT_VALUE;
	}	
}