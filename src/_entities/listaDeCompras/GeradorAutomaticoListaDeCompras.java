package _entities.listaDeCompras;

import java.util.List;

import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

/**
 * Interface para o gerador automatico de lista de compras.
 * 
 * @author lucas
 */

public interface GeradorAutomaticoListaDeCompras {
	
	/**
	 * Método que vai gerar uma nova lista de compras automatica.
	 * 
	 * @param compras lista com todas as listas de compras cadastradas no sistema.
	 * @return uma nova lista de compras gerada automaticamente.
	 * @throws ListaDeComprasNotExistException exceçao lançada quando nao existirem listas de compras cadastradas.
	 * @throws CompraNotExistException exceçao lançada quando nao existirem compras que contemplem a estrategia escolhida.
	 */
	public ListaDeCompra gerar(List<ListaDeCompra> compras) 
			throws ListaDeComprasNotExistException, CompraNotExistException;
}
