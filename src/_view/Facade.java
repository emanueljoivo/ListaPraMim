package _view;

import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import main.Application;

/**
 * Implementação da Facade.
 *
 */
public class Facade  {
	
	private Application app;
	
	public Facade(Application app) {
		this.app = app;
	}
	
	public void start() {
		this.app.init();
	}	
	
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida)
			throws IllegalArgumentException, NullPointerException, ItemExistException {

		this.app.getItemController().adicionaItem(nome, categoria, qtd, unidadeDeMedida);
	}
	
	public void adicionatem(String nome, String categoria, int unidade)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		this.app.getItemController().adicionaItem(nome, categoria, unidade);
	}
	
	public void adicionaItem(String nome, String categoria, double kg)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		this.app.getItemController().adicionaItem(nome, categoria, kg);
	}
	
	public void atualizaItem(int id, String atributo, String novoValor)
			throws IllegalArgumentException, ItemNotExistException {

		this.app.getItemController().atualizaItem(id, atributo, novoValor);
		
	}
	public void listaItem(int id) throws ItemNotExistException {
		this.app.getItemController().listaItem(id);
	}

	public void listaItens() {
		this.app.getItemController().listaItens();
	}

	public void listaItens(String categoria) {
		this.app.getItemController().listaItens(categoria);
	}

	public void listaItensPreco() {
		this.app.getItemController().listaItensPreco();
	}

	public void listaItensPesquisa(String strPesquisada) {
		this.app.getItemController().listaItensPesquisa(strPesquisada);
	}
	
	public void deletaItem(int id) throws ItemNotExistException {
		this.app.getItemController().deletaItem(id);
	}

	public void adicionaListaDeCompras(String descritorLista) {
		this.app.getListaDeComprasController().adicionaListaDeCompras(descritorLista);
	}

	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId)
			throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

		this.app.getListaDeComprasController().adicionaCompraALista(descritorLista, quantidade, itemId);
	}

	public void adicionaCompraALista(String descritorLista, double quantidade, int itemId)
			throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

		this.app.getListaDeComprasController().adicionaCompraALista(descritorLista, quantidade, itemId);
	}

	public void atualizaCompraDeLista(String descritorLista, int itemId, int novaQuantidade)
			throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {

		this.app.getListaDeComprasController().atualizaCompraDeLista(descritorLista, itemId, novaQuantidade);
	}

	public void deletaCompraDeLista(String descritorLista, int itemId) throws ItemNotExistException, ListaDeComprasNotExistException, CompraNotExistException {
		this.app.getListaDeComprasController().deletaCompraDeLista(descritorLista, itemId);
	}

	public void pesquisaCompraDeLista(String descritorLista, int itemId) {
		this.app.getListaDeComprasController().pesquisaCompraDeLista(descritorLista, itemId);
	}
}