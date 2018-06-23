package _controllers;

import _services.ListaDeComprasService;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import validation.ValidatorListaDeCompras;

import java.text.ParseException;
import java.util.Date;

/**
 * Controlador de lista de compras responsavel pelo gerenciamento e direcionamento do
 * @author Emanuel Joivo.
 */
public class ListaDeComprasController {

    private ValidatorListaDeCompras validator;
    private ListaDeComprasService service;

    /**
     * Construtor que recebe por injecao um provedor de servicos sobre lista de compras e um provedor de validacao.
     * @param validator provem validacao de dados para as operacoes sobre lista de compras.
     * @param service provem servicos de logica de negocio para as operacoes sobre lista de compras.
     */
    public ListaDeComprasController(ValidatorListaDeCompras validator, ListaDeComprasService service) {
        this.validator = validator;
        this.service = service;
    }

    /**
     * Gerencia a criacao e adicao de uma nova lista de compras.
     * @param descritor
     */
    public void adicionaListaDeCompras(String descritor) {
        this.validator.validaDescritor(descritor);
        this.service.adicionaNovaLista(descritor);
    }

    public void adicionaCompraALista(String descritorLista, double quantidade, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

        this.validator.validaCompra(descritorLista, quantidade, itemId);
        this.service.adicionaNovaCompra(descritorLista, quantidade, itemId);
    }

    public void adicionaCompraALista(String descritorLista, int quantidade, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

        adicionaCompraALista(descritorLista, (double) quantidade, itemId);
    }

    public void atualizaCompraDeLista(String descritorLista, int itemId, int novaQuantidade)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {

        this.validator.validaAtualizacao(descritorLista, itemId, novaQuantidade);
        this.service.atualizaCompraDeLista(descritorLista, itemId, novaQuantidade);
    }

    public void deletaCompraDeLista(String descritorLista, int itemId)
            throws CompraNotExistException, ListaDeComprasNotExistException, ItemNotExistException {

        this.validator.validaExclusao(descritorLista, itemId);
        this.service.deletaCompraDeLista(descritorLista, itemId);
    }

    public String pesquisaCompraDeLista(String descritorLista, int itemId)
            throws CompraNotExistException, ListaDeComprasNotExistException, ItemNotExistException {

        this.validator.validaPesquisa(descritorLista, itemId);
        return this.service.pesquisaCompraDeLista(descritorLista, itemId);
    }

    public String imprimirListaDeCompras(String descritorLista)
            throws ListaDeComprasNotExistException {

        this.validator.validaDescritor(descritorLista);
        return this.service.imprimirListaDeCompras(descritorLista);
    }


    public void finalizaListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra)
            throws ListaDeComprasNotExistException {

        this.validator.validaFinalizacaoDeLista(descritorLista, localDaCompra, valorFinalDaCompra);
        this.service.finalizaListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
    }

    public String pesquisaListaDeCompras(String descritorLista)
            throws ListaDeComprasNotExistException {

        this.validator.validaPesquisa(descritorLista);
        return this.service.pesquisaListaDeCompras(descritorLista);
    }

    public String pesquisaListasDeComprasPorData(String data)
            throws ParseException {

        Date dataFormatada = this.validator.validaPesquisaPorData(data);
        return this.service.pesquisaListasDeComprasPorData(dataFormatada);
    }

    public String pesquisaListasDeComprasPorItem(int id)
            throws ItemNotExistException {

        this.validator.validaPesquisaPorItem(id);
        return this.service.pesquisaListasDeComprasPorItem(id);
    }
    
    /*
     * US5
     */
    
	public void geraAutomaticaUltimaLista()
			throws ListaDeComprasNotExistException, CompraNotExistException {
		this.service.geraAutomaticaUltimaLista();
	}

	public void geraAutomaticaItensMaisPresentes() 
			throws ListaDeComprasNotExistException, CompraNotExistException {
		this.service.geraAutomaticaItensMaisPresentes();
	}

	public void geraAutomaticaItem(String descritorItem)
			throws ListaDeComprasNotExistException, CompraNotExistException {
		this.service.geraAutomaticaItem(descritorItem);
	}
	
	/*
	 * US6
	 */
	
	
    
}
