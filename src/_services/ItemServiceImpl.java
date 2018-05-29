package _services;

import _factories.ItemFactory;
import _entities.item.Item;
import _repositories.ItemRepository;
import enums.ItemCategoria;

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
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws IllegalArgumentException {
		Item itemAtual;
		try {
			itemAtual = this.itemFactory.create(nome, categoria, qtd, unidadeDeMedida);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException( ex.getMessage ());
		}

		this.itemRepository.save(itemAtual);
	}
	
	/**
	 * Gerencia adição de itens do tipo ItemPorUnidade.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 */
	@Override
	public void adicionaItem(String nome, String categoria, int unidade) {
		Item itemAtual;
		try {
			itemAtual = this.itemFactory.create(nome, categoria, unidade);			
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException();
		}
		
		this.itemRepository.save(itemAtual);		
	}
	
	/**
	 * Gerencia adição de itens do tipo ItemPorQuilo.
	 * @param nome
	 * @param categoria
	 * @param qtd
	 * @param unidadeDeMedida
	 */
	@Override
	public void adicionaItem(String nome, String categoria, double kg) {
		Item itemAtual;
		try {
			itemAtual = this.itemFactory.create(nome, categoria, kg);			
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException();
		}
		
		this.itemRepository.save(itemAtual);		
	}

	/**
	 * Pega um item a partir do seu id.
	 * @param id
	 * @return o Item correspondente ao id.
	 */
	@Override
	public Item recuperaItem(int id) {
		return this.itemRepository.recovery(id);		
	}		

	/**
	 * Atualiza nome de um item.
	 * @param id
	 * @param novoNome
	 */
	@Override
	public void deletaItem(int id) {
		this.itemRepository.delete(id);		
	}

	/**
	 * Atualiza categoria de um item.
	 * @param categoria
	 * @param id
	 */
	@Override
	public void atualizaItem(int id, String novoNome) {
		this.itemRepository.recovery(id).setNome(novoNome);		
	}
	
	/**
	 * Apaga um item pelo id.
	 * @param id
	 */
	@Override
	public void atualizaItem(String categoria, int id) {
		this.itemRepository.recovery(id).setCategoria(ItemCategoria.valueOf(categoria));
	}	
}