package _service;

import _factory.ItemFactory;
import _entities.item.Item;
import _repository.ItemRepository;

public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;
	private ItemFactory itemFactory;
		
	public ItemServiceImpl(ItemFactory itemFactory, ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
		this.itemFactory = itemFactory;
	}	
	
	@Override
	public void cria(String nome, String categoria) throws IllegalArgumentException {
		Item itemAtual;
		try {
			itemAtual = this.itemFactory.criaItem(nome, categoria);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException( ex.getMessage ());
		}

		this.itemRepository.save(itemAtual);
	}

	@Override
	public Item ler(long id) {
		return this.itemRepository.read(id);		
	}

	@Override
	public void atualiza(long id) {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean deleta(long id) {
		return this.itemRepository.delete(id);
	}
}