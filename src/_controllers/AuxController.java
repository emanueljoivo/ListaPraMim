package _controllers;

import _services.AuxService;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import validation.ValidatorItem;
import validation.ValidatorListaDeCompras;

import java.text.ParseException;
import java.util.Date;

public class AuxController {

    private AuxService auxService;
    private ValidatorListaDeCompras validatorListaDeCompras;
    private ValidatorItem validatorItem;

    public AuxController(AuxService auxService, ValidatorListaDeCompras validatorListaDeCompras,
                         ValidatorItem validatorItem) {
        this.auxService = auxService;
        this.validatorListaDeCompras = validatorListaDeCompras;
        this.validatorItem = validatorItem;
    }

    public String getItemLista(String descritorLista, int posicaoItem)
            throws ListaDeComprasNotExistException {

        this.validatorListaDeCompras.validaPesquisaDeItemEmLista(descritorLista, posicaoItem);
        return this.auxService.getItemLista(descritorLista, posicaoItem);
    }

    public String getItemListaPorData(String data, int posicaoLista)
            throws ParseException {
        Date dataFormatada = this.validatorListaDeCompras.validaPesquisaPorData(data, posicaoLista);
        return this.auxService.getItemListaPorData(dataFormatada, posicaoLista);
    }

    public String getItemListaPorItem(int id, int posicaoLista)
            throws ItemNotExistException, ListaDeComprasNotExistException {
        this.validatorListaDeCompras.validaPesquisaPorItem(id, posicaoLista);
        return this.auxService.getItemListaPorItem(id, posicaoLista);
    }

    public String getItem(int posicao) throws ItemNotExistException {
        this.validatorItem.validaGetItem(posicao);
        return this.auxService.getItem(posicao);
    }


    public String getItemPorCategoria(String categoria, int posicao) throws ItemNotExistException {
        this.validatorItem.validaGetItemByCategory(categoria, posicao);
        return this.auxService.getItemPorCategoria(categoria, posicao);
    }

    public String getItemPorMenorPreco(int posicao) throws ItemNotExistException {
        this.validatorItem.validaGetItem(posicao);
        return this.auxService.getItemPorMenorPreco(posicao);
    }

    public String getItemPorPesquisa(String strPesquisada, int posicao) throws ItemNotExistException {
        this.validatorItem.validaGetItem(strPesquisada, posicao);
        return this.auxService.getItemPorPesquisa(strPesquisada, posicao);
    }

    public String getDataAtual() {
        return this.auxService.getDataAtual();
    }
}
