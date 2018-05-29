package _controllers;

import _services.ItemService;
import util.Validator;

public class ItemController {
	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public void adicionaItem(String nome, String categoria, int unidade) {
		this.itemService.adicionaItem(nome, categoria, unidade);		
	}
	
	public void adicionaItem(String nome, String categoria, double kg) {
		this.itemService.adicionaItem(nome, categoria, kg);		
	}
	
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws IllegalArgumentException {

		try {
			Validator.validatorString(nome,categoria);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex.getMessage());
		} 

		this.itemService.adicionaItem(nome, categoria, qtd, unidadeDeMedida);

	}
	
	public String listaItem(int id) {
		return this.itemService.lerItem(id).toString();
	}

	public void deletaItem(int id) {
		this.itemService.deletaItem(id);
		
	}	

	public void atualizaNomeItem(int id, String novoNome) {
		this.itemService.atualizaItem(id, novoNome);		
	}
	
	public void atualizaCategoriaItem(int id, String novaCategoria) {
		this.itemService.atualizaItem(novaCategoria, id);
		
	}
	
	

	

	
}