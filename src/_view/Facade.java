package _view;

import item_exceptions.ItemExistException;
import item_exceptions.ItemNotExistException;

/**
 * Interface que define contrato de funcionalidades oferecidas pelo sistema.
 * 
 * @author Emanuel Joivo
 *
 */
public interface Facade {	
	
	void start();		
	
	void adicionaItem(String nome, String categoria, int qtd, String unidadeDeMedida) throws IllegalArgumentException, NullPointerException, ItemExistException;
	
	void adicionatem(String nome, String categoria, int unidade) throws NullPointerException, IllegalArgumentException, ItemExistException;
	
	void adicionaItem(String nome, String categoria, double kg) throws NullPointerException, IllegalArgumentException, ItemExistException;
	
	void listaItem(int id) throws ItemNotExistException;
	
	void atualizaItem(int id, String atributo, String novoValor) throws IllegalArgumentException, ItemNotExistException;		
	
	void deletaItem(int id) throws ItemNotExistException;
}