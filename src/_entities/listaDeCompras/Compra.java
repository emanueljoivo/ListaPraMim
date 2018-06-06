package _entities.listaDeCompras;

import _entities.item.Item;

import java.util.Objects;

public class Compra {

    private double quantidade;
    private int itemId;

    public Compra(double quantidade, int itemId) {
        this.quantidade = quantidade;
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "quantidade=" + quantidade +
                ", itemCompravel=" + itemId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return quantidade == compra.quantidade &&
                Objects.equals(itemId, compra.itemId);
    }

    @Override
    public int hashCode() {return Objects.hash(quantidade, itemId);}

    public double getQuantidade() { return quantidade; }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getItemCompravel() {
        return itemId;
    }
}
