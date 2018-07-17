package main;

import _view.Facade;
import easyaccept.EasyAcceptFacade;
import itemExceptions.ItemExistException;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import util.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		Facade facade = new Facade(app);
		
		String[] cases = new String[] {"use_cases/use_case1.txt",
				"use_cases/use_case1_exception.txt",
				"use_cases/use_case2.txt",
				"use_cases/use_case2_exception.txt",
				"use_cases/use_case3.txt",
				"use_cases/use_case3_exception.txt",
				"use_cases/use_case4.txt",
				"use_cases/use_case4_exception.txt",
				"use_cases/use_case5.txt"};
				
		List<String> list = new ArrayList<>();
		
		for(String use_case: cases) list.add(use_case);

		EasyAcceptFacade testefachada = new EasyAcceptFacade(facade , list);
		testefachada.executeTests();
		System.out.println(testefachada.getCompleteResults());
	}


}