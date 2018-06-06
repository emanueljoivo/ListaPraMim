package _services;

import _entities.listaDeCompras.ListaDeCompra;
import _repositories.ListaDeComprasRepository;

public class ListaDeComprasServiceImpl implements ListaDeComprasService {

    private ListaDeComprasRepository repository;

    public ListaDeComprasServiceImpl(ListaDeComprasRepository repository) {
        this.repository = repository;
    }

    @Override
    public int adicionaNovaLista(String descritor) {
        this.repository.save(new ListaDeCompra(descritor));
        return 0;
    }
}
