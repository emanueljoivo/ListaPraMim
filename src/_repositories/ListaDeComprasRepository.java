package _repositories;

import _entities.item.Item;
import _entities.listaDeCompras.ListaDeCompra;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

import java.io.Serializable;
import java.util.List;

public interface ListaDeComprasRepository extends Serializable {

    void save(ListaDeCompra l);

    boolean notContainList(String descritorLista);

    ListaDeCompra recoveryLista(String descritorLista);

    List<ListaDeCompra> getAllLists();

    List<ListaDeCompra> getListsByItem(Item item);
    
    String geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    String geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    String geraAutomaticaItem(String descritorItem) throws ListaDeComprasNotExistException, CompraNotExistException;
}
