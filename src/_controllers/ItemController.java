package _controllers;

import _services.ItemService;
import item_exceptions.ItemExistException;
import item_exceptions.ItemNotExistException;
import validation.ValidatorItem;

/**
 * Controlador de itens, responsável pelo gerenciamento e redirecionamento
 * de fluxo de itens. Trata requisições de usuário (Advindas da facade).
 * 
 * @author Emanuel Joivo
 *
 */
public class ItemController {
	private ItemService itemService;
	private ValidatorItem validator;	
	
	/**
	 * Construtor que recebe por injeção um provedor de serviços sobre itens. 
	 * 
	 * @param itemService
	 */
	public ItemController(ItemService itemService, ValidatorItem validator) {
		this.itemService = itemService;
		this.validator = validator;
		
	}
	
	/**
	 * Gerencia a adicão de um item do tipo ItemPorUnidade.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @throws ItemExistException 
	 */
	public void adicionaItem(String nome, String categoria, int unidade) 
			throws NullPointerException, IllegalArgumentException, ItemExistException {
		
		this.validator.validaItem(nome, categoria, unidade);
		this.itemService.adicionaItem(nome, categoria, unidade);		
	}
	
	/**
	 * Gerencia a adição de um item do tipo ItemPorQuilo.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @throws ItemExistException 
	 */
	public void adicionaItem(String nome, String categoria, double kg)
			throws NullPointerException, IllegalArgumentException, ItemExistException {
		
		this.validator.validaItem(nome, categoria, kg);
		this.itemService.adicionaItem(nome, categoria, kg);
	}
	
	/**
	 * Gerencia a adição de um ItemPorQntdFixa.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @throws ItemExistException 
	 */
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida)
			throws IllegalArgumentException, NullPointerException, ItemExistException {
		
		this.validator.validaItem(nome, categoria, qtd, unidadeDeMedida);
		this.itemService.adicionaItem(nome, categoria, qtd, unidadeDeMedida);
	}
	
	/**
	 * Gerencia a recuperação de um Item.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @throws ItemNotExistException 
	 */
	public String listaItem(int id) throws ItemNotExistException {		
		return this.itemService.recuperaItem(id).toString();
	}

	/**
	 * Gerencia a exclusão de um Item.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @throws ItemNotExistException 
	 */
	public void deletaItem(int id) throws ItemNotExistException {
		this.itemService.deletaItem(id);		
	}	

	/**
	 * Gerencia a atualização de um atributo de um Item.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @throws ItemNotExistException 
	 */
	public void atualizaItem(int id, String atributo, String novoValor)
			throws IllegalArgumentException, ItemNotExistException {
		
		this.validator.validaAtualizacao(id, atributo);		
		this.itemService.atualizaItem(id, atributo, novoValor);		
	}	
}