package main;

import _controllers.ItemController;
import _factories.SystemFactory;
import _factories.SystemFactoryImpl;

/**
 * Classe responsável por representar o Sistema como um todo. 
 * A comunicação entre Facade e o restante da aplicação é 
 * efetuada através deste objeto.
 * 
 * @author Emanuel Joivo.
 *
 */
public class System {
	
	/**
	 * Fábrica das entidades do sistema.
	 */
	private SystemFactory systemFactory;
	
	/**
	 * Cria a instância do sistema.
	 */
	public void init() {
		this.systemFactory = new SystemFactoryImpl();
	}
	
	/**
	 * Pega o controlador de itens.
	 * @return a instância de ItemController.
	 */
	public ItemController getItemController() {
		return this.systemFactory.getItemController();
	}
}