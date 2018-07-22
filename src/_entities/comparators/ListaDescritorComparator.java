package _entities.comparators;

import _entities.listaDeCompras.ListaDeCompra;

import java.io.Serializable;
import java.util.Comparator;

public class ListaDescritorComparator implements Comparator<ListaDeCompra>, Serializable {

    @Override
    public int compare(ListaDeCompra o1, ListaDeCompra o2) {
        return o1.getDescritor().compareToIgnoreCase(o2.getDescritor());
    }
}
