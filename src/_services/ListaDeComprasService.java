package _services;

import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.*;

import java.util.Date;

public interface ListaDeComprasService {

    String adicionaNovaLista(String descritor);

    void adicionaNovaCompra(String descritorLista, double quantidade, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException;

    void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int novaQuantidade)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException, OperacaoInvalidaException;

    void deletaCompraDeLista(String descritorLista, int itemId) throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException;

    String pesquisaCompraEmLista(String descritorLista, int itemId) throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException;

    String imprimeListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException;

    void finalizaListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra) throws ListaDeComprasNotExistException;

    String pesquisaListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException;

    String pesquisaListasDeComprasPorData(Date data);

    String pesquisaListasDeComprasPorItem(int id) throws ItemNotExistException;
    
    String geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    String geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    String geraAutomaticaItem(String descritorItem) throws ListaDeComprasNotExistException, CompraNotExistException;

	String sugereMelhorEstabelecimento(String descritorLista) throws ListaDeComprasNotExistException, SemDadosEstabelecimentosException;
}
