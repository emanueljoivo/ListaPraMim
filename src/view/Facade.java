package view;

public class Facade {
	private System system;
	
	public Facade(System system) {
		this.system = system;
	}
	
	public void start() {
		this.system.init();		
	}	
	
	public void criaItemIndustrializado(String nome) {
		this.system.getItemController().criaItem(nome);
	}
	
	public void criaItemNaoIndustrializado(String nome) {
		
	}
	
	public void criaItemLimpeza(String nome) {
		
	}
	
	public void criaItemHigienePessoal(String nome) {
		
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