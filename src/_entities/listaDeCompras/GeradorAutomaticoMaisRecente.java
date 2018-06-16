package _entities.listaDeCompras;

import java.util.List;

import enums.ListaDeComprasExceptionMessages;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

/**
 * Classe que é responsável por gerar uma lista de compras automática,
 * repetindo a última que foi cadastrada no sistema.
 * 
 * @author lucas
 */

public class GeradorAutomaticoMaisRecente extends AbstractGeradorAutomatico {
	
	public GeradorAutomaticoMaisRecente() {
		super();
	}

	@Override
	public ListaDeCompra gerar(List<ListaDeCompra> compras) throws ListaDeComprasNotExistException {
		if (compras.isEmpty())
			throw new ListaDeComprasNotExistException
				(ListaDeComprasExceptionMessages.NAO_HA_LISTAS_MAIS_RECENTE.getErrorMessage());
		
		int pos = compras.size() - 1;
		
		return super.criaListaDeCompra(compras.get(pos).getCompras(), "Lista automatica 1");
	}

}
