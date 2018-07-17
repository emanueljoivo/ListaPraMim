package _repositories;

import java.util.*;

import _entities.item.Item;
import _entities.listaDeCompras.Compra;
import enums.ItemCategorias;
import util.Util;

/**
 * Implementação de repositório de itens. Representa comunicação
 * do sistema com o banco de dados.
 *
 */
public class ItemRepositoryImpl implements ItemRepository {
	private Set<Item> itens;	
	
	/**
	 * Construtor que inicializa estruturas em memória utilizadas para
	 * persistência.
	 */	
	public ItemRepositoryImpl() {
		this.itens = new HashSet<>();
	}
	
	/**
	 * Salva um item no banco de dados.
	 */
	@Override
	public boolean save(Item item) {
		return itens.add(item);		
	}

	/**
	 * Deleta um item do banco de dados pelo id.
	 * @return <code> true </code> caso o item seja removido com sucesso,
	 * <code> false </code> no caso contrário.
	 */
	@Override
	public boolean delete(int id) {
		Item o = findById(id);		
		return (o != null) && (itens.remove(o));
	}
	
	/**
	 * Recupera um item do banco de dados pelo id.

	 * @return o item correspondente ao id, caso exista.
	 */
	@Override
	public Item recovery(int id) {
		return findById(id);
	}
	
	/**
	 * Verifica se um item está contido na base de dados a partir do id.

	 * @return true se existe ou false se não existe o tem na base de dados.
	 */
	@Override
	public boolean contains(int id) {		
		return findById(id) != null;
	}
	
	/**
	 * Retorna Item a partir de id.
	 * @return um Item correspondente ao id.
	 */
	private Item findById(int id) {
		for (Item item : itens) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	/**
	 * {@link ItemRepository#getItens()}
	 */
	@Override
	public List<Item> getItens() {
		List<Item> listaAux = new ArrayList<>();
		listaAux.addAll(this.itens);
		return listaAux;
	}

	/**
	 * {@link ItemRepository#getItensByCategoria(String)}
	 */
	@Override
	public List<Item> getItensByCategoria(String categoria) {
		List<Item> itensDaCategoria = new ArrayList<>();

		for (Item item : this.itens) {
			if (item.getCategoria().getValue().equals(categoria)) {
				itensDaCategoria.add(item);
			}
		}
		return itensDaCategoria;
	}

	/**
	 * {@link ItemRepository#getItensByPreco()}
	 */
	@Override
	public List<Item> getItensByPreco() {
		List<Item> itensComPreco = new ArrayList<>();

		for (Item item : this.itens) {
			if (!item.getMapaDePrecos().isEmpty()) {
				itensComPreco.add(item);
			}
		}
		return itensComPreco;
	}

    /**
     * {@link ItemRepository#getItensBySearch(String)}
     */
    @Override
    public List<Item> getItensBySearch(String strPesquisada) {
        List<Item> itensRelacionados = new ArrayList<>();
        for (Item item : this.itens) {
            if (item.getNome().toLowerCase().contains(strPesquisada)
                    || item.getCategoria().getValue().toLowerCase().contains(strPesquisada)) {
                itensRelacionados.add(item);
            }
        }
	    return itensRelacionados;
    }

	@Override
	public boolean contains(String itemName) {
		for (Item item : this.itens) {
			if (item.getNome().equalsIgnoreCase(itemName)) {
				return true;
			}
		}
    	return false;
	}

	private ItemCategorias generateCategoria(String categoria) {
		return ItemCategorias.generateCategoria(categoria);
	}


}