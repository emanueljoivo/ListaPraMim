package _factories;

import _controllers.AuxController;
import _controllers.ItemController;
import _controllers.ListaDeComprasController;

import java.io.Serializable;

/**
 * Interface responsável pelo encapsulamento da criação de entidades do sistema.
 * 
 * @author Emanuel Joivo
 */
public interface ApplicationFactory extends Serializable {
	
	/**
	 * Pega a instância do Controller de items. 
	 * @return ItemController
	 */
	ItemController getItemController();

	/**
	 * Pega a instância do Controller de lista de compras.
	 * @return ListaDeComprasController
	 */
	ListaDeComprasController getListaDeComprasController();

	AuxController getAuxController();

}
