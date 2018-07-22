package _entities.sugestorMelhorEstabelecimento;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import _entities.listaDeCompras.Compra;
import _entities.listaDeCompras.ListaDeCompra;

public class SugestorDeEstabelecimentosImpl implements SugestorDeEstabelecimentos, Serializable {

	@Override
	public Map<String, Double> melhoresEstabelecimentos(ListaDeCompra lista) {
		Set<Compra> compras = lista.getCompras();
		Map<String, Integer> countMap = countEstabelecimentos(compras);
		Map<String, Double> out = new HashMap<>();
		
		int maior = Integer.MIN_VALUE;
		
		for (int i: countMap.values()) {
			if (i > maior) {
				maior = i;
			}
		}
		
		for (Map.Entry<String, Integer> entry: countMap.entrySet()) {
			if (entry.getValue().equals(maior)) {
				for (Compra c: lista.getCompras()) {
					Double precoAcumulado = out.get(entry.getKey());
					
					if (precoAcumulado == null) {
						precoAcumulado = new Double(0);
					}
					
					out.put(entry.getKey(), precoAcumulado + c.getItemCompravel().getMapaDePrecos().get(entry.getKey()));
				}
			}
		}
		
		return out;
	}
	
	private Map<String, Integer> countEstabelecimentos(Set<Compra> compras) {
    	Map<String, Integer> countMap = new HashMap<>();
    	
    	for (Compra c: compras) {
    		for(String s: c.getItemCompravel().getMapaDePrecos().keySet()) {
    			Integer count = countMap.get(s);
    			
    			if (count == null) {
    				count = new Integer(0);
    			}
    			
    			countMap.put(s, count);
    		}
    	}
    	return countMap;
    }
}
