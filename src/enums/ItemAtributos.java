package enums;

public enum ItemAtributos {
	
	UNIDADES("unidades"),
	QUILOS("kg"),
	UNIDADE_DE_MEDIDA("unidade de medida"),
	QUANTIDADE("quantidade"),
	NOME("nome"),
	CATEGORIA("categoria");
	
	private String atributo;
	
	ItemAtributos(String atributo) {this.atributo = atributo;}

	/**
	 * Pega o valor do Enum.
	 * @return uma representação em string do atributo. 
	 */
	public String getValue() {
		return this.atributo;
	}	
}
