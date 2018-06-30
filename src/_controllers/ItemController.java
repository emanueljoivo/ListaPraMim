package _controllers;

import _services.ItemService;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import validation.ValidatorItem;

/**
 * Controlador de itens, responsável pelo gerenciamento e redirecionamento de fluxo de itens. Trata requisições de
 * usuário.
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
	public int adicionaItem(String nome, String categoria, int unidade, String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException, ItemExistException {
		
		this.validator.validaCadastro(nome, categoria, unidade, localDeCompra, precoItem);
		return this.itemService.adicionaItem(nome, categoria, unidade, localDeCompra, precoItem);
	}
	
	/**
	 * Gerencia a adição de um item do tipo ItemPorQuilo.
	 * @throws ItemExistException caso o item já exista na base de dados.
	 * @throws NullPointerException caso algum parâmetro seja nulo.
	 * @throws IllegalArgumentException caso algum parâmetro seja inválido.
	 */
	public int adicionaItem(String nome, String categoria, double kg, String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		this.validator.validaCadastro(nome, categoria, kg, localDeCompra, precoItem);
		return this.itemService.adicionaItem(nome, categoria, kg, localDeCompra, precoItem);
	}
	
	/**
	 * Gerencia a adição de um ItemPorQntdFixa.
	 * @throws ItemExistException caso o item já exista na base de dados.
	 * @throws NullPointerException caso algum parâmetro seja nulo.
	 * @throws IllegalArgumentException caso algum parâmetro seja inválido.
	 */
	public int adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida,
							String localDeCompra, double precoItem)
			throws IllegalArgumentException, NullPointerException, ItemExistException {
		
		this.validator.validaCadastro(nome, categoria, qtd, unidadeDeMedida, localDeCompra, precoItem);
		return this.itemService.adicionaItem(nome, categoria, qtd, unidadeDeMedida, localDeCompra, precoItem);
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
		
		this.validator.validaAtualizacao(id, atributo, novoValor);
		this.itemService.atualizaItem(id, atributo, novoValor);		
	}

    public void adicionaPrecoItem(int id, String localDeCompra, double precoItem) throws ItemNotExistException {
        this.validator.validaAdicaoDePreco(id, localDeCompra, precoItem);

        this.itemService.adicionaPrecoItem(id, localDeCompra, precoItem);
    }

    public String getItem(int posicao) throws ItemNotExistException {
		this.validator.validaGetItem(posicao);

		return this.itemService.getItem(posicao);
    }


	public String getItemPorCategoria(String categoria, int posicao) throws ItemNotExistException {
		this.validator.validaGetItemByCategory(categoria, posicao);

		return this.itemService.getItemPorCategoria(categoria, posicao);
	}

	public String getItemPorMenorPreco(int posicao) throws ItemNotExistException {
		this.validator.validaGetItem(posicao);

		return this.itemService.getItemPorMenorPreco(posicao);
	}

	public String getItemPorPesquisa(String strPesquisada, int posicao) throws ItemNotExistException {
		this.validator.validaGetItem(strPesquisada, posicao);

		return this.itemService.getItemPorPesquisa(strPesquisada, posicao);
	}
}