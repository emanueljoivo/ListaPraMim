package _entities.item;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import enums.ItemAtributos;
import enums.ItemCategorias;
import util.Util;

import static java.util.Collections.min;

/**
 * Classe abstrata que representa o tipo mais geral de items.  
 * 
 * @author Emanuel Joivo
 */
public abstract class Item implements Comparable<Item>{

	private int id;
	protected String nome;
	protected ItemCategorias categoria;
	protected Map<String, Double> mapaDePrecos;
	
	public Item(int id, String nome, ItemCategorias categoria) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.mapaDePrecos = new HashMap<>();
	}	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the categoria
	 */
	public ItemCategorias getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(ItemCategorias categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the mapaDePrecos
	 */
	public Map<String, Double> getMapaDePrecos() {
		return mapaDePrecos;
	}

	/**
	 * @param mapaDePrecos the mapaDePrecos to set
	 */
	public void setMapaDePrecos(Map<String, Double> mapaDePrecos) {
		this.mapaDePrecos = mapaDePrecos;
	}
	
	/**
	 * Atualiza o valo de um atributo em especifico.
	 * @param atributo a ser atualizado.
	 * @param novoValor valor a ser atribuido.
	 */
	public void set(String atributo, String novoValor) {		
		if (atributo.equals(ItemAtributos.NOME.getValue())) {			
			setNome(novoValor);
		} else if (atributo.equals(ItemAtributos.CATEGORIA.getValue()) ) {
			setCategoria(Util.generateCategoria(novoValor));
		}	
	}

	@Override
	public int compareTo(Item i) {
        return getNome().compareTo(i.getNome());
    }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.id + ". " + this.nome + ", " 
				+ this.categoria.getValue() + ", ";
	}

	public String toString(String menorPreco) {
		return toString() + "Menor Preco: " + menorPreco;
	}

	abstract public String toString(double quantidade);

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return id == item.id;
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}

	/**
	 * Metodo que pega menor preco no mapa de preços.
	 * @return o menor preço do mapa de precos;
	 */
	public String getMenorPreco() {
		Map<String, Double> precos = getMapaDePrecos();
		Double menorPreco = min(precos.values());
		return menorPreco.toString();
	}
}