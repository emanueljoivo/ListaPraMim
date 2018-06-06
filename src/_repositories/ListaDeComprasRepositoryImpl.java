package _repositories;

import _entities.listaDeCompras.ListaDeCompra;

import java.util.HashSet;
import java.util.Set;

public class ListaDeComprasRepositoryImpl implements ListaDeComprasRepository {

    private Set<ListaDeCompra> listasDeCompras;

    public ListaDeComprasRepositoryImpl() {
        this.listasDeCompras = new HashSet<>();
    }

    @Override
    public boolean save(ListaDeCompra l) {
        return this.listasDeCompras.add(l);
    }

    @Override
    public boolean delete(int id) {
        /* todo */
        return true;
    }

    @Override
    public ListaDeCompra recovery(int id) {
        /* todo */
        return null;
    }

    @Override
    public boolean contains(int id) {
        /* todo */
        return false;
    }
}
