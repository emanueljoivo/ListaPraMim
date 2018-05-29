package _factories;

import _controllers.ItemController;
import _repositories.ItemRepository;
import _repositories.ItemRepositoryImpl;
import _services.ItemService;
import _services.ItemServiceImpl;

public class SystemFactoryImpl implements SystemFactory {
	
	private ItemFactory itemFactory;
	private ItemService itemService;
	private ItemController itemController;
	private ItemRepository itemRepository;

	public SystemFactoryImpl() {
		this.itemFactory = new ItemFactoryImpl();
		this.itemRepository = new ItemRepositoryImpl();
		this.itemService = new ItemServiceImpl(itemFactory, itemRepository);
		this.itemController = new ItemController(itemService);
	}	
	
	/**
	 * @return the itemController
	 */
	public ItemController getItemController() {
		return itemController;
	}
}