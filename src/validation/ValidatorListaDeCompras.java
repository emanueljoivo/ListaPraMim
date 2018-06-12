package validation;

public interface ValidatorListaDeCompras {

    void validaDescritor(String descritor);

    void validaCompra(String descritorLista, double quantidade, int itemId);

    void validaAtualizacao(String descritorLista, int itemId, int quantidade);

    void validaExclusao(String descritorLista, int itemId);

    void validaPesquisa(String descritorLista, int itemId);

    void validaFinalizacaoDeLista(String descritorLista, String localDaCompra, double valorFinalDaCompra);
}
