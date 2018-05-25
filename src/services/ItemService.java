package services;

public interface ItemService {

	public void cria(String nome, String categoria);
	
	public void ler(long id);
	
	public void atualiza(long id);
	
	public void deleta(long id);
	
}
