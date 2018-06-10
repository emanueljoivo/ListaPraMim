package _services;

import _entities.item.Item;
import _entities.item.comparators.CategoriaComparator;
import _entities.listaDeCompras.Compra;
import _entities.listaDeCompras.ListaDeCompra;
import _repositories.ItemRepository;
import _repositories.ListaDeComprasRepository;
import enums.ItemExceptionsMessages;
import enums.ListaDeComprasExceptionMessages;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import util.Util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static util.Util.*;

public class ListaDeComprasServiceImpl implements ListaDeComprasService {

    private ListaDeComprasRepository listaRepository;
    private ItemRepository itemRepository;

    public ListaDeComprasServiceImpl(ListaDeComprasRepository listRepository, ItemRepository itemRepository) {
        this.listaRepository = listRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void adicionaNovaLista(String descritor) {
        this.listaRepository.save(new ListaDeCompra(descritor));
    }

    @Override
    public void adicionaNovaCompra(String descritorLista, double quantidade, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

        verificaIntegridade(descritorLista, itemId);

        Item itemAtual = this.itemRepository.recovery(itemId);
        Compra compraAtual = new Compra(quantidade, itemAtual);
        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);

        if (listaAtual.getCompras().contains(compraAtual)) {
            throw new CompraAlreadyExistException(ListaDeComprasExceptionMessages.
                    COMPRA_JA_FEITA.getErrorMessage());
        }
        listaAtual.getCompras().add(compraAtual);
    }

    @Override
    public void atualizaCompraDeLista(String descritorLista, int itemId, int novaQuantidade)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {

        verificaIntegridade(descritorLista, itemId);
        Compra compraAtual = this.listaRepository.recoveryLista(descritorLista).
                getCompra(itemId);

        verificaCompra(compraAtual);

        if ((compraAtual.getQuantidade() - novaQuantidade) <= 0) {
            deletaCompraDeLista(descritorLista, itemId);
        } else {
            compraAtual.setQuantidade(novaQuantidade);
        }
    }

    public void deletaCompraDeLista(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {
        verificaIntegridade(descritorLista, itemId);

        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaAtual.getCompra(itemId);

        verificaCompra(compraAtual);
        listaAtual.getCompras().remove(compraAtual);
    }

    @Override
    public Compra pesquisaCompraDeLista(String descritorLista, int itemId) throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {
        verificaIntegridade(descritorLista, itemId);

        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaAtual.getCompra(itemId);

        verificaCompra(compraAtual);

        return compraAtual;
    }

    @Override
    public String imprimirListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {
        verificaDescritor(descritorLista);
        String listaStringify = "";
        List<Compra> compras = toList(this.listaRepository.
                recoveryLista(descritorLista).getCompras());
        CategoriaComparator comparator1 = new CategoriaComparator();

        /* TODO */

        for (Compra compra : compras) {
            listaStringify += compra.getItemCompravel().toString(compra.getQuantidade()) + "\n";
        }
        return listaStringify;
    }

    private void verificaIntegridade(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException {
        verificaDescritor(descritorLista);
        verificaItem(itemId);
    }

    private void verificaItem(int itemId) throws ItemNotExistException {
        if (!this.itemRepository.contains(itemId)) {
            throw new ItemNotExistException(ItemExceptionsMessages.
                    NAO_CONTEM_ITEM.getErrorMessage());
        }
    }

    private void verificaDescritor(String descritorLista) throws ListaDeComprasNotExistException {
        if (!this.listaRepository.containsLista(descritorLista)) {
            throw new ListaDeComprasNotExistException(ListaDeComprasExceptionMessages.
                    LISTA_NAO_ENCONTRADA.getErrorMessage());
        }
    }

    private void verificaCompra(Compra compra) throws CompraNotExistException {
        if (compra == null) {
            throw new CompraNotExistException(ListaDeComprasExceptionMessages.
                    COMPRA_NAO_ENCONTRADA.getErrorMessage());
        }
    }
}
