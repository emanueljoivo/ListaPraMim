package util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
	public static String formatDouble(double d) {
		return String.valueOf(d).replace(".", ",");
	}

	public static void print(String msg) {
		System.out.println(msg);
	}

	public static String dateToString(Date data) {
		SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
		return formatPattern.format(data);
	}
}