package _services;

import _entities.item.comparators.CategoriaComparator;
import _entities.item.comparators.PrecoComparator;
import _factories.ItemFactory;

import _entities.item.Item;
import _repositories.ItemRepository;
import enums.ItemExceptionsMessages;
import item_exceptions.ItemExistException;
import item_exceptions.ItemNotExistException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Collections.*;

/**
 * Classe que implementa serviços oferecidos sobre itens.
 *
 */
public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;
	private ItemFactory itemFactory;
	
	
	/**
	 * Construtor que recebe por injeção uma fabrica e um repositorio
	 * dos quais este serviço é dependente.
	 * @param itemFactory objeto que provê instâncias de itens.
	 * @param itemRepository objeto responsável pelo gerenciamento da base de dados.
	 */
	public ItemServiceImpl(ItemFactory itemFactory, ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
		this.itemFactory = itemFactory;
		
	}	
	
	/**
	 * {@link ItemService#adicionaItem(String, String, int, String)}
	 */
	@Override
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, qtd, unidadeDeMedida);
			
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CONTEM_ITEM.getValue());
		}			
	}
	
	/**
	 * {@link ItemService#adicionaItem(String, String, int)}
	 */
	@Override
	public void adicionaItem(String nome, String categoria, int unidade) throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, unidade);			
		
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CONTEM_ITEM.getValue());
		};		
	}
	
	/**
	 * {@link ItemService#adicionaItem(String, String, double)}
	 */
	@Override
	public void adicionaItem(String nome, String categoria, double kg) throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, kg);
		
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CONTEM_ITEM.getValue());
		}		
	}

	/**
	 * {@link ItemService#recuperaItem(int)}
	 */
	@Override
	public Item recuperaItem(int id) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(ItemExceptionsMessages.NAO_CONTEM_ITEM.getValue());
		}
		
		return this.itemRepository.recovery(id);		
	}		

	/**
	 * {@link ItemService#deletaItem(int)}
	 */
	@Override
	public void deletaItem(int id) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(ItemExceptionsMessages.NAO_CONTEM_ITEM.getValue());
		}
		this.itemRepository.delete(id);		
	}

    /**
     * {@link ItemService#listaItens()}
     */
	@Override
	public String listaItens() {
        List<Item> itens = this.itemRepository.getItens();
        sort(itens);
        return listaDeItens(itens);
	}

	/**
	 * {@link ItemService#listaItens(String)}
	 */
	@Override
	public String listaItens(String categoria) {
		List<Item> itens = this.itemRepository.getItensByCategoria(categoria);

		CategoriaComparator comparator = new CategoriaComparator();

		sort(itens, comparator);

		return listaDeItens(itens);
	}

	/**
	 * {@link ItemService#listaItensPreco()}
	 * @return
	 */
	@Override
	public String listaItensPreco() {
		List<Item> itens = this.itemRepository.getItensByPreco();

		PrecoComparator comparator = new PrecoComparator();

		sort(itens, comparator);

		return listaDeItensByPreco(itens);
	}

	/**
	 * {@link ItemService#listaItens(String)}
	 */
	@Override
	public String listaItensPesquisa(String strPesquisada) {
		List<Item> itens = this.itemRepository.getItensBySearch(strPesquisada);
		sort(itens);

		return listaDeItens(itens);
	}

	/**
	 * Método que transforma uma lista de itens numa string de itens.
	 * @return uma representação em string para uma lista de itens;
	 */
	private String listaDeItensByPreco(List<Item> itens) {
		String itensStringifier = "";

		for (Item item : itens) {
			String menorPreco = item.getMenorPreco();
			itensStringifier += item.toString(menorPreco) + "\n";
		}
		return itensStringifier;
	}

	/**
	 * Método que transforma uma lista de itens numa string de itens.
	 * @return uma representação em string para uma lista de itens;
	 */
	private String listaDeItens(List<Item> itens) {
		String itensStringifier = "";

		for (Item item : itens) itensStringifier += item.toString() + "\n";
		return itensStringifier;
	}

	/**
	 * {@link ItemService#atualizaItem(int, String, String)}
	 */
	@Override
	public void atualizaItem(int id, String atributo, String novoValor) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(ItemExceptionsMessages.NAO_CONTEM_ITEM.getValue());
		}		
		
		this.itemRepository.recovery(id).set(atributo.toLowerCase(), novoValor);					
	}	
}