package _entities.item;

import enums.ItemCategoria;

/**
 * Classe que representa um item com quantidade fixa.
 *
 */
public class ItemPorQntdFixa extends Item {
	private int qntd;
	private String unidadeDeMedida;

	/**
	 * Constrói um item do tipo ItemPorQntdFixa.
	 * @param id
	 * @param nome
	 * @param categoria
	 * @param qntd
	 * @param unidadeDeMedida
	 */
	public ItemPorQntdFixa(int id, String nome, ItemCategoria categoria, int qntd, String unidadeDeMedida) {
		super(id, nome, categoria);
		this.qntd = qntd;
		this.unidadeDeMedida = unidadeDeMedida;		
	}

	/**
	 * @return the qntd
	 */
	public int getQntd() {
		return qntd;
	}

	/**
	 * @return the unidadeDeMedida
	 */
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + this.qntd + " " 
				+ this.unidadeDeMedida + ", Preço: " + super.getMapaDePrecos().toString();
	}
	
	

}
