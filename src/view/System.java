package view;

import _controller.ItemController;
import _factory.SystemFactory;
import _factory.SystemFactoryImpl;

public class System {
	
	private SystemFactory systemFactory;
	
	public void init() {
		this.systemFactory = new SystemFactoryImpl();
	}
	
	public ItemController getItemController() {
		return this.systemFactory.getItemController();
	}

}
