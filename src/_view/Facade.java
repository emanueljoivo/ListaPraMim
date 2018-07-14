package _view;

import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import itemExceptions.ItemSemPrecoException;
import listaDeComprasExceptions.*;
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

	public int adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida,
                                  String localDeCompra, double precoItem)
			throws IllegalArgumentException, NullPointerException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, qtd, unidadeDeMedida, localDeCompra, precoItem);
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade,
                                      String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, unidade, localDeCompra, precoItem);
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double precoItem)
			throws NullPointerException, IllegalArgumentException, ItemExistException {

		return this.app.getItemController().adicionaItem(nome, categoria, kg, localDeCompra, precoItem);
	}

	public void atualizaItem(int id, String atributo, String novoValor)
			throws IllegalArgumentException, ItemNotExistException {

		this.app.getItemController().atualizaItem(id, atributo, novoValor);

	}

	public String exibeItem(int id) throws ItemNotExistException, NullPointerException, IllegalArgumentException {

		return this.app.getItemController().listaItem(id);
	}

	public void deletaItem(int id) throws ItemNotExistException {
		this.app.getItemController().deletaItem(id);
	}

	public void adicionaPrecoItem(int id, String localDeCompra, double precoItem) throws ItemNotExistException {
	    this.app.getItemController().adicionaPrecoItem(id, localDeCompra, precoItem);
    }

	/*
	 * US - 2 Metodos para auxiliar testes.
	 */

	public String getItem(int posicao) throws ItemNotExistException {
		return this.app.getAuxController().getItem(posicao);
	}

	public String getItemPorCategoria(String categoria, int posicao) throws ItemNotExistException {
		return this.app.getAuxController().getItemPorCategoria(categoria, posicao);
	}

	public String getItemPorMenorPreco(int posicao) throws ItemNotExistException {
		return this.app.getAuxController().getItemPorMenorPreco(posicao);
	}

	public String getItemPorPesquisa(String strPesquisada, int posicao) throws ItemNotExistException {
		return this.app.getAuxController().getItemPorPesquisa(strPesquisada, posicao);
	}

	/*
	 * US - 2
	 */

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

	/*
	 * US - 3
	 */

	public String adicionaListaDeCompras(String descritorLista) {
		return this.app.getListaDeComprasController().adicionaListaDeCompras(descritorLista);
	}

	public void adicionaCompraALista(String descritorLista, double quantidade, int itemId)
			throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

		this.app.getListaDeComprasController().adicionaCompraALista(descritorLista, quantidade, itemId);
	}

	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int novaQuantidade)
			throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException, OperacaoInvalidaException {

		this.app.getListaDeComprasController().atualizaCompraDeLista(descritorLista, itemId, operacao, novaQuantidade);
	}

	public void deletaCompraDeLista(String descritorLista, int itemId)
			throws ItemNotExistException, ListaDeComprasNotExistException, CompraNotExistException {

		this.app.getListaDeComprasController().deletaCompraDeLista(descritorLista, itemId);
	}

	public String imprimeListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {

		return this.app.getListaDeComprasController().imprimeListaDeCompras(descritorLista);
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
	 * US - 4 Métodos para auxiliar testes
	 */

	public String getItemLista(String descritorLista, int posicaoItem )
			throws IllegalArgumentException, NullPointerException, ListaDeComprasNotExistException {

		return this.app.getAuxController().getItemLista(descritorLista, posicaoItem);
	}

	public String getItemListaPorData(String data, int posicaoLista)
			throws IllegalArgumentException, NullPointerException, ParseException {

		return this.app.getAuxController().getItemListaPorData(data, posicaoLista);
	}

	public String getItemListaPorItem(int id, int posicaoLista) throws ItemNotExistException, ListaDeComprasNotExistException {

		return this.app.getAuxController().getItemListaPorItem(id, posicaoLista);
	}

	/*
	 * US - 4
	 */

	public String pesquisaListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {
		return this.app.getListaDeComprasController().pesquisaListaDeCompras(descritorLista);
	}

	public String pesquisaListasDeComprasPorData(String data) throws ParseException {
		return this.app.getListaDeComprasController().pesquisaListasDeComprasPorData(data);
	}

	public String pesquisaListasDeComprasPorItem(int id) throws ItemNotExistException {
		return this.app.getListaDeComprasController().pesquisaListasDeComprasPorItem(id);
	}

	/*
	 * US - 5
	 */

	public String geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException {

		return this.app.getListaDeComprasController().geraAutomaticaUltimaLista();
	}

	public String geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException {

		return this.app.getListaDeComprasController().geraAutomaticaItensMaisPresentes();
	}

	public String geraAutomaticaItem(String descritorItem)
			throws ListaDeComprasNotExistException, CompraNotExistException {

		return this.app.getListaDeComprasController().geraAutomaticaItem(descritorItem);
	}

	/*
	 * US6
	 */

	public String sugereMelhorEstabelecimento(String descritorLista)
			throws ListaDeComprasNotExistException, SemDadosEstabelecimentosException {
		return this.app.getListaDeComprasController().sugereMelhorEstabelecimento(descritorLista);
	}

}