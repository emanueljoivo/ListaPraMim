package _entities.listaDeCompras;

import java.util.List;
import java.util.Set;

import enums.ListaDeComprasExceptionMessages;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

public class GeradorAutomaticoItensMaisPresentes extends AbstractGeradorAutomatico {

	@Override
	public ListaDeCompra gerar(List<ListaDeCompra> compras)
			throws ListaDeComprasNotExistException, CompraNotExistException {
		if (compras.isEmpty())
			throw new ListaDeComprasNotExistException
				(ListaDeComprasExceptionMessages.NAO_HA_LISTAS_ITENS_MAIS_RECENTES.getErrorMessage());
		
		return super.criaListaDeCompra(getCompras(compras), "Lista automatica 3");
	}

	private Set<Compra> getCompras(List<ListaDeCompra> compras) {
		// TODO falta fazer.
		return null;
	}

}
