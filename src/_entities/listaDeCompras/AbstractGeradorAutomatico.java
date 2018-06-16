package _entities.listaDeCompras;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public abstract class AbstractGeradorAutomatico implements GeradorAutomaticoListaDeCompras{
	protected Date data;
	protected SimpleDateFormat formatPattern;
	
	public AbstractGeradorAutomatico() {
		this.data = new Date();
		this.formatPattern = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	protected ListaDeCompra criaListaDeCompra(Set<Compra> compras, String descritor) {
		ListaDeCompra novaListaAutomatica = new ListaDeCompra(descritor + formatPattern.format(this.data));
		novaListaAutomatica.setCompras(compras);
		
		return novaListaAutomatica;
	}
}
