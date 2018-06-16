package _view;

import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import main.Application;

import java.text.ParseException;

/**
 * Implementação da Facade.
 *
 */
public class Facade  {
	
	private Application app;
	
	public Facade(Application app) {
		this.app = app;
		this.app.init();
	}

	/*
	 * US - 1
	 */
	
	public int adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida)
			throws IllegalArgumentException, NullPointerException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, qtd, unidadeDeMedida);
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, unidade);
	}
	
	public int adicionaItemPorQuilo(String nome, String categoria, double kg)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, kg);
	}
	
	public void atualizaItem(int id, String atributo, String novoValor)
			throws IllegalArgumentException, ItemNotExistException {

		this.app.getItemController().atualizaItem(id, atributo, novoValor);
		
	}
	public String exibirItem(int id)
			throws ItemNotExistException, NullPointerException, IllegalArgumentException {

		return this.app.getItemController().listaItem(id);
	}

	public void deletaItem(int id) throws ItemNotExistException {
		this.app.getItemController().deletaItem(id);
	}

	/*
	 * US - 2
	 */

	public String listaItens() {

		return this.app.getItemController().listaItens();
	}

	public String listaItensPorCategoria(String categoria)
		throws NullPointerException, IllegalArgumentException {

		return this.app.getItemController().listaItens(categoria);
	}

	public String listaItensPorMenorPreco() {
		return this.app.getItemController().listaItensPreco();
	}

	public String listaItensPesquisa(String strPesquisada) {
		return this.app.getItemController().listaItensPesquisa(strPesquisada);
	}

	/*
	 * US - 3
	 */

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

	public void deletaCompraDeLista(String descritorLista, int itemId)
			throws ItemNotExistException, ListaDeComprasNotExistException, CompraNotExistException {

		this.app.getListaDeComprasController().deletaCompraDeLista(descritorLista, itemId);
	}

	public void imprimirListaDeCompras(String descritorLista)
			throws ListaDeComprasNotExistException {

		this.app.getListaDeComprasController().imprimirListaDeCompras(descritorLista);
	}

	public void pesquisaCompraDeLista(String descritorLista, int itemId)
			throws ItemNotExistException, ListaDeComprasNotExistException, CompraNotExistException {

		this.app.getListaDeComprasController().pesquisaCompraDeLista(descritorLista, itemId);
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra)
			throws ListaDeComprasNotExistException {

		this.app.getListaDeComprasController().finalizaListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
	}

	/*
	 * US - 4
	 */

	public void pesquisaListaDeCompra(String descritorLista)
			throws IllegalArgumentException, NullPointerException, ListaDeComprasNotExistException {

		this.app.getListaDeComprasController().pesquisaListaDeCompras(descritorLista);
	}

	public void pesquisaListasDeComprasPorData(String data)
			throws IllegalArgumentException, NullPointerException, ParseException {

		this.app.getListaDeComprasController().pesquisaListasDeComprasPorData(data);
	}

	public void pesquisaListasDeComprasPorItem(int id) throws ItemNotExistException {

		this.app.getListaDeComprasController().pesquisaListasDeComprasPorItem(id);
	}

}