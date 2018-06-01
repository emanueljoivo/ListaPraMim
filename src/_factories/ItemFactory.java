package _factories;

import _entities.item.Item;

/**
 * Interface que define métodos de criação de itens, a depender do seu tipo.
 * 
 * @author Emanuel Joivo
 */
public interface ItemFactory {
	
	/**
	 * Cria um item do tipo ItemPorQndtFixa.
	 * @return uma instância de ItemPorQndtFixa
	 */
	Item create(String nome, String categoria, int qtd, String unidadeDeMedida);
	
	/**
	 * Cria um item do tipo ItemPorUnidade.
	 * @return uma instância de ItemPorUnidade
	 */
	Item create(String nome, String categoria, int unidade);
    
	/**
	 * Cria um item do tipo ItemPorQuilo.
	 * @return uma instância de ItemPorQuilo
	 */
	Item create(String nome, String categoria, double kg);

}
