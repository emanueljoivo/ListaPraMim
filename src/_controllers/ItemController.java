package _controllers;

import _services.ItemService;
import validation.ValidatorItem;
import validation.ValidatorItemImpl;

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
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
		this.validator = new ValidatorItemImpl();
	}
	
	/**
	 * Gerencia a adicão de um item do tipo ItemPorUnidade.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 */
	public void adicionaItem(String nome, String categoria, int unidade)
			throws NullPointerException, IllegalArgumentException {
		this.validator.validaItem(nome, categoria, unidade);
		this.itemService.adicionaItem(nome, categoria, unidade);		
	}
	
	/**
	 * Gerencia a adição de um item do tipo ItemPorQuilo.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 */
	public void adicionaItem(String nome, String categoria, double kg)
			throws NullPointerException, IllegalArgumentException {
		this.validator.validaItem(nome, categoria, kg);
		this.itemService.adicionaItem(nome, categoria, kg);
	}
	
	/**
	 * Gerencia a adição de um ItemPorQntdFixa.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 */
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida)
			throws IllegalArgumentException, NullPointerException {
		this.validator.validaItem(nome, categoria, qtd, unidadeDeMedida);
		this.itemService.adicionaItem(nome, categoria, qtd, unidadeDeMedida);
	}
	
	/**
	 * Gerencia a recuperação de um Item.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 */
	public String listaItem(int id) {
		return this.itemService.recuperaItem(id).toString();
	}

	/**
	 * Gerencia a exclusão de um Item.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 */
	public void deletaItem(int id) {
		this.itemService.deletaItem(id);		
	}	

	/**
	 * Gerencia a atualização do nome de um Item.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 */
	public void atualizaNomeItem(int id, String novoNome) {
		this.itemService.atualizaItem(id, novoNome);		
	}
	
	/**
	 * Gerencia a atualização da categoria de um Item.
	 * @param nome
	 * @param categoria
	 * @param unidade
	 */
	public void atualizaCategoriaItem(int id, String novaCategoria) {
		this.itemService.atualizaItem(novaCategoria, id);
		
	}	
}