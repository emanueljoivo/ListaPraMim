package _entities.comparators;

import _entities.item.Item;

import java.io.Serializable;
import java.util.Comparator;

public class PrecoComparator implements Comparator<Item>, Serializable {

    @Override
    public int compare(Item i1, Item i2) {
        return i1.getMenorPreco().compareTo(i2.getMenorPreco());
    }
}
