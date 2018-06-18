package _services;

import _entities.comparators.ComprasComparator;
import _entities.comparators.ListaDescritorComparator;
import _entities.comparators.NomeComparator;
import _entities.item.Item;
import _entities.listaDeCompras.Compra;
import _entities.listaDeCompras.ListaDeCompra;
import _repositories.ItemRepository;
import _repositories.ListaDeComprasRepository;
import enums.ItemExceptionsMessages;
import enums.ListaDeComprasExceptionMessages;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.CompraNotExistException;
import listaDeComprasExceptions.CompraAlreadyExistException;
import listaDeComprasExceptions.ListaDeComprasNotExistException;
import java.util.*;

public class ListaDeComprasServiceImpl implements ListaDeComprasService {

    private ListaDeComprasRepository listaRepository;
    private ItemRepository itemRepository;

    public ListaDeComprasServiceImpl(ListaDeComprasRepository listRepository, ItemRepository itemRepository) {
        this.listaRepository = listRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void adicionaNovaLista(String descritor) {
        this.listaRepository.save(new ListaDeCompra(descritor));
    }

    @Override
    public void adicionaNovaCompra(String descritorLista, double quantidade, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

        verificaIntegridade(descritorLista, itemId);

        Item itemAtual = this.itemRepository.recovery(itemId);
        Compra compraAtual = new Compra(quantidade, itemAtual);
        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);

        if (listaAtual.getCompras().contains(compraAtual)) {
            throw new CompraAlreadyExistException(ListaDeComprasExceptionMessages.
                    COMPRA_JA_FEITA.getErrorMessage());
        }
        listaAtual.getCompras().add(compraAtual);
    }

    @Override
    public void atualizaCompraDeLista(String descritorLista, int itemId, int novaQuantidade)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {

        verificaIntegridade(descritorLista, itemId);
        Compra compraAtual = this.listaRepository.recoveryLista(descritorLista).
                getCompra(itemId);

        verificaCompra(compraAtual);

        if ((compraAtual.getQuantidade() - novaQuantidade) <= 0) {
            deletaCompraDeLista(descritorLista, itemId);
        } else {
            compraAtual.setQuantidade(novaQuantidade);
        }
    }

    @Override
    public void deletaCompraDeLista(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {
        verificaIntegridade(descritorLista, itemId);

        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaAtual.getCompra(itemId);

        verificaCompra(compraAtual);
        listaAtual.getCompras().remove(compraAtual);
    }

    @Override
    public Compra pesquisaCompraDeLista(String descritorLista, int itemId) throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {
        verificaIntegridade(descritorLista, itemId);

        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaAtual.getCompra(itemId);

        verificaCompra(compraAtual);

        return compraAtual;
    }

    @Override
    public String imprimirListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {
        verificaDescritor(descritorLista);

        String listaStringify = "";

        List<Compra> compras = setToList(this.listaRepository.
                recoveryLista(descritorLista).getCompras());

        ComprasComparator c1 = new ComprasComparator();
        NomeComparator c2 = new NomeComparator();

        Collections.sort(compras, c1.thenComparing(c2));

        for (Compra compra : compras) {
            listaStringify += compra.getItemCompravel().toString(compra.getQuantidade()) +
            System.lineSeparator();
        }
        return listaStringify;
    }

    @Override
    public void finalizaListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra) throws ListaDeComprasNotExistException {
        verificaDescritor(descritorLista);

        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);

        listaAtual.setLocalDeCompra(localDaCompra);
        listaAtual.setValorFinal(valorFinalDaCompra);
    }

    @Override
    public String pesquisaListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {
        this.verificaDescritor(descritorLista);

        return imprimirListaDeCompras(descritorLista);
    }

    @Override
    public String pesquisaListasDeComprasPorData(Date data) {
        List<ListaDeCompra> allLists = this.listaRepository.getAllLists();
        String listaStringifier = "";

        Comparator currentComparator = new ListaDescritorComparator();
        Collections.sort(allLists, currentComparator);

        for (ListaDeCompra l : allLists) {
            if (l.getMomentoDeCriacao().equals(data)) {
                listaStringifier += l.getDescritor() + System.lineSeparator();
            }
        }
        return listaStringifier;
    }

    @Override
    public String pesquisaListasDeComprasPorItem(int id) throws ItemNotExistException {
        verificaItem(id);
        Item itemAtual = this.itemRepository.recovery(id);
        List<ListaDeCompra> allLists = this.listaRepository.getAllLists();
        String listaStringifier = "";
        Collections.sort(allLists);

        for (ListaDeCompra l : allLists) {
            if (l.getCompras().contains(itemAtual)) {
                listaStringifier += l.toString();
            }
        }

        return listaStringifier;
    }

    private List<Compra> setToList(Set<Compra> compras) {
        List<Compra> listaAux = new ArrayList();
        listaAux.addAll(compras);
        return listaAux;
    }

    private void verificaIntegridade(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException {
        verificaDescritor(descritorLista);
        verificaItem(itemId);
    }

    private void verificaItem(int itemId) throws ItemNotExistException {
        if (!this.itemRepository.contains(itemId)) {
            throw new ItemNotExistException(ItemExceptionsMessages.
                    NAO_CONTEM_ITEM.getErrorMessage());
        }
    }

    private void verificaDescritor(String descritorLista) throws ListaDeComprasNotExistException {
        if (!this.listaRepository.containsLista(descritorLista)) {
            throw new ListaDeComprasNotExistException(ListaDeComprasExceptionMessages.
                    LISTA_NAO_ENCONTRADA.getErrorMessage());
        }
    }

    private void verificaCompra(Compra compra) throws CompraNotExistException {
        if (compra == null) {
            throw new CompraNotExistException(ListaDeComprasExceptionMessages.
                    COMPRA_NAO_ENCONTRADA.getErrorMessage());
        }
    }

	@Override
	public void geraAutomaticaUltimaLista()
			throws ListaDeComprasNotExistException, CompraNotExistException {
		this.listaRepository.geraAutomaticaUltimaLista();
	}

	@Override
	public void geraAutomaticaItensMaisPresentes() 
			throws ListaDeComprasNotExistException, CompraNotExistException {
		this.listaRepository.geraAutomaticaItensMaisPresentes();
	}

	@Override
	public void geraAutomaticaItem(String descritorItem)
			throws ListaDeComprasNotExistException, CompraNotExistException {
		this.listaRepository.geraAutomaticaItem(descritorItem);
	}
}
