package _repositories;

import _entities.listaDeCompras.ListaDeCompra;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

import java.util.List;

public interface ListaDeComprasRepository {

    boolean save(ListaDeCompra l);

    boolean containsLista(String descritorLista);

    ListaDeCompra recoveryLista(String descritorLista);

    List<ListaDeCompra> getAllLists();
    
    void geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    void geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    void geraAutomaticaItem(String descritorItem) throws ListaDeComprasNotExistException, CompraNotExistException;
}
