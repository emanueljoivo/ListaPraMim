package validation;

import enums.ListaDeComprasExceptionMessages;

public class ValidatorListaDeComprasImpl extends Validator implements ValidatorListaDeCompras {

    @Override
    public void validaDescritor(String descritorLista)
            throws IllegalArgumentException, NullPointerException {
        this.generalValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.CRIACAO_INVALIDA_DESCRITOR.getErrorMessage());
    }

    @Override
    public void validaCompra(String descritorLista, double quantidade, int itemId)
            throws IllegalArgumentException, NullPointerException {

        this.generalValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.COMPRA_INVALIDA_DESCRITOR.getErrorMessage());
        this.generalValidatorNumber(quantidade,
                ListaDeComprasExceptionMessages.COMPRA_INVALIDA_QUANTIDADE.getErrorMessage());
        this.generalValidatorNumber(itemId, ListaDeComprasExceptionMessages.COMPRA_INVALIDA_ITEM.getErrorMessage());
    }

    @Override
    public void validaAtualizacao(String descritorLista, int itemId, int quantidade)
            throws IllegalArgumentException, NullPointerException {
        this.generalValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_DESCRITOR.getErrorMessage());

        this.generalValidatorNumber(itemId,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_ITEM.getErrorMessage());

        this.generalValidatorNumber(quantidade,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_QUANTIDADE.getErrorMessage());
    }

    @Override
    public void validaExclusao(String descritorLista, int itemId)
            throws IllegalArgumentException, NullPointerException {

        this.generalValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.EXCLUSAO_INVALIDA_DESCRITOR.getErrorMessage());

        this.generalValidatorNumber(itemId,
                ListaDeComprasExceptionMessages.EXCLUSAO_INVALIDA_ITEM.getErrorMessage());
    }

    @Override
    public void validaPesquisa(String descritorLista, int itemId)
            throws IllegalArgumentException, NullPointerException {

        this.generalValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_DESCRITOR.getErrorMessage());
        this.generalValidatorNumber(itemId,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_ITEM.getErrorMessage()) ;
    }

    @Override
    public void validaFinalizacaoDeLista(String descritorLista, String localDaCompra, double valorFinalDaCompra)
            throws IllegalArgumentException, NullPointerException {

        this.generalValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_DESCRITOR.getErrorMessage());

        this.generalValidatorString(localDaCompra,
                ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_LOCAL.getErrorMessage());

        this.generalValidatorNumber(valorFinalDaCompra,
                ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_VALOR.getErrorMessage());

    }
}
