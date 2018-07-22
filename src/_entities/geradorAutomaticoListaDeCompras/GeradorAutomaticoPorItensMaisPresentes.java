package _entities.geradorAutomaticoListaDeCompras;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import _entities.item.Item;
import _entities.listaDeCompras.Compra;
import _entities.listaDeCompras.ListaDeCompra;
import enums.ListaDeComprasExceptionMessages;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

/**
 * Classe que é responsável por gerar uma lista de compras automática, seguindo a estratégia de
 * procurar pelos itens que mais aparecem nas listas de compras cadastradas.
 * 
 * @author lucas
 */

public class GeradorAutomaticoPorItensMaisPresentes extends AbstractGeradorAutomatico implements Serializable {
	
	public GeradorAutomaticoPorItensMaisPresentes() {
		super();
	}

	/**
	 * {@link _entities.geradorAutomaticoListaDeCompras.GeradorAutomaticoListaDeCompras#gerar(List)}
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
		Map<Item, Integer> countMap = new HashMap<>();
		Map<Item, Double> sumQtdMap = new HashMap<>();
		
		for (ListaDeCompra lista: compras) {
			for (Compra compra: lista.getCompras()) {
				Integer count = countMap.get(compra.getItemCompravel());
				
				if (count == null)
					count = 0;
				
				double qtd = compra.getQuantidade();
				
				if (sumQtdMap.get(compra.getItemCompravel()) != null)
					qtd += sumQtdMap.get(compra.getItemCompravel());
				
				countMap.put(compra.getItemCompravel(), count + 1);
				sumQtdMap.put(compra.getItemCompravel(), qtd);
			}
		}
		
		Set<Compra> out = new HashSet<>();
		int size = compras.size();
		
		for (Item item: countMap.keySet()) {
			int count = countMap.get(item);
			
			if (count >= (size / 2.0)) {
				double qtd = Math.floor(sumQtdMap.get(item) / countMap.get(item));
				out.add(new Compra(qtd, item));
			}
		}
		
		if (out.isEmpty())
			throw new CompraNotExistException(ListaDeComprasExceptionMessages.NAO_HA_ITENS_CADASTRADOS_MAIS_PRESENTES.getErrorMessage());
		
		return out;
	}

}
