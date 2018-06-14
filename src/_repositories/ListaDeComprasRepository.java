package _repositories;

import _entities.listaDeCompras.ListaDeCompra;

import java.util.List;

public interface ListaDeComprasRepository {

    boolean save(ListaDeCompra l);

    boolean containsLista(String descritorLista);

    ListaDeCompra recoveryLista(String descritorLista);

    List<ListaDeCompra> getAllLists();
}
