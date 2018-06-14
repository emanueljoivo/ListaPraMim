package validation;

import enums.ListaDeComprasExceptionMessages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Override
    public void validaPesquisa(String descritorLista)
            throws IllegalArgumentException, NullPointerException {

        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_DESCRITOR.getErrorMessage());
    }

    @Override
    public Date validaPesquisaPorData(String data)
            throws IllegalArgumentException, NullPointerException, ParseException {

        this.genericValidatorString(data,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_DATA_VN.getErrorMessage());

        return this.validaData(data,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_DATA.getErrorMessage());

    }

    @Override
    public void validaPesquisaPorItem(int id) {
        this.genericValidatorNumber(id,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_ITEM.getErrorMessage());
    }

    private Date validaData(String data, String errorMsg) throws ParseException {;
        SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = null;

        try {
            dataFormatada = formatPattern.parse(data);
        } catch (ParseException e) {
            throw new ParseException(errorMsg, e.getErrorOffset());
        }

        return dataFormatada;
    }
}
