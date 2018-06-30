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
        sort(itens);

        Item itemAtual = itemNotNull(itens, posicao);
        return itemAtual.toString();
    }

    @Override
    public String getItemPorCategoria(String categoria, int posicao) throws ItemNotExistException {
        List<Item> itens = this.itemRepository.getItensByCategoria(categoria);
        sort(itens);

        Item itemAtual = itemNotNull(itens, posicao);
        return itemAtual.toString();
    }

    @Override
    public String getItemPorMenorPreco(int posicao) throws ItemNotExistException {
        List<Item> itens = this.itemRepository.getItensByPreco();
        PrecoComparator comparator = new PrecoComparator();
        sort(itens, comparator);

        Item itemAtual = itemNotNull(itens, posicao);

        return itemAtual.toString();
    }

    @Override
    public String getItemPorPesquisa(String strPesquisada, int posicao) throws ItemNotExistException {
        List<Item> itens = this.itemRepository.getItensBySearch(strPesquisada);
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

        ComprasComparator c1 = new ComprasComparator();
        NomeComparator c2 = new NomeComparator();

        Collections.sort(compras, c1.thenComparing(c2));

        return compras.get(posicaoItem).toString();
    }

    @Override
    public String getItemListaPorData(Date data, int posicaoLista) {
        List<ListaDeCompra> allLists = this.listaDeComprasRepository.getAllLists();
        List<ListaDeCompra> auxList = new ArrayList<>();

        Comparator<ListaDeCompra> currentComparator = new ListaDescritorComparator();

        for (ListaDeCompra l : allLists) {
            if (l.getMomentoDeCriacao().equals(data)) {
                auxList.add(l);
            }
        }
        Collections.sort(auxList, currentComparator);

        return auxList.get(posicaoLista).toString();
    }

    @Override
    public String getItemListaPorItem(int id, int posicaoLista)
            throws ItemNotExistException, ListaDeComprasNotExistException {

        verificaItem(id, ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_ITEM_NOT_EXIST.getErrorMessage());
        Item itemAtual = this.itemRepository.recovery(id);
        List<ListaDeCompra> allListsContentItem = this.listaDeComprasRepository.getListsByItem(itemAtual);


        Collections.sort(allListsContentItem);
        ListaDeCompra listaAtual = getCurrentList(allListsContentItem, posicaoLista);

        return listaAtual.getDescritor();
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
