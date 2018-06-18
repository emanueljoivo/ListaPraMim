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
 * Classe que é responsável por gerar uma lista de compras automática, seguindo a estratégia de
 * procurar pelos itens que mais aparecem nas listas de compras cadastradas.
 * 
 * @author lucas
 */

public class GeradorAutomaticoPorItensMaisPresentes extends AbstractGeradorAutomatico {
	
	public GeradorAutomaticoPorItensMaisPresentes() {
		super();
	}

	/**
	 * {@link _entities.listaDeCompras.GeradorAutomaticoListaDeCompras#gerar(List)}
	 */
	@Override
	public ListaDeCompra gerar(List<ListaDeCompra> compras)
			throws ListaDeComprasNotExistException, CompraNotExistException {
		if (compras.isEmpty())
			throw new ListaDeComprasNotExistException
				(ListaDeComprasExceptionMessages.NAO_HA_LISTAS_ITENS_MAIS_RECENTES.getErrorMessage());
		
		return super.criaListaDeCompra(getCompras(compras), "Lista automatica 3 ");
	}

	/**
	 * Metodo para pegar as compras validas para a nova lista que será gerada automaticamente.
	 * 
	 * @param compras lista com todas as listas de compras cadastradas no sistema. 
	 * @return conjunto de compras que podem ser inseridas na nova lista automatica.
	 * @throws CompraNotExistException exceçao lançada quando nao existirem compras que contemplem a estrategia escolhida.
	 */
	private Set<Compra> getCompras(List<ListaDeCompra> compras) throws CompraNotExistException {
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
		int size = compras.size();
		
		for (Compra compra: countMap.keySet()) {
			if (countMap.get(compra) >= (size / 2.0))
				out.add(compra);
		}
		
		if (out.isEmpty())
			throw new CompraNotExistException(ListaDeComprasExceptionMessages.NAO_HA_ITENS_CADASTRADOS_MAIS_PRESENTES.getErrorMessage());
		
		return out;
	}

}
