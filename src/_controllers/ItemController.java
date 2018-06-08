package _controllers;

import _services.ItemService;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
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
	 */
	public ItemController(ItemService itemService, ValidatorItem validator) {
		this.itemService = itemService;
		this.validator = validator;
	}
	
	/**
	 * Gerencia a adicão de um item do tipo ItemPorUnidade.
	 * @throws ItemExistException caso o item já exista na base de dados.
	 * @throws NullPointerException caso algum parâmetro seja nulo.
	 * @throws IllegalArgumentException caso algum parâmetro seja inválido.
	 */
	public int adicionaItem(String nome, String categoria, int unidade)
			throws NullPointerException, IllegalArgumentException, ItemExistException {
		
		this.validator.validaItem(nome, categoria, unidade);
		return this.itemService.adicionaItem(nome, categoria, unidade);
	}
	
	/**
	 * Gerencia a adição de um item do tipo ItemPorQuilo.
	 * @throws ItemExistException caso o item já exista na base de dados.
	 * @throws NullPointerException caso algum parâmetro seja nulo.
	 * @throws IllegalArgumentException caso algum parâmetro seja inválido.
	 */
	public int adicionaItem(String nome, String categoria, double kg)
			throws NullPointerException, IllegalArgumentException, ItemExistException {
		
		this.validator.validaItem(nome, categoria, kg);
		return this.itemService.adicionaItem(nome, categoria, kg);
	}
	
	/**
	 * Gerencia a adição de um ItemPorQntdFixa.
	 * @throws ItemExistException caso o item já exista na base de dados.
	 * @throws NullPointerException caso algum parâmetro seja nulo.
	 * @throws IllegalArgumentException caso algum parâmetro seja inválido.
	 */
	public int adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida)
			throws IllegalArgumentException, NullPointerException, ItemExistException {
		
		this.validator.validaItem(nome, categoria, qtd, unidadeDeMedida);
		return this.itemService.adicionaItem(nome, categoria, qtd, unidadeDeMedida);
	}
	
	/**
	 * Retorna uma representação em string de um item se o item existir.
	 * @throws ItemNotExistException caso o item não exista na base de dados.
	 */
	public String listaItem(int id) throws ItemNotExistException {		
		return this.itemService.recuperaItem(id).toString();
	}

	/**
	 * Gerencia a exclusão de um Item.
	 * @throws ItemNotExistException caso o item não exista na base de dados.
	 */
	public void deletaItem(int id) throws ItemNotExistException {
		this.itemService.deletaItem(id);		
	}	

	/**
	 * Gerencia a atualização de um atributo de um Item.
	 * @throws ItemNotExistException caso o item não exista na base de dados.
	 * @throws IllegalArgumentException caso algum parâmetro seja inválido.
	 */
	public void atualizaItem(int id, String atributo, String novoValor)
			throws IllegalArgumentException, ItemNotExistException {
		
		this.validator.validaAtualizacao(id, atributo);		
		this.itemService.atualizaItem(id, atributo, novoValor);		
	}

	/**
	 * Gerencia a listagem de todos os itens da base de dados.
	 * @return uma representação em string da lista de itens salvos.
	 */
    public String listaItens() {
		return this.itemService.listaItens();
    }

	/**
	 * Gerencia a listagem de todos os itens dada uma categoria, ordenados em ordem alfabética.
	 * @return uma representação em string da lista de itens de uma dada categoria.
	 */
	public String listaItens(String categoria) {

    	this.validator.validaCategoria(categoria);

    	return this.itemService.listaItens(categoria);
    }

	/**
	 * Gerencia a listagem de todos os itens pelo menor preço, ordenados em ordem alfabética.
	 * @return uma representação em string da lista de itens ordenados pelo seu menor preço.
	 */
	public String listaItensPreco() {
    	return this.itemService.listaItensPreco();
	}

	/**
	 * Gerencia a listagem de todos os itens relacionados a uma dada string pesquisada.
	 * @return uma representação em string de uma lista de itens ordenados por ordem alfabética dos itens que correspon-
	 * dem a string pesquisada.
	 */
	public String listaItensPesquisa(String strPesquisada) {
    	this.validator.ValidaPesquisa(strPesquisada);

    	return this.itemService.listaItensPesquisa(strPesquisada);
	}
}