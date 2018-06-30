package _entities.sugestorMelhorEstabelecimento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import _entities.item.Item;
import _entities.listaDeCompras.Compra;
import _entities.listaDeCompras.ListaDeCompra;

public class SugestorDeEstabelecimentosImpl implements SugestorDeEstabelecimentos {

	@Override
	public Map<String, Double> melhoresEstabelecimentos(ListaDeCompra lista) {
		List<Item> itens = new ArrayList<>();
		
		for (Compra c: lista.getCompras()) {
			itens.add(c.getItemCompravel());
		}
		
		Map<String, Integer> countMap = countEstabelecimentos(itens);
		Map<String, Double> out = new HashMap<>();
		
		// TODO Auto-generated method stub
		return null;
	}
	
	private Map<String, Integer> countEstabelecimentos(List<Item> itens) {
    	Map<String, Integer> countMap = new HashMap<>();
    	
    	for (Item item: itens) {
    		for(String s: item.getMapaDePrecos().keySet()) {
    			Integer count = countMap.get(s);
    			if (count == null)
    				count = new Integer(0);
    			countMap.put(s, count);
    		}
    	}
    	
    	return countMap;
    }

}
