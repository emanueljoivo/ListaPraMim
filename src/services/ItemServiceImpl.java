package services;

import factory.ItemFactory;
import model.Item;
import repository.ItemRepository;

public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;
	private ItemFactory itemFactory;
		
	public ItemServiceImpl(ItemFactory itemFactory, ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
		this.itemFactory = itemFactory;
	}	
	
	@Override
	public void cria(String nome, String categoria) {
		Item itemAtual = this.itemFactory.cria(nome, categoria);
		this.itemRepository.save(itemAtual);
	}

	@Override
	public void ler(long id) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void atualiza(long id) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void deleta(long id) {
		// TODO Auto-generated method stub		
	}
}