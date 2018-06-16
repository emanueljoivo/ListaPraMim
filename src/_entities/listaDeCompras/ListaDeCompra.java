package _entities.listaDeCompras;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ListaDeCompra implements Comparable<ListaDeCompra> {

    private String descritor, localDeCompra;
    private Set<Compra> compras;
    private Date momentoDeCriacao;
    private double valorFinal;

    public ListaDeCompra(String descritor) {
        this.descritor = descritor;
        this.compras = new HashSet<>();
        this.momentoDeCriacao = new Date();
    }

    public Compra getCompra(int itemId) {
        Compra c = null;
        for (Compra compra : this.compras) {
            if (compra.getItemCompravel().getId() == itemId) {
                c = compra;
            }
        }
        return c;
    }

    public Date getMomentoDeCriacao() {
        return momentoDeCriacao;
    }

    public String getDescritor() {
        return descritor;
    }

    public Set<Compra> getCompras() {
        return compras;
    }
    
    public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	} // Método para facilitar a criação automática de listas de compra.

    public void setDescritor(String descritor) {
        this.descritor = descritor;
    }

    public String getLocalDeCompra() {
        return localDeCompra;
    }

    public void setLocalDeCompra(String localDeCompra) {
        this.localDeCompra = localDeCompra;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
        return formatPattern.format(momentoDeCriacao) + " - " + this.descritor;
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

    @Override
    public int compareTo(ListaDeCompra o) {
        return this.momentoDeCriacao.compareTo(o.momentoDeCriacao);
    }
}
