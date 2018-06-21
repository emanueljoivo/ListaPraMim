package _services;

import _entities.listaDeCompras.Compra;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

import java.util.Date;

public interface ListaDeComprasService {

    void adicionaNovaLista(String descritor);

    void adicionaNovaCompra(String descritorLista, double quantidade, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException;

    void atualizaCompraDeLista(String descritorLista, int itemId, int novaQuantidade)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException;

    void deletaCompraDeLista(String descritorLista, int itemId) throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException;

    String pesquisaCompraDeLista(String descritorLista, int itemId) throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException;

    String imprimirListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException;

    void finalizaListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra) throws ListaDeComprasNotExistException;

    String pesquisaListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException;

    String pesquisaListasDeComprasPorData(Date data);

    String pesquisaListasDeComprasPorItem(int id) throws ItemNotExistException;
    
    void geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    void geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException;
    
    void geraAutomaticaItem(String descritorItem) throws ListaDeComprasNotExistException, CompraNotExistException;
}
