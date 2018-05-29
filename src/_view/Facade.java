package _view;

/**
 * Interface que define contrato de funcionalidades oferecidas pelo sistema.
 * 
 * @author Emanuel Joivo
 *
 */
public interface Facade {	
	
	void start();		
	
	void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida);
	
	void adicionatem(String nome, String categoria, int unidade);
	
	void adicionaItem(String nome, String categoria, double kg);
	
	void listaItem(int id);
	
	void atualizaNomeItem(int id, String novoNome);
	
	void atualizaCategoriaItem(int id, String novaCategoria);	
	
	void deletaItem(int id);
}