package validation;

import enums.ListaDeComprasExceptionMessages;

public class ValidatorListaDeComprasImpl extends Validator implements ValidatorListaDeCompras {

    @Override
    public void validaDescritor(String descritorLista)
            throws IllegalArgumentException, NullPointerException {
        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.CRIACAO_INVALIDA_DESCRITOR.getErrorMessage());
    }

    @Override
    public void validaCompra(String descritorLista, double quantidade, int itemId)
            throws IllegalArgumentException, NullPointerException {

        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.COMPRA_INVALIDA_DESCRITOR.getErrorMessage());
        this.genericValidatorNumber(quantidade,
                ListaDeComprasExceptionMessages.COMPRA_INVALIDA_QUANTIDADE.getErrorMessage());
        this.genericValidatorNumber(itemId, ListaDeComprasExceptionMessages.COMPRA_INVALIDA_ITEM.getErrorMessage());
    }

    @Override
    public void validaAtualizacao(String descritorLista, int itemId, int quantidade)
            throws IllegalArgumentException, NullPointerException {
        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_DESCRITOR.getErrorMessage());

        this.genericValidatorNumber(itemId,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_ITEM.getErrorMessage());

        this.genericValidatorNumber(quantidade,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_QUANTIDADE.getErrorMessage());
    }

    @Override
    public void validaExclusao(String descritorLista, int itemId)
            throws IllegalArgumentException, NullPointerException {

        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.EXCLUSAO_INVALIDA_DESCRITOR.getErrorMessage());

        this.genericValidatorNumber(itemId,
                ListaDeComprasExceptionMessages.EXCLUSAO_INVALIDA_ITEM.getErrorMessage());
    }

    @Override
    public void validaPesquisa(String descritorLista, int itemId)
            throws IllegalArgumentException, NullPointerException {

        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_DESCRITOR.getErrorMessage());
        this.genericValidatorNumber(itemId,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_ITEM.getErrorMessage()) ;
    }

    @Override
    public void validaFinalizacaoDeLista(String descritorLista, String localDaCompra, double valorFinalDaCompra)
            throws IllegalArgumentException, NullPointerException {

        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_DESCRITOR.getErrorMessage());

        this.genericValidatorString(localDaCompra,
                ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_LOCAL.getErrorMessage());

        this.genericValidatorNumber(valorFinalDaCompra,
                ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_VALOR.getErrorMessage());

    }
}
