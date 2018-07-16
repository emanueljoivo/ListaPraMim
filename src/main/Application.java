package main;

import _controllers.AuxController;
import _controllers.ItemController;
import _controllers.ListaDeComprasController;
import _factories.ApplicationFactory;
import _factories.ApplicationFactoryImpl;
import java.io.*;

/**
 * Classe responsável por representar o Sistema como um todo. 
 * A comunicação entre Facade e o restante da aplicação é 
 * efetuada através deste objeto.
 * 
 * @author Emanuel Joivo.
 *
 */
public class Application implements Serializable {
	
	/**
	 * Fábrica das entidades estruturais do sistema.
	 */
	private ApplicationFactory appFactory;

	private final String PATH = "db/system.txt";

	private Application application = this;

	public Application() {init();}
	
	/**
	 * Cria a instância do sistema.
	 */
	private void init() {
		this.appFactory = new ApplicationFactoryImpl();
	}

	public void iniciaSistema() throws FileNotFoundException {

	    try {
	        FileInputStream fileInputStream = new FileInputStream(new File(PATH).getCanonicalPath());
            ObjectInputStream input = new ObjectInputStream(fileInputStream);
            this.application = (Application) input.readObject();
            input.close();
        } catch (FileNotFoundException e) {
			System.out.println("Sistema iniciado pela primeira vez. Arquivo criado." +
				System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
	}

	public void fechaSistema() throws IOException {
		 try {

			 FileOutputStream fileOutputStream = new FileOutputStream(new File(PATH).getCanonicalPath());
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);

             output.writeObject(this);
             output.close();
         } catch (IOException e) {
		     throw new IOException("Erro ao fechar sistema: " + e.toString());
         }
	}
	
	/**
	 * Pega o controlador de itens.
	 * @return a instância de ItemController.
	 */
	public ItemController getItemController() {
		return this.appFactory.getItemController();
	}

	/**
	 * Pega o controlador de lista de compras.
	 * @return a instância de ListaDeComprasController.
	 */
	public ListaDeComprasController getListaDeComprasController() {return this.appFactory.getListaDeComprasController(); }

	public AuxController getAuxController() {return this.appFactory.getAuxController();}
}