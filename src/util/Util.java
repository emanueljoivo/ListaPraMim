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
	 * @param categoria string que descreve a categoria do item.
	 * @return um ItemCategoria que será passado na criação do item ou null caso não haja match da string
	 * com as categorias.
	 */
	public static ItemCategorias generateCategoria(String categoria) {
		ItemCategorias[] values = ItemCategorias.values();
		
		int i = 0;
		while (!(values[i].getValue().equals(categoria.toLowerCase().trim())) && (i < (values.length - 1))) i++;
		
		return values[i];
	}
	
	/**
	 * Tranforma um mapa numa representação em string customizada.
	 * @param mapa a ter representação do toString() customizada.
	 * @return representação em string customizada.
	 */
	public static String mapToString(Map<String, Double> mapa) {
		String mapStringifier = "<";
		
		Set<String> keys = mapa.keySet();
		
		for (String key: keys) {
			mapStringifier += (key + ", R$ " + mapa.get(key).toString() + ";");
		}
		return mapStringifier + ">";
	}
}