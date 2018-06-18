package _entities.listaDeCompras;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import enums.ListaDeComprasExceptionMessages;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

/**
 * 
 * @author lucas
 */

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
		Map<Compra, Integer> countMap = new HashMap<>();
		
		for (ListaDeCompra lista: compras) {
			for (Compra compra: lista.getCompras()) {
				Integer count = countMap.get(compra);
				
				if (count == null)
					count = 0;
				
				countMap.put(compra, count + 1);
			}
		}
		
		Set<Compra> out = new HashSet<>();
		
		for (Compra compra: countMap.keySet()) {
			if (countMap.get(compra) >= (compras.size() / 2))
				out.add(compra);
		}
		
		return out;
	}

}
