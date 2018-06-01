package main;

import _view.Facade;
import item_exceptions.ItemExistException;
import item_exceptions.ItemNotExistException;

public class Main {

	public static void main(String[] args) throws NullPointerException, IllegalArgumentException, ItemExistException, ItemNotExistException {
		Application app = new Application();
		Facade facade = new Facade(app);
		facade.start();
	}	
}