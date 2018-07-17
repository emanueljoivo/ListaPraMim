package _services;

import _entities.comparators.ComprasComparator;
import _entities.comparators.ListaDescritorComparator;
import _entities.comparators.NomeComparator;
import _entities.comparators.PrecoComparator;
import _entities.item.Item;
import _entities.listaDeCompras.Compra;
import _entities.listaDeCompras.ListaDeCompra;
import _repositories.ItemRepository;
import _repositories.ListaDeComprasRepository;
import enums.ItemExceptionsMessages;
import enums.ListaDeComprasExceptionMessages;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import util.Util;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Collections.sort;

public class AuxServiceImpl implements AuxService {
    private ItemRepository itemRepository;
    private ListaDeComprasRepository listaDeComprasRepository;

    public AuxServiceImpl(ItemRepository itemRepository, ListaDeComprasRepository listaDeComprasRepository) {
        this.itemRepository = itemRepository;
        this.listaDeComprasRepository = listaDeComprasRepository;
    }

    @Override
    public String getItem(int posicao) throws ItemNotExistException {
        List<Item> itens = this.itemRepository.getItens();
        if (posicao >= itens.size()) return "";

        sort(itens);

        Item itemAtual = itemNotNull(itens, posicao);
        return itemAtual.toString();
    }

    @Override
    public String getItemPorCategoria(String categoria, int posicao) throws ItemNotExistException {
        List<Item> itens = this.itemRepository.getItensByCategoria(categoria);
        if (posicao >= itens.size()) return "";
        sort(itens);

        Item itemAtual = itemNotNull(itens, posicao);
        return itemAtual.toString();
    }

    @Override
    public String getItemPorMenorPreco(int posicao) throws ItemNotExistException {
        List<Item> itens = this.itemRepository.getItensByPreco();
        if (posicao >= itens.size()) return "";
        PrecoComparator comparator = new PrecoComparator();
        itens.sort(comparator);

        Item itemAtual = itemNotNull(itens, posicao);

        return itemAtual.toString();
    }

    @Override
    public String getItemPorPesquisa(String strPesquisada, int posicao) throws ItemNotExistException {
        List<Item> itens = this.itemRepository.getItensBySearch(strPesquisada);
        if (posicao >= itens.size()) return "";
        sort(itens);

        Item itemAtual = itemNotNull(itens, posicao);

        return itemAtual.toString();
    }

    @Override
    public String getItemLista(String descritorLista, int posicaoItem) throws ListaDeComprasNotExistException {
        this.verificaDescritor(descritorLista,
                ListaDeComprasExceptionMessages.ERRO_PESQUISA.getErrorMessage());

        ListaDeCompra listaAtual = this.listaDeComprasRepository.recoveryLista(descritorLista);

        List<Compra> compras = setToList(listaAtual.getCompras());

        if (posicaoItem >= compras.size()) return "";

        ComprasComparator c1 = new ComprasComparator();
        NomeComparator c2 = new NomeComparator();

        compras.sort(c1.thenComparing(c2));

        return compras.get(posicaoItem).toString();
    }

    @Override
    public String getItemListaPorData(Date data, int posicaoLista) {
        List<ListaDeCompra> allLists = this.listaDeComprasRepository.getAllLists();
        List<ListaDeCompra> auxList = new ArrayList<>();

        if (posicaoLista >= allLists.size()) return "";

        Comparator<ListaDeCompra> currentComparator = new ListaDescritorComparator();
        SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = formatPattern.format(data);

        for (ListaDeCompra l : allLists) {
            String dataListaAtual = formatPattern.format(l.getMomentoDeCriacao());

            if (dataListaAtual.equals(dateString)) {
                auxList.add(l);
            }

        }
        auxList.sort(currentComparator);

        return auxList.get(posicaoLista).getDescritor();
    }

    @Override
    public String getItemListaPorItem(int id, int posicaoLista)
            throws ItemNotExistException, ListaDeComprasNotExistException {

        verificaItem(id, ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_ITEM_NOT_EXIST.getErrorMessage());
        Item itemAtual = this.itemRepository.recovery(id);

        List<ListaDeCompra> allListsContentItem = this.listaDeComprasRepository.getListsByItem(itemAtual);

        if (posicaoLista >= allListsContentItem.size()) return "";


        Collections.sort(allListsContentItem, new ListaDescritorComparator());
        ListaDeCompra listaAtual = getCurrentList(allListsContentItem, posicaoLista);

        return listaAtual.toString();
    }

    @Override
    public String getDataAtual() {
        Date data = new Date();

        return Util.dateToString(data);
    }


    private Item itemNotNull(List<Item> itens, int posicao) throws ItemNotExistException {
        try {
            return itens.get(posicao);
        } catch (IndexOutOfBoundsException e) {
            throw new ItemNotExistException(
                    ItemExceptionsMessages.PESQUISA_INVALIDA_ITEM_NOT_EXIST.getErrorMessage());
        }
    }

    private void verificaDescritor(String descritorLista, String errorMessage) throws ListaDeComprasNotExistException {
        if (this.listaDeComprasRepository.notContainList(descritorLista)) {
            throw new ListaDeComprasNotExistException(errorMessage);
        }
    }

    private void verificaItem(int itemId, String errorMessage) throws ItemNotExistException {
        if (!this.itemRepository.contains(itemId)) {
            throw new ItemNotExistException(errorMessage);
        }
    }

    private ListaDeCompra getCurrentList(List<ListaDeCompra> allLists, int posicaoLista)
            throws ListaDeComprasNotExistException{
        try {
            return allLists.get(posicaoLista);
        } catch (IndexOutOfBoundsException e) {
            throw new ListaDeComprasNotExistException(
                    ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_LISTA_NOT_EXIST.getErrorMessage());
        }
    }

    private List<Compra> setToList(Set<Compra> compras) {
        List<Compra> listaAux = new ArrayList<>();
        listaAux.addAll(compras);
        return listaAux;
    }
}
