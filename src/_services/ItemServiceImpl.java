package _services;

import _factories.ItemFactory;

import _entities.item.Item;
import _repositories.ItemRepository;
import enums.ItemExceptionsMessages;
import item_exceptions.ItemExistException;
import item_exceptions.ItemNotExistException;

import java.util.Collections;
import java.util.List;

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
     * {@link ItemService#listaItems()}
     */
	@Override
	public String listaItems() {
        List<Item> tempList = this.itemRepository.getItens();
        Collections.sort(tempList);
        return tempList.toString();
	}

	/**
	 * @see ItemService#atualizaItem(int, String, String)
	 */
	@Override
	public void atualizaItem(int id, String atributo, String novoValor) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(ItemExceptionsMessages.NAO_CONTEM_ITEM.getValue());
		}		
		
		this.itemRepository.recovery(id).set(atributo.toLowerCase(), novoValor);					
	}	
}