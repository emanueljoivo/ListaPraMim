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

    /**
     * Método que gera um ItemCategoria para ser utilizado para a criação do objeto referente a esse item.
     *
     * @param categoria string que descreve a categoria do item.
     * @return um ItemCategoria que será passado na criação do item ou null caso não haja match da string
     * com as categorias.
     */
    public static ItemCategorias generateCategoria(String categoria) {
        ItemCategorias[] values = ItemCategorias.values();

        int i = 0;
        while (!(values[i].getValue().equals(categoria.toLowerCase().trim())) && (i < (values.length - 1))) i++;

        return values[i];
    }
}