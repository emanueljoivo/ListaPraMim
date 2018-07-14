package _controllers;

import _services.ListaDeComprasService;
import itemExceptions.ItemNotExistException;
import itemExceptions.ItemSemPrecoException;
import listaDeComprasExceptions.*;
import validation.ValidatorListaDeCompras;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 * Controlador de lista de compras responsavel pelo gerenciamento e direcionamento do
 * @author Emanuel Joivo.
 */
public class ListaDeComprasController implements Serializable {

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
    public String adicionaListaDeCompras(String descritor) {
        this.validator.validaCriacao(descritor);
        return this.service.adicionaNovaLista(descritor);
    }

    public void adicionaCompraALista(String descritorLista, double quantidade, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

        this.validator.validaCompra(descritorLista, quantidade, itemId);
        this.service.adicionaNovaCompra(descritorLista, quantidade, itemId);
    }

    public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int novaQuantidade)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException, OperacaoInvalidaException {

        this.validator.validaAtualizacao(descritorLista, itemId, operacao, novaQuantidade);
        this.service.atualizaCompraDeLista(descritorLista, itemId,  operacao, novaQuantidade);
    }

    public void deletaCompraDeLista(String descritorLista, int itemId)
            throws CompraNotExistException, ListaDeComprasNotExistException, ItemNotExistException {

        this.validator.validaExclusao(descritorLista, itemId);
        this.service.deletaCompraDeLista(descritorLista, itemId);
    }

    public String pesquisaCompraEmLista(String descritorLista, int itemId)
            throws CompraNotExistException, ListaDeComprasNotExistException, ItemNotExistException {

        this.validator.validaPesquisa(descritorLista, itemId);
        return this.service.pesquisaCompraEmLista(descritorLista, itemId);
    }

    public String imprimeListaDeCompras(String descritorLista)
            throws ListaDeComprasNotExistException {

        this.validator.validaImpressaoDeCompra(descritorLista);
        return this.service.imprimeListaDeCompras(descritorLista);
    }


    public void finalizaListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra)
            throws ListaDeComprasNotExistException {

        this.validator.validaFinalizacaoDeLista(descritorLista, localDaCompra, valorFinalDaCompra);
        this.service.finalizaListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
    }

    /* US - 4 */

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
    
	public String geraAutomaticaUltimaLista()
			throws ListaDeComprasNotExistException, CompraNotExistException {
		return this.service.geraAutomaticaUltimaLista();
	}

	public String geraAutomaticaItensMaisPresentes() 
			throws ListaDeComprasNotExistException, CompraNotExistException {
		return this.service.geraAutomaticaItensMaisPresentes();
	}

	public String geraAutomaticaItem(String descritorItem)
			throws ListaDeComprasNotExistException, CompraNotExistException {
		return this.service.geraAutomaticaItem(descritorItem);
	}
	
	/*
	 * US6
	 */
	
	public String sugereMelhorEstabelecimento(String descritorLista) 
			throws ListaDeComprasNotExistException, SemDadosEstabelecimentosException {
		return this.service.sugereMelhorEstabelecimento(descritorLista);
	}
    
}
