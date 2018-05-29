package _controller;

import _service.ItemService;
import util.Validator;

public class ItemController {
	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public void criaItem(String nome, String categoria) throws IllegalArgumentException {

		try {
			Validator.validatorString(nome,categoria);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex.getMessage());
		}

		this.itemService.cria(nome, categoria);

	}	
	
	public String listaItem(long id) {
		return this.itemService.ler(id).toString();
	}
}