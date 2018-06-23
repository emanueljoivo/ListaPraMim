package _entities.geradorAutomaticoListaDeCompras;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import _entities.listaDeCompras.Compra;
import _entities.listaDeCompras.ListaDeCompra;

/**
 * Classe abstrata para o gerador de lista automática, visando reaproveitamento de código.
 * 
 * @author lucas
 */

public abstract class AbstractGeradorAutomatico implements GeradorAutomaticoListaDeCompras{
	/**
	 * Atributo que representa o momento da geração automática.
	 */
	protected Date data;
	
	public AbstractGeradorAutomatico() {
		this.data = new Date();
	}
	
	/**
	 * Método para criar de fato a nova lista de compras gerada automaticamente.
	 * 
	 * @param compras conjunto de compras que podem ser inseridas na lista.
	 * @param descritor descritor da lista automatica, definido de acordo com a estratégia escolhida.
	 * @return nova lista de compras criada automaticamente.
	 */
	protected ListaDeCompra criaListaDeCompra(Set<Compra> compras, String descritor) {
		SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
		
		ListaDeCompra novaListaAutomatica = new ListaDeCompra(descritor + formatPattern.format(this.data));
		novaListaAutomatica.setCompras(compras);
		
		return novaListaAutomatica;
	}
}
