package enums;

/**
 * Enum de categorias dos itens.
 * 
 * @author Emanuel Joivo
 *
 */
public enum ItemCategorias {
	
    INDUSTRIALIZADOS("alimento industrializado"),
    NAO_INDUSTRIALIZADOS("alimento não industrializado"),
    LIMPEZA("limpeza"),
    HIGIENTE_PESOAL("higiene pessoal");

    private String categoria;

    ItemCategorias(String categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Pega o valor atribuído ao enum.
     * @return uma representação em string do enum.
     */
    public String getValue() {
    	return this.categoria;
    }    
}