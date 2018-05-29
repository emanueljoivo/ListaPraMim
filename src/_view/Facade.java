package _view;

public class Facade {
	private System system;
	
	public Facade(System system) {
		this.system = system;
	}
	
	public void start() {
		this.system.init();		
	}	
	
	public void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws IllegalArgumentException {
		this.system.getItemController().adicionaItem(nome, categoria, qtd, unidadeDeMedida);
	}
	
	public void adicionatem(String nome, String categoria, int unidade) {
		this.system.getItemController().adicionaItem(nome, categoria, unidade);
	}
	
	public void adicionaItem(String nome, String categoria, double kg) {
		this.system.getItemController().adicionaItem(nome, categoria, kg);
	}
	
	public void atualizaNomeItem(int id, String novoNome) {
		this.system.getItemController().atualizaNomeItem(id, novoNome); 
	}
	
	public void atualizaCategoriaItem(int id, String novaCategoria) {
		this.system.getItemController().atualizaCategoriaItem(id, novaCategoria);
	}
		
	public void listaItem(int id) {
		this.system.getItemController().listaItem(id);
	}
	
	public void deletaItem(int id) {
		this.system.getItemController().deletaItem(id);
	}	
}