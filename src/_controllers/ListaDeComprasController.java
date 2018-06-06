package _controllers;

import _services.ListaDeComprasService;
import validation.ValidatorListaDeCompras;

public class ListaDeComprasController {

    private ValidatorListaDeCompras validator;
    private ListaDeComprasService service;

    public ListaDeComprasController(ValidatorListaDeCompras validator, ListaDeComprasService service) {
        this.validator = validator;
        this.service = service;
    }

    public int adicionaListaDeCompras(String descritor) {
        this.validator.validaDescritor(descritor);
        return this.service.adicionaNovaLista(descritor);
    }

}
