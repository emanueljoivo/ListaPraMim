package _factories;

import _controllers.AuxController;
import _controllers.ItemController;
import _controllers.ListaDeComprasController;
import _repositories.ItemRepository;
import _repositories.ItemRepositoryImpl;
import _repositories.ListaDeComprasRepository;
import _repositories.ListaDeComprasRepositoryImpl;
import _services.*;
import validation.ValidatorItem;
import validation.ValidatorItemImpl;
import validation.ValidatorListaDeCompras;
import validation.ValidatorListaDeComprasImpl;

/**
 * Classe responsável pelo implementação da criação de entidades do sistema,
 * permitindo assim o mecanismo de injeção de dependências. 
 */
public class ApplicationFactoryImpl implements ApplicationFactory {
	
	/**
	 * Fábrica de itens. Responsável pela criação de itens.
	 */
	private ItemFactory itemFactory;
	
	/**
	 * Objeto responsável por controlar requisições de usuário a respeito de itens.
	 */
	private ItemController itemController;

	/**
	 * Objeto responsavel por controlar requisicoes de usuario a respeito de listas de compras.
	 */
	private ListaDeComprasController listaDeComprasController;
	
	/**
	 * Interface que provê aos controladores serviços relacionados a lógica de negócio de itens.
	 */
	private ItemService itemService;

	/**
	 * Interface que provê aos controladores serviços relacionados a lógica de negócio de listas de compras.
	 */
	private ListaDeComprasService listaService;
	
	/**
	 * Interface responsável pela comunicação com banco de dados (Persistência).
	 */
	private ItemRepository itemRepository;

	private ListaDeComprasRepository listaDeComprasRepository;
	
	/**
	 * Interface que define validações de item.
	 */
	private ValidatorItem validatorItem;

	/**
	 * Interface que define validações de listas de compras.
	 */
	private ValidatorListaDeCompras validatorLista;

	private AuxController auxController;

	private AuxService auxService;
	/**
	 * Contrutor responsável pela injeção de dependências adequada.
	 */
	public ApplicationFactoryImpl() {
		this.itemFactory = new ItemFactoryImpl();
		this.itemRepository = new ItemRepositoryImpl();
		this.validatorItem = new ValidatorItemImpl();
		this.itemService = new ItemServiceImpl(itemFactory, itemRepository);
		this.itemController = new ItemController(itemService, validatorItem);
		this.validatorLista = new ValidatorListaDeComprasImpl();
		this.listaDeComprasRepository = new ListaDeComprasRepositoryImpl();
		this.listaService = new ListaDeComprasServiceImpl(listaDeComprasRepository, itemRepository);
		this.listaDeComprasController = new ListaDeComprasController(validatorLista, listaService);
		this.auxService = new AuxServiceImpl(itemRepository, listaDeComprasRepository);
		this.auxController = new AuxController(auxService,validatorLista, validatorItem);
	}	
	
	/**
	 * {@link ApplicationFactory#getItemController()}
	 * @return a instância de ItemController
	 */
	@Override
	public ItemController getItemController() {
		return this.itemController;
	}

	/**
	 * {@link ApplicationFactory#getListaDeComprasController()}
	 * @return a instancia de ListaDeComprasController
	 */
	@Override
	public ListaDeComprasController getListaDeComprasController() {
		return this.listaDeComprasController;
	}

	@Override
	public AuxController getAuxController() {
		return this.auxController;
	}
}