package _entities.comparators;

import _entities.item.Item;

import java.io.Serializable;
import java.util.Comparator;

public class CategoriaComparator implements Comparator<Item>, Serializable {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getCategoria().compareTo(o2.getCategoria());
    }
}
