package view;

import factory.SystemFactory;
import factory.SystemFactoryImpl;

public class Facade {
	private SystemFactory systemFactory;
	
	public Facade() {
		this.systemFactory = new SystemFactoryImpl();
	}
	
	public void criaItemCompravel(String nome, String categoria) {
		this.systemFactory.getItemController().criaItemCompravel(nome, categoria);;
	}	
}