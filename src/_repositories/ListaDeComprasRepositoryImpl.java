package _repositories;

import _entities.listaDeCompras.ListaDeCompra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaDeComprasRepositoryImpl implements ListaDeComprasRepository {

    private Set<ListaDeCompra> listasDeCompras;

    public ListaDeComprasRepositoryImpl() {
        this.listasDeCompras = new HashSet<>();
    }

    public boolean save(ListaDeCompra l) {
        return this.listasDeCompras.add(l);
    }

    @Override
    public boolean containsLista(String descritorLista) {
        return containsListaPorDescritor(descritorLista);
    }

    @Override
    public ListaDeCompra recoveryLista(String descritorLista) {
        return recoveryListaPorDescritor(descritorLista);
    }

    @Override
    public List<ListaDeCompra> getAllLists() {
        List<ListaDeCompra> listResult = new ArrayList<>();
        listResult.addAll(listasDeCompras);
        return listResult;
    }

    private ListaDeCompra recoveryListaPorDescritor(String descritorLista) {
        ListaDeCompra listaAtual = null;
        for (ListaDeCompra l: this.listasDeCompras) {
            if (l.getDescritor().equalsIgnoreCase(descritorLista)) {
                listaAtual = l;
            }
        }
        return listaAtual;
    }

    private boolean containsListaPorDescritor(String descritorLista) {
        for (ListaDeCompra l : this.listasDeCompras) {
            if (l.getDescritor().equalsIgnoreCase(descritorLista))
                return true;
        }
        return false;
    }
}
