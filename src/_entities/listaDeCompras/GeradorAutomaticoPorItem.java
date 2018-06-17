package _entities.listaDeCompras;

import java.util.List;
import java.util.Set;

import enums.ListaDeComprasExceptionMessages;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

public class GeradorAutomaticoPorItem extends AbstractGeradorAutomatico{
	private String nomeItem;
	
	public GeradorAutomaticoPorItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	@Override
	public ListaDeCompra gerar(List<ListaDeCompra> compras) throws ListaDeComprasNotExistException, CompraNotExistException {
		if (compras.isEmpty())
			throw new ListaDeComprasNotExistException
				(ListaDeComprasExceptionMessages.NAO_HA_LISTAS_POR_ITEM.getErrorMessage());
		
		return super.criaListaDeCompra(this.getCompras(compras), "Lista automatica 2");
	}
	
	private Set<Compra> getCompras(List<ListaDeCompra> compras) throws CompraNotExistException {
		Set<Compra> out = null;
		
		if (!compras.isEmpty()) {
			int i = compras.size();
			
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
