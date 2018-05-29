package _entities.item;

import _entities.enums.ItemCategoria;

import java.util.HashMap;
import java.util.Map;

public class Item {
	
	private long id;
	private String nome;
	private ItemCategoria categoria;
	private Map<String, Double> mapaDePrecos;
	
	public Item(long id, String nome, ItemCategoria categoria) {
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
	public ItemCategoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(ItemCategoria categoria) {
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.id + ". " + this.nome + ", " 
				+ this.categoria + ", ";
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
}