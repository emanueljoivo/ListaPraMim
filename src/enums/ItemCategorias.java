package enums;

/**
 * Enum de categorias dos itens.
 * 
 * @author Emanuel Joivo
 *
 */
public enum ItemCategorias implements Comparable<ItemCategorias>  {
    HIGIENTE_PESOAL("higiene pessoal"),
    LIMPEZA("limpeza"),
    INDUSTRIALIZADOS("alimento industrializado"),
    NAO_INDUSTRIALIZADOS("alimento nao industrializado");

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