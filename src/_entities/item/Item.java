package _entities.item;

import java.util.HashMap;
import java.util.Map;

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
	public long getId() {
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
	 * Atualiza o valo de um atributo em específico.
	 * @param atributo a ser atualizado.
	 * @param novoValor valor a ser atribuído.
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
		return toString() + "Menor Preço: " + menorPreco;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Método que pega menor preco no mapa de preços.
	 * @return o menor preço do mapa de preços;
	 */
	public String getMenorPreco() {
		Map<String, Double> precos = getMapaDePrecos();
		Double minor = min(precos.values());
		return minor.toString();
	}
}