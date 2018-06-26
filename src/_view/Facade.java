package _view;

import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import itemExceptions.ItemSemPrecoException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import main.Application;

import java.text.ParseException;

/**
 * Implementação da Facade.
 *
 */
public class Facade {

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

	public String exibirItem(int id) throws ItemNotExistException, NullPointerException, IllegalArgumentException {

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

	public String listaItensPorCategoria(String categoria) throws NullPointerException, IllegalArgumentException {

		return this.app.getItemController().listaItens(categoria);
	}

	public String listaItensPorMenorPreco() {
		return this.app.getItemController().listaItensPreco();
	}

	public String listaItensPesquisa(String strPesquisada) {
		return this.app.getItemController().listaItensPesquisa(strPesquisada);
	}

	/*Opcao 1 */

	public String getItemListaItens(int index) {
		String[] itens = listaItens().split(System.lineSeparator());

		if (index - 1 < itens.length)
			return itens[index - 1];

		return "Item nao encontrado";
	}

	public String getItemListaItensPorCategoria(int index, String categoria){
		String[] itens = listaItensPorCategoria(categoria).split(System.lineSeparator());

		if (index - 1 < itens.length)
			return itens[index - 1];

		return "Item nao encontrado";
	}

	public String getItemListaItensPorMenorPreco(int index) {
		String[] itens = listaItensPorMenorPreco().split(System.lineSeparator());

		if (index - 1 < itens.length)
			return itens[index - 1];

		return "Item nao encontrado";
	}

	public String getItemListaItensPesquisa(int index, String strPesquisada) {
		String[] itens = listaItensPesquisa(strPesquisada).split(System.lineSeparator());

		if (index - 1 < itens.length)
			return itens[index - 1];

		return "Item nao encontrado";
	}
	
	/*Opcao 2 */
	
	public String getItemLista(String descritorDaLista, String stringPesquisada, int index) {
		
		String[] itens = {};
		
		if(descritorDaLista.equals("categoria"))
			itens = listaItensPorCategoria(stringPesquisada).split(System.lineSeparator());
		else if(descritorDaLista.equals("preco"))
			itens = listaItensPorMenorPreco().split(System.lineSeparator());
		else if(descritorDaLista.equals("pesquisa"))
			itens = listaItensPesquisa(stringPesquisada).split(System.lineSeparator());
		else if(descritorDaLista.equals("todos"))
			itens = listaItens().split(System.lineSeparator());
			
		if (index - 1 < itens.length)
			return itens[index - 1];

		return "Item nao encontrado";
	}

	/*
	 * US - 3
	 */

	public void adicionaListaDeCompras(String descritorLista) {
		this.app.getListaDeComprasController().adicionaListaDeCompras(descritorLista);
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

	public String imprimirListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {

		return this.app.getListaDeComprasController().imprimirListaDeCompras(descritorLista);
	}

	public String pesquisaCompraEmLista(String descritorLista, int itemId)
			throws ItemNotExistException, ListaDeComprasNotExistException, CompraNotExistException {

		return this.app.getListaDeComprasController().pesquisaCompraEmLista(descritorLista, itemId);
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra)
			throws ListaDeComprasNotExistException {

		this.app.getListaDeComprasController().finalizaListaDeCompras(descritorLista, localDaCompra,
				valorFinalDaCompra);
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

	/*
	 * US - 5
	 */

	public void geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException {

		this.app.getListaDeComprasController().geraAutomaticaUltimaLista();
	}

	public void geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException {

		this.app.getListaDeComprasController().geraAutomaticaItensMaisPresentes();
	}

	public void geraAutomaticaItem(String descritorItem)
			throws ListaDeComprasNotExistException, CompraNotExistException {

		this.app.getListaDeComprasController().geraAutomaticaItem(descritorItem);
	}

	/*
	 * US6
	 */

	public String sugereMelhorEstabelecimento(String descritorLista)
			throws ListaDeComprasNotExistException, ItemSemPrecoException {
		return this.app.getListaDeComprasController().sugereMelhorEstabelecimento(descritorLista);
	}

}