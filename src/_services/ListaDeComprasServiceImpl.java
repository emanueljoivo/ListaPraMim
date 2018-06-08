package _services;

import _entities.item.Item;
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

    private void verificaIntegridade(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException {
        if (!this.listaRepository.containsLista(descritorLista)) {
            throw new ListaDeComprasNotExistException(ListaDeComprasExceptionMessages.
                    LISTA_NAO_ENCONTRADA.getErrorMessage());
        }

        if (!this.itemRepository.contains(itemId)) {
            throw new ItemNotExistException(ItemExceptionsMessages.
                    NAO_CONTEM_ITEM.getErrorMessage());
        }
    }

    private void verificaCompra(Compra compra) throws CompraNotExistException {
        if (compra == null) {
            throw new CompraNotExistException(ListaDeComprasExceptionMessages.
                    COMPRA_NAO_ENCONTRADA.getErrorMessage());
        }
    }
}
