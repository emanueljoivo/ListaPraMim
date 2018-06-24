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
import itemExceptions.ItemSemPrecoException;
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

        verificaCompra(compraAtual, ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_COMPRA_NAO_ENCONTRADA.getErrorMessage());

        if ((compraAtual.getQuantidade() < novaQuantidade)) {
            deletaCompraDeLista(descritorLista, itemId);
        } else {
            compraAtual.setQuantidade(compraAtual.getQuantidade() - novaQuantidade);
        }
    }

    @Override
    public void deletaCompraDeLista(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {
        verificaIntegridade(descritorLista, itemId);

        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaAtual.getCompra(itemId);

        verificaCompra(compraAtual,
                ListaDeComprasExceptionMessages.EXCLUSAO_INVALIDA_COMPRA_NAO_ENCONTRADA.getErrorMessage());
        listaAtual.getCompras().remove(compraAtual);
    }

    @Override
    public String pesquisaCompraEmLista(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {

        verificaIntegridade(descritorLista, itemId);
        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaAtual.getCompra(itemId);

        verificaCompra(compraAtual,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_COMPRA_NAO_ENCONTRADA.getErrorMessage());

        return compraAtual.toString();
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
            listaStringify += compra.toString() + " |";
        }
        return listaStringify.substring(0, listaStringify.length()-2);
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

        Comparator<ListaDeCompra> currentComparator = new ListaDescritorComparator();
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
        List<Compra> listaAux = new ArrayList<>();
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

    private void verificaCompra(Compra compra, String msg) throws CompraNotExistException {
        if (compra == null) {
            throw new CompraNotExistException(msg);
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
	
	@Override
    public String sugereMelhorEstabelecimento(String descritorLista) throws ListaDeComprasNotExistException, ItemSemPrecoException{
    	if (!this.listaRepository.containsLista(descritorLista)) {
    		throw new ListaDeComprasNotExistException(ListaDeComprasExceptionMessages
    				.NAO_EXISTE_LISTA_PESQUISA_ESTABELECIMENTO.getErrorMessage());
    	}
    	
    	return this.getMelhorEstabelecimento(this.listaRepository.recoveryLista(descritorLista));
    }

    private String getMelhorEstabelecimento(ListaDeCompra lista) throws ItemSemPrecoException {
    	String out = "";
    	
    	List<Item> itens = new ArrayList<>();
    	
    	for (Compra c: lista.getCompras()) {
    		itens.add(c.getItemCompravel());
    	}
    	
    	String[] estabelecimentos = estabelecimentosMaisCitados(itens);
    	Map<String, Double> outMap = new HashMap<>();
    	
    	for (String estabelecimento: estabelecimentos) {
    		if (estabelecimento != null) {
    			for (Item item: itens) {
    				Map<String, Double> mapPrecos = item.getMapaDePrecos();
    				Double preco = mapPrecos.get(estabelecimento);
    				Double outMapPreco = outMap.get(estabelecimento);
    				
    				if (outMapPreco == null)
    					outMapPreco = new Double(0);
    				
    				outMap.put(estabelecimento, preco + outMapPreco);
    			}
    		}
    	}
    	
    	if (estabelecimentos[1] == null) {
    		out += estabelecimentos[0] + ", R$ " + outMap.get(estabelecimentos[0]) + System.lineSeparator();
    	} else {
    		if (outMap.get(estabelecimentos[1]).compareTo(outMap.get(estabelecimentos[0])) < 0) {
    			out += estabelecimentos[1] + ", R$ " + outMap.get(estabelecimentos[1]) + System.lineSeparator();
    			out += estabelecimentos[0] + ", R$ " + outMap.get(estabelecimentos[0]) + System.lineSeparator();
    		} else {
    			out += estabelecimentos[0] + ", R$ " + outMap.get(estabelecimentos[0]) + System.lineSeparator();
    			out += estabelecimentos[1] + ", R$ " + outMap.get(estabelecimentos[1]) + System.lineSeparator();
    		}
    	}
    	
		return out;
	}
    
    private String[] estabelecimentosMaisCitados(List<Item> itens) throws ItemSemPrecoException {
    	Map<String, Integer> countMap = countEstabelecimentos(itens);
    	
    	Map.Entry<String, Integer> mapEstab1 = null;
    	Map.Entry<String, Integer> mapEstab2 = null;
    	
    	for (Map.Entry<String, Integer> entry: countMap.entrySet()) {
    		if (mapEstab1 == null || entry.getValue().compareTo(mapEstab1.getValue()) > 0) {
    			mapEstab1 = entry;
    		} else if (mapEstab2 == null || entry.getValue().compareTo(mapEstab2.getValue()) > 0) {
    			mapEstab2 = entry;
    		}
    	}
    	
    	String[] out = new String[2];
    	
    	if (mapEstab1 == null)
    		throw new ItemSemPrecoException("Nao ha mapa de preço para item algum."); // alterar mensagem depois
    	else {
    		out[0] = mapEstab1.getKey();
    		
    		if(mapEstab2 != null)
    			out[1] = mapEstab2.getKey();
    	}
    	
    	return out;
    }
    
    private Map<String, Integer> countEstabelecimentos(List<Item> itens) {
    	Map<String, Integer> countMap = new HashMap<>();
    	
    	for (Item item: itens) {
    		for(String s: item.getMapaDePrecos().keySet()) {
    			Integer count = countMap.get(s);
    			if (count == null)
    				count = new Integer(0);
    			countMap.put(s, count);
    		}
    	}
    	
    	return countMap;
    }
}
