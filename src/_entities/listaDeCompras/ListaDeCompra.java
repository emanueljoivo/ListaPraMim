package _entities.listaDeCompras;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ListaDeCompra {

    private String descritor;
    private Set<Compra> compras;

    public ListaDeCompra(String descritor) {
        this.descritor = descritor;
        this.compras = new HashSet<>();
        /* todo: adicionar data */
    }

    public String getDescritor() {
        return descritor;
    }

    public Set<Compra> getCompras() {
        return compras;
    }

    public void setDescritor(String descritor) {
        this.descritor = descritor;
    }

    @Override
    public String toString() {
        return "ListaDeCompra{" +
                "descritor='" + descritor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaDeCompra that = (ListaDeCompra) o;
        return Objects.equals(descritor, that.descritor);
    }

    @Override
    public int hashCode() { return Objects.hash(descritor);}
}
