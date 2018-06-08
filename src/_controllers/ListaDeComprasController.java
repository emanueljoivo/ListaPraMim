package _controllers;

import _services.ListaDeComprasService;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import validation.ValidatorListaDeCompras;

public class ListaDeComprasController {

    private ValidatorListaDeCompras validator;
    private ListaDeComprasService service;

    public ListaDeComprasController(ValidatorListaDeCompras validator, ListaDeComprasService service) {
        this.validator = validator;
        this.service = service;
    }

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

        return this.service.pesquisaCompraDeLista(descritorLista, itemId).toString();

    }

    /* ToDo: Uma compra de uma lista de compras pode ser pesquisada usando o identificador do item a ser comprado. */


}
