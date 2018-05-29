package _entities.item;

import enums.ItemCategoria;

/**
 * Classe que representa um item vendido por quilo.
 *
 */
public class ItemPorQuilo extends Item {
	private double kg;
	
	/**
	 * Constrói um item do tipo ItemPorQuilo.
	 * @param id
	 * @param nome
	 * @param categoria
	 * @param kg
	 */
	public ItemPorQuilo(int id, String nome, ItemCategoria categoria, double kg) {
		super(id, nome, categoria);
		this.kg = kg;
	}

	/**
	 * @return the kg
	 */
	public double getKg() {
		return kg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "Preço por quilo: " + super.getMapaDePrecos().toString();
	}
	
	

}
