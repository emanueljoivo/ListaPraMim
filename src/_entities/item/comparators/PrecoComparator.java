package _entities.item.comparators;

import _entities.item.Item;

import java.util.Comparator;

public class PrecoComparator implements Comparator<Item> {

    @Override
    public int compare(Item i1, Item i2) {
        return i1.getMenorPreco().compareToIgnoreCase(i2.getMenorPreco());
    }
}
