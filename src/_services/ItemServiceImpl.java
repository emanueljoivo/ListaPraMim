package _services;

import _factories.ItemFactory;
import _entities.item.Item;
import _repositories.ItemRepository;
import enums.ItemCategoria;

public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;
	private ItemFactory itemFactory;
		
	public ItemServiceImpl(ItemFactory itemFactory, ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
		this.itemFactory = itemFactory;
	}	
	
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

	@Override
	public Item lerItem(int id) {
		return this.itemRepository.read(id);		
	}		

	@Override
	public void deletaItem(int id) {
		this.itemRepository.delete(id);		
	}

	@Override
	public void atualizaItem(int id, String novoNome) {
		this.itemRepository.read(id).setNome(novoNome);		
	}

	@Override
	public void atualizaItem(String categoria, int id) {
		this.itemRepository.read(id).setCategoria(ItemCategoria.valueOf(categoria));
	}	
}