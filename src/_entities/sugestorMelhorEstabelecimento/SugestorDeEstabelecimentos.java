package _entities.sugestorMelhorEstabelecimento;

import java.util.Map;

import _entities.listaDeCompras.ListaDeCompra;

public interface SugestorDeEstabelecimentos {
	
	Map<String, Double> melhoresEstabelecimentos(ListaDeCompra lista);

}
