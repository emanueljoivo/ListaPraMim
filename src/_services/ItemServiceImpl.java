package _services;

import _factories.ItemFactory;

import _entities.item.Item;
import _repositories.ItemRepository;
import enums.ItemExceptionsMessages;
import item_exceptions.ItemExistException;
import item_exceptions.ItemNotExistException;

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
	 * @param itemFactory
	 * @param itemRepository
	 */
	public ItemServiceImpl(ItemFactory itemFactory, ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
		this.itemFactory = itemFactory;
		
	}	
	
	/**
	 * Gerencia adição de itens do tipo ItemPorQntdFixa.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 */
	@Override
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, qtd, unidadeDeMedida);
			
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CONTEM_ITEM.getValue());
		}			
	}
	
	/**
	 * Gerencia adição de itens do tipo ItemPorUnidade.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 * @throws ItemExistException 
	 */
	@Override
	public void adicionaItem(String nome, String categoria, int unidade) throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, unidade);			
		
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CONTEM_ITEM.getValue());
		};		
	}
	
	/**
	 * Gerencia adição de itens do tipo ItemPorQuilo.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 */
	@Override
	public void adicionaItem(String nome, String categoria, double kg) throws ItemExistException {
		Item itemAtual = this.itemFactory.create(nome, categoria, kg);
		
		if (!this.itemRepository.save(itemAtual)) {
			throw new ItemExistException(ItemExceptionsMessages.CONTEM_ITEM.getValue());
		}		
	}

	/**
	 * Pega um item a partir do seu id.
	 * @param id
	 * @return o Item correspondente ao id.
	 * @throws ItemNotExistException 
	 */
	@Override
	public Item recuperaItem(int id) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(ItemExceptionsMessages.NAO_CONTEM_ITEM.getValue());
		}
		
		return this.itemRepository.recovery(id);		
	}		

	/**
	 * Deleta um item.
	 * @param id
	 * @param novoNome
	 * @throws ItemNotExistException 
	 */
	@Override
	public void deletaItem(int id) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(ItemExceptionsMessages.NAO_CONTEM_ITEM.getValue());
		}
		this.itemRepository.delete(id);		
	}
	
	/**
	 * @see {@link _services.ItemService#atualizaItem(int, String, String)}
	 */
	@Override
	public void atualizaItem(int id, String atributo, String novoValor) throws ItemNotExistException {
		if (!this.itemRepository.contains(id)) {
			throw new ItemNotExistException(ItemExceptionsMessages.NAO_CONTEM_ITEM.getValue());
		}		
		
		this.itemRepository.recovery(id).set(atributo.toLowerCase(), novoValor);					
	}	
}