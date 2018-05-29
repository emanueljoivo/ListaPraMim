package _factory;

import _controller.ItemController;
import _repository.ItemRepository;
import _repository.ItemRepositoryImpl;
import _service.ItemService;
import _service.ItemServiceImpl;

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