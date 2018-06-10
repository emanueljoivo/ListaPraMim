package _entities.listaDeCompras;

import _entities.item.Item;

import java.util.Objects;

public class Compra {

    private double quantidade;
    private Item item;

    public Compra(double quantidade, Item itemId) {
        this.quantidade = quantidade;
        this.item = itemId;
    }

    @Override
    public String toString() {
        return quantidade + " " + item.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return quantidade == compra.quantidade &&
                Objects.equals(item, compra.item);
    }

    @Override
    public int hashCode() {return Objects.hash(quantidade, item);}

    public double getQuantidade() { return quantidade; }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Item getItemCompravel() {
        return item;
    }
}
