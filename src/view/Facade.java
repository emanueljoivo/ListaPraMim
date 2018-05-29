package view;

public class Facade {
	private System system;
	
	public Facade(System system) {
		this.system = system;
	}
	
	public void start() {
		this.system.init();		
	}	
	
	public void criaItemIndustrializado(String nome, String categoria) throws IllegalArgumentException {
		this.system.getItemController().criaItem(nome, categoria);
	}
	
	public void atualizaNomeItem(int id, String novoNome) {
		
	}
	
	public void atualizaCategoriaItem(int id, String novaCategoria) {
		
	}
	
	public void listaItem(int id) {
		this.system.getItemController().listaItem(id);
	}
	
	public void apagaItem(int id) {
		
	}	
}