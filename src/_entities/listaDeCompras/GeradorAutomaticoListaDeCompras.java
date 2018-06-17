package _entities.listaDeCompras;

import java.util.List;

import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

/**
 * 
 * @author lucas
 */

public interface GeradorAutomaticoListaDeCompras {
	
	public ListaDeCompra gerar(List<ListaDeCompra> compras) 
			throws ListaDeComprasNotExistException, CompraNotExistException;
}
