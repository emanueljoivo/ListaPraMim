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
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 * @return uma instância de ItemPorQndtFixa
	 */
	Item create(String nome, String categoria, int qtd, String unidadeDeMedida);
	
	/**
	 * Cria um item do tipo ItemPorUnidade.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @return uma instância de ItemPorUnidade
	 */
	Item create(String nome, String categoria, int unidade);
    
	/**
	 * Cria um item do tipo ItemPorQuilo.
	 * @param nome
	 * @param categoria
	 * @param kg
	 * @return uma instância de ItemPorQuilo
	 */
	Item create(String nome, String categoria, double kg);

}
