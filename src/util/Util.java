package util;

import java.text.DecimalFormat;
import java.util.*;

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
	 * Converte a formatação de um double para um formato com virgula ao inves de ponto.	 *
	 * @return Um decimal formatado.
	 */
	public static DecimalFormat formatDouble(double d) {
		return (DecimalFormat) DecimalFormat.getNumberInstance(Locale.GERMAN);
	}
}