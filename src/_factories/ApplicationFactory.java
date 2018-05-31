package _factories;

import _controllers.ItemController;

/**
 * Interface responsável pelo encapsulamento da criação de entidades do sistema.
 * 
 * @author Emanuel Joivo
 */
public interface ApplicationFactory {
	
	/**
	 * Pega a instância do Controller de items. 
	 * @return ItemController
	 */
	ItemController getItemController();

}
