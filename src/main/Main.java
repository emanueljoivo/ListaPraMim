package main;

import _view.Facade;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;

public class Main {

	public static void main(String[] args) throws NullPointerException, IllegalArgumentException, ItemExistException, ItemNotExistException {
		Application app = new Application();
		Facade facade = new Facade(app);
		facade.start();
	}
}