package _repositories;

import _entities.listaDeCompras.ListaDeCompra;

public interface ListaDeComprasRepository {

    boolean save(ListaDeCompra l);

    boolean containsLista(String descritorLista);

    ListaDeCompra recoveryLista(String descritorLista);
}
