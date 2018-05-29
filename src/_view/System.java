package _view;

import _controllers.ItemController;
import _factories.SystemFactory;
import _factories.SystemFactoryImpl;

public class System {
	
	private SystemFactory systemFactory;
	
	public void init() {
		this.systemFactory = new SystemFactoryImpl();
	}
	
	public ItemController getItemController() {
		return this.systemFactory.getItemController();
	}

}
