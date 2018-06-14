package main;

import _view.Facade;
import easyaccept.EasyAcceptFacade;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import util.Util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

	public static void main(String[] args) throws NullPointerException, IllegalArgumentException, ItemExistException, ItemNotExistException {
		Application app = new Application();
		Facade facade = new Facade(app);

		List<String> list = new ArrayList<String>();
		list.add("user_cases/usecase_1.txt");
		EasyAcceptFacade testefachada = new EasyAcceptFacade(facade , list);
		testefachada.executeTests();
		System.out.println(testefachada.getCompleteResults());
	}
}