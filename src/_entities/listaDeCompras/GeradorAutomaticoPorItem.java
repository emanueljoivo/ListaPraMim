package _entities.listaDeCompras;

import java.util.List;
import java.util.Set;

import enums.ListaDeComprasExceptionMessages;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

/**
 * Classe que é responsável por gerar uma lista de compras automática, seguindo a estratégia de
 * repetir a última que foi cadastrada no sistema que contem um item desejado.
 * 
 * @author lucas
 */

public class GeradorAutomaticoPorItem extends AbstractGeradorAutomatico{
	private String nomeItem;
	
	public GeradorAutomaticoPorItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	/**
	 * {@link _entities.listaDeCompras.GeradorAutomaticoListaDeCompras#gerar(List)}
	 */
	@Override
	public ListaDeCompra gerar(List<ListaDeCompra> compras) throws ListaDeComprasNotExistException, CompraNotExistException {
		if (compras.isEmpty())
			throw new ListaDeComprasNotExistException
				(ListaDeComprasExceptionMessages.NAO_HA_LISTAS_POR_ITEM.getErrorMessage());
		
		return super.criaListaDeCompra(this.getCompras(compras), "Lista automatica 2 ");
	}
	
	/**
	 * Metodo para pegar as compras validas para a nova lista que será gerada automaticamente.
	 * 
	 * @param compras lista com todas as listas de compras cadastradas no sistema. 
	 * @return conjunto de compras que podem ser inseridas na nova lista automatica.
	 * @throws CompraNotExistException exceçao lançada quando nao existirem compras que contemplem a estrategia escolhida.
	 */
	private Set<Compra> getCompras(List<ListaDeCompra> compras) throws CompraNotExistException {
		Set<Compra> out = null;
		
		if (!compras.isEmpty()) {
			int i = compras.size() - 1;
			
			while (out == null && i >= 0) {
				if (compras.get(i).procuraItemPorNome(this.nomeItem))
					out = compras.get(i).getCompras();
				i--;
			}
		}
		
		if (out == null)
			throw new CompraNotExistException(ListaDeComprasExceptionMessages.NAO_HA_COMPRA_POR_ITEM.getErrorMessage());
		
		return out;
	}

}
