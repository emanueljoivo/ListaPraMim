package _entities.sugestorMelhorEstabelecimento;

import java.util.Map;

import _entities.listaDeCompras.ListaDeCompra;

public interface SugestorDeEstabelecimentos {
	
	/**
	 * Método que pesquisa em uma lista de compras, os estabelecimentos cadastrados com os melhores preços.
	 * @param lista lista de compras a ser pesquisada.
	 * @return um mapa com nome de um estabelecimento como chave e o preço total das compras no mesmo
	 */
	Map<String, Double> melhoresEstabelecimentos(ListaDeCompra lista);

}
