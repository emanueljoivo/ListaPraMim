package factory;

import controller.ItemController;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;
import services.ItemService;
import services.ItemServiceImpl;

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