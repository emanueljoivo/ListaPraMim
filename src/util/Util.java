package util;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import _view.Facade;
import enums.ItemCategorias;
import itemExceptions.ItemExistException;

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

	public static void mockOrdenacao(Facade facade) throws ItemExistException {
		ItemCategorias[] categorias = ItemCategorias.values();
		Random generator = new Random();
		generator.nextDouble();

		for (int i = 0; i < 10; i++) {
			String nome = "Item" + i;
			String nome2 = "Item" + (i+10);
			String categoria = categorias[generator.nextInt(4)].getValue();
			facade.adicionaItem(nome,categoria, generator.nextDouble());
			facade.adicionatem(nome2, categoria, generator.nextInt(10));
		}

		facade.listaItens();

		System.out.println("Ordenação por categoria" + "\n");

		facade.listaItens(categorias[generator.nextInt(4)].getValue());
	}
}