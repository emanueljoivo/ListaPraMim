package validation;

import _entities.listaDeCompras.ListaDeCompra;
import enums.ListaDeComprasExceptionMessages;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidatorListaDeComprasImpl extends Validator implements ValidatorListaDeCompras, Serializable {

    @Override
    public void validaCriacao(String descritorLista)
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
    public void validaAtualizacao(String descritorLista, int itemId, String operacao, int quantidade)
            throws IllegalArgumentException, NullPointerException {

        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_DESCRITOR.getErrorMessage());

        this.genericValidatorNumber(itemId,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_ITEM.getErrorMessage());

        this.genericValidatorNumber(quantidade,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_QUANTIDADE.getErrorMessage());

        this.genericValidatorString(operacao,
                ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_OPERACAO.getErrorMessage());
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

        validaPesquisa(descritorLista);

        this.genericValidatorNumber(itemId,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_ITEM.getErrorMessage()) ;
    }

    @Override
    public void validaPesquisa(String descritorLista) {
        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_DESCRITOR.getErrorMessage());
    }

    @Override
    public void validaFinalizacaoDeLista(String descritorLista, String localDaCompra, double valorFinalDaCompra)
            throws IllegalArgumentException, NullPointerException {

        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_DESCRITOR.getErrorMessage());

        this.genericValidatorString(localDaCompra,
                ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_LOCAL.getErrorMessage());

        validaValorFinalDeCompra(valorFinalDaCompra);

    }

    private void validaValorFinalDeCompra(double valorFinalDaCompra) {
        String errorMsg = ListaDeComprasExceptionMessages.FINALIZACAO_INVALIDA_VALOR.getErrorMessage();

        if (valorFinalDaCompra == 0) {
            throw new IllegalArgumentException(errorMsg);
        }

        this.genericValidatorNumber(valorFinalDaCompra, errorMsg);
    }

    @Override
    public void validaPesquisaDeItemEmLista(String descritorLista, int posicaoItem)
            throws IllegalArgumentException, NullPointerException {

        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_DESCRITOR.getErrorMessage());

        this.genericValidatorNumber(posicaoItem,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_POSICAO_ITEM.getErrorMessage());
    }

    @Override
    public Date validaPesquisaPorData(String data, int posicaoLista)
            throws IllegalArgumentException, NullPointerException, ParseException {

        this.genericValidatorNumber(posicaoLista,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_POSICAO_LISTA.getErrorMessage());

        return validaPesquisaPorData(data);
    }

    @Override
    public Date validaPesquisaPorData(String data) throws ParseException {
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

    @Override
    public void validaPesquisaPorItem(int id, int posicaoLista) {
        validaPesquisaPorItem(id);
        this.genericValidatorNumber(posicaoLista,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_POSICAO_LISTA.getErrorMessage());
    }

    @Override
    public void validaImpressaoDeCompra(String descritorLista) {
        this.genericValidatorString(descritorLista,
                ListaDeComprasExceptionMessages.IMPRESSAO_INVALIDA_DESCRITOR.getErrorMessage());
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
