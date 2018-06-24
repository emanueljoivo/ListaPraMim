package main;

import _view.Facade;
import easyaccept.EasyAcceptFacade;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NullPointerException, IllegalArgumentException, ItemExistException, ItemNotExistException, ListaDeComprasNotExistException, CompraNotExistException, CompraAlreadyExistException {
		Application app = new Application();
		Facade facade = new Facade(app);



		List<String> list = new ArrayList<String>();
		list.add("use_cases/use_case1.txt");
		list.add("use_cases/use_case2.txt");
		list.add("use_cases/use_case3.txt");
		list.add("use_cases/use_case3_exception.txt");
		EasyAcceptFacade testefachada = new EasyAcceptFacade(facade , list);
		testefachada.executeTests();
		System.out.println(testefachada.getCompleteResults());
	}


}