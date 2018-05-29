package _entities.item;

import enums.ItemCategoria;

public class ItemPorUnidade extends Item {
	
	private int unidades;
	
	public ItemPorUnidade(int id, String nome, ItemCategoria categoria, int unidades) {
		super(id, nome, categoria);
		this.unidades = unidades;
	}

	/**
	 * @return the unidades
	 */
	public int getUnidades() {
		return unidades;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "Preço: " + super.getMapaDePrecos().toString();
	}
	
	

	
	
	

}
