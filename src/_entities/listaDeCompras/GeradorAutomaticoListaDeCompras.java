package _entities.listaDeCompras;

import java.util.List;

import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

/**
 * 
 * @author lucas
 */

public interface GeradorAutomaticoListaDeCompras {
	
	public ListaDeCompra gerar(List<ListaDeCompra> compras) 
			throws ListaDeComprasNotExistException, ItemNotExistException;
}
