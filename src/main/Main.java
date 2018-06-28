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

		final String us = "use_cases/use_case";
		final String extension = ".txt";
		final String excep = "_exception";
		final int usQntd = 4;

		List<String> list = new ArrayList<>();

		for (int i = 0; i < usQntd; i ++) list.add(us + (i+1) + extension);
		for (int i = 0; i < 1; i++) list.add(us + (i+usQntd) + excep + extension);

		EasyAcceptFacade testefachada = new EasyAcceptFacade(facade , list);
		testefachada.executeTests();
		System.out.println(testefachada.getCompleteResults());
	}


}