package _services;

import _entities.comparators.ComprasComparator;
import _entities.comparators.ListaDescritorComparator;
import _entities.comparators.NomeComparator;
import _entities.item.Item;
import _entities.listaDeCompras.Compra;
import _entities.listaDeCompras.ListaDeCompra;
import _entities.sugestorMelhorEstabelecimento.SugestorDeEstabelecimentos;
import _entities.sugestorMelhorEstabelecimento.SugestorDeEstabelecimentosImpl;
import _repositories.ItemRepository;
import _repositories.ListaDeComprasRepository;
import enums.ListaDeComprasExceptionMessages;
import enums.OperacoesDeAtualizacao;
import itemExceptions.ItemNotExistException;
import listaDeComprasExceptions.*;

import java.util.*;

public class ListaDeComprasServiceImpl implements ListaDeComprasService {

    private ListaDeComprasRepository listaRepository;
    private ItemRepository itemRepository;
    private SugestorDeEstabelecimentos sugestorEstabelecimento;

    public ListaDeComprasServiceImpl(ListaDeComprasRepository listRepository, ItemRepository itemRepository) {
        this.listaRepository = listRepository;
        this.itemRepository = itemRepository;
        this.sugestorEstabelecimento = new SugestorDeEstabelecimentosImpl();
    }

    @Override
    public String adicionaNovaLista(String descritor) {
        this.listaRepository.save(new ListaDeCompra(descritor));
        return descritor;
    }

    @Override
    public void adicionaNovaCompra(String descritorLista, double quantidade, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraAlreadyExistException {

        verificaIntegridade(descritorLista, itemId, ListaDeComprasExceptionMessages.ERRO_COMPRA.getErrorMessage());

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
    public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int novaQuantidade)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException, OperacaoInvalidaException {

        verificaIntegridade(descritorLista, itemId,
                ListaDeComprasExceptionMessages.ERRO_ATUALIZACAO.getErrorMessage());

        ListaDeCompra listaDeCompraAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaDeCompraAtual.getCompra(itemId);

        verificaCompra(compraAtual, ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_COMPRA_NAO_ENCONTRADA.getErrorMessage());

        if (operacao.equalsIgnoreCase(OperacoesDeAtualizacao.ADICIONA.getOperacao())) {
            compraAtual.setQuantidade(compraAtual.getQuantidade() + novaQuantidade);
        } else if (operacao.equalsIgnoreCase(OperacoesDeAtualizacao.DIMINUI.getOperacao())) {
            if (compraAtual.getQuantidade() < 0) {
                throw new OperacaoInvalidaException(
                        ListaDeComprasExceptionMessages.ATUALIZACAO_INVALIDA_OPERACAO.getErrorMessage());

            } else if (compraAtual.getQuantidade() == 0) {
                listaDeCompraAtual.removeCompra(itemId);
            }
            compraAtual.setQuantidade(Math.abs(compraAtual.getQuantidade() - novaQuantidade));
        }
    }

    @Override
    public void deletaCompraDeLista(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {

        verificaIntegridade(descritorLista, itemId,
                ListaDeComprasExceptionMessages.ERRO_EXCLUSAO.getErrorMessage());



        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaAtual.getCompra(itemId);

        verificaCompra(compraAtual,
                ListaDeComprasExceptionMessages.EXCLUSAO_INVALIDA_COMPRA_NAO_ENCONTRADA.getErrorMessage());

        listaAtual.getCompras().remove(compraAtual);
    }

    @Override
    public String pesquisaCompraEmLista(String descritorLista, int itemId)
            throws ListaDeComprasNotExistException, ItemNotExistException, CompraNotExistException {

        verificaIntegridade(descritorLista, itemId,
                ListaDeComprasExceptionMessages.ERRO_PESQUISA.getErrorMessage());
        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);
        Compra compraAtual = listaAtual.getCompra(itemId);

        verificaCompra(compraAtual,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_COMPRA_NAO_ENCONTRADA.getErrorMessage());

        return compraAtual.toString();
    }

    @Override
    public String imprimeListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {
        verificaDescritor(descritorLista,
                ListaDeComprasExceptionMessages.IMPRESSAO_INVALIDA_LISTA_NOT_EXIST.getErrorMessage());

        String listaStringify = "";

        List<Compra> compras = setToList(this.listaRepository.
                recoveryLista(descritorLista).getCompras());

        ComprasComparator c1 = new ComprasComparator();
        NomeComparator c2 = new NomeComparator();

        Collections.sort(compras, c1.thenComparing(c2));

        for (Compra compra : compras) {
            listaStringify += compra.toString() + System.lineSeparator();
        }
        return listaStringify.substring(0, listaStringify.length()-1);
    }

    @Override
    public void finalizaListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra) throws ListaDeComprasNotExistException {
        verificaDescritor(descritorLista, ListaDeComprasExceptionMessages.ERRO_FINALIZACAO.getErrorMessage());

        ListaDeCompra listaAtual = this.listaRepository.recoveryLista(descritorLista);

        listaAtual.setLocalDeCompra(localDaCompra);
        listaAtual.setValorFinal(valorFinalDaCompra);
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
        verificaItem(id,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_COMPRA_NAO_ENCONTRADA.getErrorMessage());

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

    /*
      US - 4
     */
    @Override
    public String pesquisaListaDeCompras(String descritorLista) throws ListaDeComprasNotExistException {
        this.verificaDescritor(descritorLista,
                ListaDeComprasExceptionMessages.PESQUISA_INVALIDA_LISTA_NOT_EXIST.getErrorMessage());

        return this.listaRepository.recoveryLista(descritorLista).getDescritor();
    }

    private void verificaIntegridade(String descritorLista, int itemId, String errorMessage)
            throws ListaDeComprasNotExistException, ItemNotExistException {

        verificaDescritor(descritorLista,
                (errorMessage + ListaDeComprasExceptionMessages.LISTA_NOT_EXIST.getErrorMessage()));
        verificaItem(itemId,
                (errorMessage + ListaDeComprasExceptionMessages.ITEM_NOT_EXIST.getErrorMessage()));
    }

    private void verificaItem(int itemId, String errorMessage) throws ItemNotExistException {
        if (!this.itemRepository.contains(itemId)) {
            throw new ItemNotExistException(errorMessage);
        }
    }

    private void verificaDescritor(String descritorLista, String errorMessage) throws ListaDeComprasNotExistException {
        if (this.listaRepository.notContainList(descritorLista)) {
            throw new ListaDeComprasNotExistException(errorMessage);
        }
    }

    private void verificaCompra(Compra compra, String msg) throws CompraNotExistException {
        if (compra == null) {
            throw new CompraNotExistException(msg);
        }
    }

    // US 5

	@Override
	public String geraAutomaticaUltimaLista()
			throws ListaDeComprasNotExistException, CompraNotExistException {
		return this.listaRepository.geraAutomaticaUltimaLista();
	}

	@Override
	public String geraAutomaticaItensMaisPresentes() 
			throws ListaDeComprasNotExistException, CompraNotExistException {
		return this.listaRepository.geraAutomaticaItensMaisPresentes();
	}

	@Override
	public String geraAutomaticaItem(String descritorItem)
			throws ListaDeComprasNotExistException, CompraNotExistException {
		return this.listaRepository.geraAutomaticaItem(descritorItem);
	}
	
	@Override
    public String sugereMelhorEstabelecimento(String descritorLista) throws ListaDeComprasNotExistException, SemDadosEstabelecimentosException{
    	if (this.listaRepository.notContainList(descritorLista)) {
    		throw new ListaDeComprasNotExistException(ListaDeComprasExceptionMessages
    				.NAO_EXISTE_LISTA_PESQUISA_ESTABELECIMENTO.getErrorMessage());
    	}
    	
    	ListaDeCompra lista = this.listaRepository.recoveryLista(descritorLista);
    	
    	Map<String, Double> melhoresEstabelecimentos = 
    			this.sugestorEstabelecimento.melhoresEstabelecimentos(lista);
    	
    	if (melhoresEstabelecimentos.size() < 2) {
    		throw new SemDadosEstabelecimentosException(ListaDeComprasExceptionMessages
    				.SEM_DADOS_ESTABELECIMENTO.getErrorMessage());
    	}
    	
    	Double maior = (double) Integer.MIN_VALUE;
    	Double menor = (double) Integer.MIN_VALUE;
    	
    	String maiorStr = "";
    	String menorStr = "";
    	
    	for (Map.Entry<String, Double> entry : melhoresEstabelecimentos.entrySet()) {
    		Double value = entry.getValue();
    		String key = entry.getKey();
    		
    		if (value.compareTo(maior) > 0) {
    			maior = value;
    			maiorStr = key;
    		} else if (value.compareTo(menor) > 0) {
    			menor = value;
    			menorStr = key;
    		}
    	}
    	
    	if (checkDisjoint(maiorStr, menorStr, lista.getCompras())) {
    		throw new SemDadosEstabelecimentosException("Faltam dados para identificar se o melhor local"
    				+ " de compra e o " + maiorStr + "ou o " + menorStr);
    	}
    	
    	String out = maiorStr + ", R$ " + String.format("%,.2f", maior) + System.lineSeparator() +
    			menorStr + ", R$ " + String.format("%,.2f", menor);
    	
    	return out;
    }

	private boolean checkDisjoint(String maiorStr, String menorStr, Set<Compra> compras) {
		int count = 0;
		
		for (Compra c: compras) {
			Double dMaior = c.getItemCompravel().getMapaDePrecos().get(maiorStr);
			Double dMenor = c.getItemCompravel().getMapaDePrecos().get(menorStr);
			if (dMaior == null ^ dMenor == null) {
				/*
				 * utilizando o operador lógico XOR de java ^, pois se os dois não tiverem dados para um item,
				 * ou seja, ambos forem nulos para essa busca, o programa ainda deve retornar o melhor 
				 * estabelecimento.
				 */
				count++;
			}
		}
		
		return count == compras.size();
	}
}
