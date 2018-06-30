package main;

import _controllers.AuxController;
import _controllers.ItemController;
import _controllers.ListaDeComprasController;
import _factories.ApplicationFactory;
import _factories.ApplicationFactoryImpl;

/**
 * Classe responsável por representar o Sistema como um todo. 
 * A comunicação entre Facade e o restante da aplicação é 
 * efetuada através deste objeto.
 * 
 * @author Emanuel Joivo.
 *
 */
public class Application {
	
	/**
	 * Fábrica das entidades estruturais do sistema.
	 */
	private ApplicationFactory appFactory;
	
	/**
	 * Cria a instância do sistema.
	 */
	public void init() {
		this.appFactory = new ApplicationFactoryImpl();
	}
	
	/**
	 * Pega o controlador de itens.
	 * @return a instância de ItemController.
	 */
	public ItemController getItemController() {
		return this.appFactory.getItemController();
	}

	/**
	 * Pega o controlador de lista de compras.
	 * @return a instância de ListaDeComprasController.
	 */
	public ListaDeComprasController getListaDeComprasController() {return this.appFactory.getListaDeComprasController(); }

	public AuxController getAuxController() {return this.appFactory.getAuxController();}
}