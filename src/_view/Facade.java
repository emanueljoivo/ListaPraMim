package _view;

import item_exceptions.ItemExistException;
import item_exceptions.ItemNotExistException;
import main.Application;

/**
 * Implementação da Facade.
 *
 */
public class Facade  {
	
	private Application system;
	
	public Facade(Application system) {
		this.system = system;
	}
	
	public void start() {
		this.system.init();		
	}	
	
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws IllegalArgumentException, NullPointerException, ItemExistException {
		this.system.getItemController().adicionaItem(nome, categoria, qtd, unidadeDeMedida);
	}
	
	public void adicionatem(String nome, String categoria, int unidade) throws NullPointerException, IllegalArgumentException, ItemExistException {
		this.system.getItemController().adicionaItem(nome, categoria, unidade);
	}
	
	public void adicionaItem(String nome, String categoria, double kg) throws NullPointerException, IllegalArgumentException, ItemExistException {
		this.system.getItemController().adicionaItem(nome, categoria, kg);
	}
	
	public void atualizaItem(int id, String atributo, String novoValor) throws IllegalArgumentException, ItemNotExistException {
		this.system.getItemController().atualizaItem(id, atributo, novoValor);
		
	}
	public void listaItem(int id) throws ItemNotExistException {
		this.system.getItemController().listaItem(id);
	}

	public void listaItens() {
		System.out.println(this.system.getItemController().listaItens());
	}

	public void listaItens(String categoria) {
		System.out.println(this.system.getItemController().listaItens(categoria));
	}

	public void listaItensPreco() {
		this.system.getItemController().listaItensPreco();
	}

	public void listaItensPesquisa(String strPesquisada) {
		this.system.getItemController().listaItensPesquisa(strPesquisada);
	}
	
	public void deletaItem(int id) throws ItemNotExistException {
		this.system.getItemController().deletaItem(id);
	}

	public void adicionaListaDeCompras(String descritor) {
		this.system.getListaDeComprasController().adicionaListaDeCompras(descritor);
	}
}