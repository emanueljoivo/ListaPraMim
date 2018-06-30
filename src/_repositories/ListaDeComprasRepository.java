package _repositories;

import _entities.item.Item;
import _entities.listaDeCompras.ListaDeCompra;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

import java.util.List;

public interface ListaDeComprasRepository {

    void save(ListaDeCompra l);

    boolean notContainList(String descritorLista);

    ListaDeCompra recoveryLista(String descritorLista);

    List<ListaDeCompra> getAllLists();

    List<ListaDeCompra> getListsByItem(Item item);
    
    void geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    void geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    void geraAutomaticaItem(String descritorItem) throws ListaDeComprasNotExistException, CompraNotExistException;
}
