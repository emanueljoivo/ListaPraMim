package _repositories;

import _entities.listaDeCompras.GeradorAutomaticoItensMaisPresentes;
import _entities.listaDeCompras.GeradorAutomaticoListaDeCompras;
import _entities.listaDeCompras.GeradorAutomaticoPorItem;
import _entities.listaDeCompras.GeradorAutomaticoPorListaMaisRecente;
import _entities.listaDeCompras.ListaDeCompra;
import enums.AutoGeneratorStrategies;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;

import java.util.ArrayList;
import java.util.List;

public class ListaDeComprasRepositoryImpl implements ListaDeComprasRepository {

    private List<ListaDeCompra> listasDeCompras;
    private GeradorAutomaticoListaDeCompras geradorAutomatico;

    public ListaDeComprasRepositoryImpl() {
        this.listasDeCompras = new ArrayList<>();
    }
    
    public void geraAutomaticaItem(String descritorItem) throws ListaDeComprasNotExistException, CompraNotExistException {
    	this.geradorAutomatico = new GeradorAutomaticoPorItem(descritorItem);
    	gerar();
    }
    
    public void geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException {
    	this.geradorAutomatico = new GeradorAutomaticoItensMaisPresentes();
    	gerar();
    }
    
    public void geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException {
    	this.geradorAutomatico = new GeradorAutomaticoPorListaMaisRecente();
    	gerar();
    }

    private void gerar() throws ListaDeComprasNotExistException, CompraNotExistException{
		this.geradorAutomatico.gerar(this.listasDeCompras);
	}

	public boolean save(ListaDeCompra l) {
        return this.listasDeCompras.add(l);
    }

    @Override
    public boolean containsLista(String descritorLista) {
        return containsListaPorDescritor(descritorLista);
    }

    @Override
    public ListaDeCompra recoveryLista(String descritorLista) {
        return recoveryListaPorDescritor(descritorLista);
    }

    @Override
    public List<ListaDeCompra> getAllLists() {
        List<ListaDeCompra> listResult = new ArrayList<>();
        listResult.addAll(listasDeCompras);
        return listResult;
    }

    private ListaDeCompra recoveryListaPorDescritor(String descritorLista) {
        ListaDeCompra listaAtual = null;
        for (ListaDeCompra l: this.listasDeCompras) {
            if (l.getDescritor().equalsIgnoreCase(descritorLista)) {
                listaAtual = l;
            }
        }
        return listaAtual;
    }

    private boolean containsListaPorDescritor(String descritorLista) {
        for (ListaDeCompra l : this.listasDeCompras) {
            if (l.getDescritor().equalsIgnoreCase(descritorLista))
                return true;
        }
        return false;
    }
}
