package view;

import controller.ItemController;
import factory.SystemFactory;
import factory.SystemFactoryImpl;

public class System {
	
	private SystemFactory systemFactory;
	
	public void init() {
		this.systemFactory = new SystemFactoryImpl();
	}
	
	public ItemController getItemController() {
		return this.systemFactory.getItemController();
	}

}
