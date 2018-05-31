package util;

import java.util.Map;
import java.util.Set;

import enums.ItemCategorias;

/**
 * Classe com algoritmos estáticos.
 * @author joivo
 *
 */
public class Util {
	
	/**
	 * Método que gera um ItemCategoria para ser utilizado para a criação do objeto referente a esse item.
	 * 
	 * @param categoria string com a categoria do item.
	 * @return um ItemCategoria que será passado na criação do item.
	 */
	public static ItemCategorias generateCategoria(String categoria) {
		ItemCategorias[] values = ItemCategorias.values();
		
		int i = 0;
		while (!(values[i].getValue().equals(categoria.toLowerCase().trim())) && (i < (values.length - 1))) i++;
		
		return values[i];
	}
	
	/**
	 * Tranforma um mapa numa representação em string customizada.
	 * @param mapa
	 * @return
	 */
	public static String mapToString(Map<String, Double> mapa) {
		String result = "<";
		
		Set<String> keys = mapa.keySet();
		
		for (String key: keys) {
			result += (key + ", R$ " + mapa.get(key).toString() + ";"); 
		}	
		
		return result += ">";
	}
}