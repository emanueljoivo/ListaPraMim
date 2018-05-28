package entities.item;

public class ItemPorQuilo extends Item {
	private int kg;
		
	public ItemPorQuilo(long id, String nome, String categoria, int kg) {
		super(id, nome, categoria);
		this.kg = kg;
	}

	/**
	 * @return the kg
	 */
	public int getKg() {
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
