package _services;

import _entities.comparators.PrecoComparator;
import _factories.ItemFactory;

import _entities.item.Item;
import _repositories.ItemRepository;
import enums.ItemExceptionsMessages;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;

import java.util.List;

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
	 * {@link ItemService#adicionaItem(String, String, int, String, double)}
	 */
	@Override
	public int adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra,
							double precoItem) throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, qtd, unidadeDeMedida);
			
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CADASTRO_INVALIDO_ITEM_EXIST.getErrorMessage());
		}
		itemAtual.getMapaDePrecos().put(localDeCompra, precoItem);

		return itemAtual.getId();
	}
	
	/**
	 * {@link ItemService#adicionaItem(String, String, int,String, double)}
	 */
	@Override
	public int adicionaItem(String nome, String categoria, int unidade, String localDeCompra, double precoItem)
			throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, unidade);			
		
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CADASTRO_INVALIDO_ITEM_EXIST.getErrorMessage());
		}
		itemAtual.getMapaDePrecos().put(localDeCompra, precoItem);
		return itemAtual.getId();
	}
	
	/**
	 * {@link ItemService#adicionaItem(String, String, double, String, double)}
	 */
	@Override
	public int adicionaItem(String nome, String categoria, double kg, String localDeCompra, double precoItem)
			throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, kg);
		
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CADASTRO_INVALIDO_ITEM_EXIST.getErrorMessage());
		}
		itemAtual.getMapaDePrecos().put(localDeCompra, precoItem);
		return itemAtual.getId();
	}

	/**
	 * {@link ItemService#recuperaItem(int)}
	 */
	@Override
	public Item recuperaItem(int id) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(
					ItemExceptionsMessages.LISTAGEM_INVALIDA_ITEM_NOT_EXIST.getErrorMessage());
		}
		
		return this.itemRepository.recovery(id);		
	}		

	/**
	 * {@link ItemService#deletaItem(int)}
	 */
	@Override
	public void deletaItem(int id) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(
					ItemExceptionsMessages.EXCLUSAO_INVALIDA_ITEM_NOT_EXIST.getErrorMessage());
		}
		this.itemRepository.delete(id);		
	}

	@Override
	public String getItem(int posicao) throws ItemNotExistException {
		List<Item> itens = this.itemRepository.getItens();
		sort(itens);

		Item itemAtual = itemNotNull(itens, posicao);
		return itemAtual.toString();
	}

	@Override
	public String getItemPorCategoria(String categoria, int posicao) throws ItemNotExistException {
		List<Item> itens = this.itemRepository.getItensByCategoria(categoria);
		sort(itens);

		Item itemAtual = itemNotNull(itens, posicao);
		return itemAtual.toString();
	}

	@Override
	public String getItemPorMenorPreco(int posicao) throws ItemNotExistException {
		List<Item> itens = this.itemRepository.getItensByPreco();
		PrecoComparator comparator = new PrecoComparator();
		sort(itens, comparator);

		Item itemAtual = itemNotNull(itens, posicao);

		return itemAtual.toString();
	}

	@Override
	public String getItemPorPesquisa(String strPesquisada, int posicao) throws ItemNotExistException {
		List<Item> itens = this.itemRepository.getItensBySearch(strPesquisada);
		sort(itens);

		Item itemAtual = itemNotNull(itens, posicao);

		return itemAtual.toString();
	}

	@Override
	public void adicionaPrecoItem(int id, String localDeCompra, double precoItem) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(ItemExceptionsMessages.CADASTRO_DE_PRECO_ITEM_NOT_EXIST.getErrorMessage());
		}

		this.itemRepository.recovery(id).getMapaDePrecos().put(localDeCompra, precoItem);
	}

	/**
	 * {@link ItemService#atualizaItem(int, String, String)}
	 */
	@Override
	public void atualizaItem(int id, String atributo, String novoValor) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(
					ItemExceptionsMessages.ATUALIZACAO_INVALIDA_ITEM_NOT_EXIST.getErrorMessage());
		}		
		
		this.itemRepository.recovery(id).set(atributo.toLowerCase(), novoValor);					
	}

	private Item itemNotNull(List<Item> itens, int posicao) throws ItemNotExistException {
		try {
			return itens.get(posicao);
		} catch (IndexOutOfBoundsException e) {
			throw new ItemNotExistException(
					ItemExceptionsMessages.PESQUISA_INVALIDA_ITEM_NOT_EXIST.getErrorMessage());
		}
	}
}