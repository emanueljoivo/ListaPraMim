package _services;

import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

import java.io.Serializable;
import java.util.Date;

public interface AuxService extends Serializable {

    String getItem(int posicao) throws ItemNotExistException;

    String getItemPorCategoria(String categoria, int posicao) throws ItemNotExistException;

    String getItemPorMenorPreco(int posicao) throws ItemNotExistException;

    String getItemPorPesquisa(String strPesquisada, int posicao) throws ItemNotExistException;

    String getItemLista(String descritorLista, int posicaoItem) throws ListaDeComprasNotExistException;

    String getItemListaPorData(Date data, int posicaoLista);

    String getItemListaPorItem(int id, int posicaoLista) throws ItemNotExistException, ListaDeComprasNotExistException;

    String getDataAtual();
}
