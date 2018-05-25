package controller;

import services.ItemService;

public class ItemController {
	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public void criaItemCompravel(String nome, String categoria) {
		this.itemService.cria(nome, categoria);
	}	
}