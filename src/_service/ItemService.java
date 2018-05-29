package _service;

import _entities.item.Item;

public interface ItemService {

	public void cria(String nome, String categoria);
	
	public Item ler(long id);
	
	public void atualiza(long id);
	
	public boolean deleta(long id);
	
}
