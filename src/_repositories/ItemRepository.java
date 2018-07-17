package _repositories;

import _entities.item.Item;

import java.io.Serializable;
import java.util.List;

/**
 * Repositório de itens. Extende o repositório genérico
 * oferecendo assim um CRUD básico.
 * 
 * @author Emanuel Joivo
 *
 */
public interface ItemRepository extends Repository<Item>, Serializable {

    /**
     * Pega uma lista com todos os itens do sistema.
     * @return uma lista de itens.
     */
    List<Item> getItens();

    /**
     * Pega uma lista com todos os itens do sistema de uma dada categoria.
     * @return uma lista de itens de uma dada categoria.
     */
    List<Item> getItensByCategoria(String categoria);

    /**
     * Pega uma lista de itens com o mapa de preços não vazio.
     * @return uma lista de itens que contenham pelo menos um preço.
     */
    List<Item> getItensByPreco();

    /**
     * Pega uma lista de itens relacionados com uma dada string.
     * @return uma lista de itens relacionados com uma dada string
     */
    List<Item> getItensBySearch(String strPesquisada);

    boolean contains(String itemName);
}
	
