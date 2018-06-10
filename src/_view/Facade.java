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
	
	public int adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida)
			throws IllegalArgumentException, NullPointerException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, qtd, unidadeDeMedida);
	}
	
	public int adicionaItem(String nome, String categoria, int unidade)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, unidade);
	}
	
	public int adicionaItem(String nome, String categoria, double kg)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, kg);
	}
	
	public void atualizaItem(int id, String atributo, String novoValor)
			throws IllegalArgumentException, ItemNotExistException {

		this.app.getItemController().atualizaItem(id, atributo, novoValor);
		
	}
	public String listaItem(int id) throws ItemNotExistException {
		return this.app.getItemController().listaItem(id);
	}

	public String listaItens() {
		return this.app.getItemController().listaItens();
	}

	public String listaItens(String categoria) {
		return this.app.getItemController().listaItens(categoria);
	}

	public String listaItensPreco() {
		return this.app.getItemController().listaItensPreco();
	}

	public String listaItensPesquisa(String strPesquisada) {
		return this.app.getItemController().listaItensPesquisa(strPesquisada);
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

	public void pesquisaCompraDeLista(String descritorLista, int itemId) throws ItemNotExistException, ListaDeComprasNotExistException, CompraNotExistException {
		this.app.getListaDeComprasController().pesquisaCompraDeLista(descritorLista, itemId);
	}

	public void imprimirListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {
		this.app.getListaDeComprasController().imprimirListaDeCompras(descritorLista);
	}
}