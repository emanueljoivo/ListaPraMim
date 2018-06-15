package _factories;

import _entities.item.Item;

import _entities.item.ItemPorQuilo;
import _entities.item.ItemPorUnidade;
import enums.ItemCategorias;
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
		return new ItemPorQntdFixa(generateId(), nome, generateCategoria(categoria), qtd, unidadeDeMedida);
	}
	
	/**
	 * {@link ItemFactory#create(String, String, int)}
	 */
	@Override
	public Item create(String nome, String categoria, int unidade) {
		return new ItemPorUnidade(generateId(), nome, generateCategoria(categoria), unidade);
	}
	
	/**
	 * {@link ItemFactory#create(String, String, double)}
	 */
	@Override
	public Item create(String nome, String categoria, double kg) {
		return new ItemPorQuilo(generateId(), nome, generateCategoria(categoria), kg);
	}
	
	/**
	 * Gera um identificador único inteiro para um Item de acordo com o valor de incremento
	 * e de um contador.
	 * @return um identificador único para Item.
	 */
	private int generateId() {
		return this.itemCounter += INCREMENT_VALUE;
	}

	/**
	 * Método que gera um ItemCategoria para ser utilizado para a criação do objeto referente a esse item.
	 *
	 * @param categoria string que descreve a categoria do item.
	 * @return um ItemCategoria que será passado na criação do item ou null caso não haja match da string
	 * com as categorias.
	 */
	private ItemCategorias generateCategoria(String categoria) {
		ItemCategorias[] values = ItemCategorias.values();

		int i = 0;
		while (!(values[i].getValue().equals(categoria.toLowerCase().trim())) && (i < (values.length - 1))) i++;

		return values[i];
	}
}