package _entities.item;

import util.Util;

import enums.ItemAtributos;
import enums.ItemCategorias;

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
	public ItemPorQntdFixa(int id, String nome, ItemCategorias categoria, int qntd, String unidadeDeMedida) {
		super(id, nome, categoria);
		this.qntd = qntd;
		this.unidadeDeMedida = unidadeDeMedida;		
	}
	
	/**
	 * @see {@link _entities.item.Item#set(String, String)}}
	 */
	@Override
	public void set(String atributo, String novoValor) {
		super.set(atributo, novoValor);
		
		if (atributo.equals(ItemAtributos.UNIDADES.getValue())) {
			setQntd(Integer.parseInt(novoValor));
		} else if (atributo.equals(ItemAtributos.UNIDADE_DE_MEDIDA.getValue()));
	}

	/**
	 * @param qntd the qntd to set
	 */
	public void setQntd(int qntd) {
		this.qntd = qntd;
	}

	/**
	 * @param unidadeDeMedida the unidadeDeMedida to set
	 */
	public void setUnidadeDeMedida(String unidadeDeMedida) {
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
				+ this.unidadeDeMedida + ", Preço: " + Util.mapToString(getMapaDePrecos());
	}
	
	

}
