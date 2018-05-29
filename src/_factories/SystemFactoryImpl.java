package _factories;

import _controllers.ItemController;
import _repositories.ItemRepository;
import _repositories.ItemRepositoryImpl;
import _services.ItemService;
import _services.ItemServiceImpl;

/**
 * Classe responsável pelo implementação da criação de entidades do sistema,
 * permitindo assim o mecanismo de injeção de dependências. 
 */
public class SystemFactoryImpl implements SystemFactory {
	
	/**
	 * Fábrica de itens. Responsável pela criação de itens.
	 */
	private ItemFactory itemFactory;
	
	/**
	 * Objeto responsável por controlar requisições de usuário a respeito de itens.
	 */
	private ItemController itemController;
	
	/**
	 * Interface que provê aos controladores serviços relacionados a lógica de negócio.
	 */
	private ItemService itemService;
	
	/**
	 * Interface responsável pela comunicação com banco de dados (Persistência).
	 */
	private ItemRepository itemRepository;
	
	/**
	 * Contrutor responsável pela injeção de dependências adequada.
	 */
	public SystemFactoryImpl() {
		this.itemFactory = new ItemFactoryImpl();
		this.itemRepository = new ItemRepositoryImpl();
		this.itemService = new ItemServiceImpl(itemFactory, itemRepository);
		this.itemController = new ItemController(itemService);
	}	
	
	/**
	 * Pega a instância do Controller de items. 
	 * @return ItemController
	 */
	public ItemController getItemController() {
		return itemController;
	}
}