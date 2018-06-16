package _entities.listaDeCompras;

import java.util.List;

import enums.ListaDeComprasExceptionMessages;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

public class GeradorAutomaticoPorItem implements GeradorAutomaticoListaDeCompras{
	private String nomeItem;
	
	public GeradorAutomaticoPorItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	@Override
	public ListaDeCompra gerar(List<ListaDeCompra> compras) throws ListaDeComprasNotExistException {
		if (compras.isEmpty())
			throw new ListaDeComprasNotExistException
				(ListaDeComprasExceptionMessages.NAO_HA_LISTAS_POR_ITEM.getErrorMessage());
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	private ListaDeCompra getListaDeCompra(List<ListaDeCompra> compras) {
		ListaDeCompra out = null;
		for (int i = compras.size() - 1; i >= 0; i--) {
			
		}
		return out;
	}

}
