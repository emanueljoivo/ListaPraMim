package enums;

public enum ItemCategoria {

    INDUSTRIALIZADOS("Alimentos industrializados"),
    NAO_INDUSTRIALIZADOS("Alimentos nao industrializados"),
    LIMPEZA("Limpeza"),
    HIGIENTE_PESOAL("Higiene");

    private String categoria;

    ItemCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValue() {return this.categoria;}
}
