package controller;

import services.ItemService;

public class ItemController {
	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public void criaItem(String nome) {
		if (nome != null && !nome.trim().isEmpty()) {
			this.itemService.cria(nome, "a");
		} else {
			throw new IllegalArgumentException("Campos de entrada inválidos.");
		}		
	}	
	
	public String listaItem(long id) {
		return this.itemService.ler(id).toString();
	}
}