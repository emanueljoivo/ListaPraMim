package _repositories;

import _entities.geradorAutomaticoListaDeCompras.GeradorAutomaticoListaDeCompras;
import _entities.geradorAutomaticoListaDeCompras.GeradorAutomaticoPorItem;
import _entities.geradorAutomaticoListaDeCompras.GeradorAutomaticoPorItensMaisPresentes;
import _entities.geradorAutomaticoListaDeCompras.GeradorAutomaticoPorListaMaisRecente;
import _entities.item.Item;
import _entities.listaDeCompras.ListaDeCompra;
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

	public void save(ListaDeCompra l) {
        this.listasDeCompras.add(l);
    }

    @Override
    public boolean notContainList(String descritorLista) {
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

    @Override
    public List<ListaDeCompra> getListsByItem(Item item) {
        List<ListaDeCompra> auxList = new ArrayList<>();

        for (ListaDeCompra l : this.listasDeCompras) {
            if (l.getCompras().contains(item)) {
                auxList.add(l);
            }
        }
        return auxList;
    }

    /*
     * US5
     */
    
    @Override
    public void geraAutomaticaItem(String descritorItem) throws ListaDeComprasNotExistException, CompraNotExistException {
    	this.geradorAutomatico = new GeradorAutomaticoPorItem(descritorItem);
    	gerar();
    }
    
    @Override
    public void geraAutomaticaItensMaisPresentes() throws ListaDeComprasNotExistException, CompraNotExistException {
    	this.geradorAutomatico = new GeradorAutomaticoPorItensMaisPresentes();
    	gerar();
    }
    
    @Override
    public void geraAutomaticaUltimaLista() throws ListaDeComprasNotExistException, CompraNotExistException {
    	this.geradorAutomatico = new GeradorAutomaticoPorListaMaisRecente();
    	gerar();
    }

    private void gerar() throws ListaDeComprasNotExistException, CompraNotExistException{
		this.listasDeCompras.add(this.geradorAutomatico.gerar(this.listasDeCompras));
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
