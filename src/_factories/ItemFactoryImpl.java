package _factories;

import _entities.item.Item;
import _entities.item.ItemPorQuilo;
import _entities.item.ItemPorUnidade;
import _entities.item.ItemPorQntdFixa;
import enums.ItemCategoria;

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
	 * Método que gera um ItemCategoria para ser utilizado para a criação do objeto referente a esse item.
	 * 
	 * @param categoria string com a categoria do item.
	 * @return um ItemCategoria que será passado na criação do item.
	 */
	private ItemCategoria generateCategoria(String categoria) {
		ItemCategoria[] values = ItemCategoria.values();
		int i = 0;
		while ((values[i].getValue().equals(categoria.toLowerCase().trim())) && (i < values.length)) i++;
		return values[i];
	}
	
	/**
	 * Cria um item do tipo ItemPorQndtFixa.
	 * 
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 * @return uma instância de ItemPorQndtFixa
	 */
	@Override
	public Item create(String nome, String categoria, int qtd, String unidadeDeMedida) {
		return new ItemPorQntdFixa(generateId(), nome, generateCategoria(categoria), qtd, unidadeDeMedida);
	}
	
	/**
	 * Cria um item do tipo ItemPorUnidade.
	 * 
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @return uma instância de ItemPorUnidade
	 */
	@Override
	public Item create(String nome, String categoria, int unidade) {
		return new ItemPorUnidade(generateId(), nome, generateCategoria(categoria), unidade);
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
		return new ItemPorQuilo(generateId(), nome, generateCategoria(categoria), kg);
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