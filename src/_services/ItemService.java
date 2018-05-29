package _services;

import _entities.item.Item;

public interface ItemService {

	void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida);
	
	void adicionaItem(String nome, String categoria, int unidade);

	void adicionaItem(String nome, String categoria, double kg);
	
	Item lerItem(int id);
	
	void atualizaItem(int id, String novoNome);
	
	void atualizaItem(String categoria, int id);

	void deletaItem(int id);
	
}
