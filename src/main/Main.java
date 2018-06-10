package main;

import _view.Facade;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import util.Util;

import java.text.DecimalFormat;
import java.util.Locale;

public class Main {

	public static void main(String[] args) throws NullPointerException, IllegalArgumentException, ItemExistException, ItemNotExistException {
		Application app = new Application();
		Facade facade = new Facade(app);
		facade.start();

		System.out.println(Util.formatDouble(1.2));
	}
}