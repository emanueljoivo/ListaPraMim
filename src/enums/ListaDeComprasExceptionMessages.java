package enums;

public enum ListaDeComprasExceptionMessages {

    DESCRITOR_INVALIDO("descritor nao pode ser vazio ou nulo."),
    QUANTIDADE_INVALIDA("quantidade invalida."),
    ITEM_ID_INVALIDO("item id invalido."),
    COMPRA_NAO_ENCONTRADA("compra nao encontrada na lista."),
    ITEM_NOT_EXIST("item nao existe no sistema."),

    ERRO_IMPRESSAO("Erro na impressao de compra: "),
    ERRO_COMPRA("Erro na compra de item: "),
    ERRO_ATUALIZACAO("Erro na atualizacao de compra: "),
    ERRO_EXCLUSAO("Erro na exclusao de compra: "),
    ERRO_PESQUISA("Erro na pesquisa de compra: "),
    ERRO_FINALIZACAO("Erro na finalizacao de lista de compras: "),
    ERRO_GERA_AUTOMATICO_RECENTE("Erro na geracao de lista automatica mais recente: "),
    ERRO_GERA_AUTOMATICO_POR_ITEM("Erro na geracao de lista automatica por item: "),
    ERRO_GERA_AUTOMATICO_ITENS_MAIS_PRESENTES("Erro na geracao de lista automatica por itens mais presentes: "),
    ERRO_PESQUISA_MELHOR_ESTABELECIMENTO("Erro ao pesquisar o melhor estabelecimento: "),

    CRIACAO_INVALIDA_DESCRITOR("Erro na criacao de lista de compras: " + DESCRITOR_INVALIDO.errorMessage),
    COMPRA_INVALIDA_DESCRITOR(ERRO_COMPRA.errorMessage + DESCRITOR_INVALIDO.errorMessage),
    COMPRA_INVALIDA_QUANTIDADE(ERRO_COMPRA.errorMessage + QUANTIDADE_INVALIDA.errorMessage),
    COMPRA_INVALIDA_ITEM(ERRO_COMPRA.errorMessage + ITEM_ID_INVALIDO.errorMessage),

    LISTA_NAO_ENCONTRADA(ERRO_COMPRA.errorMessage + "lista de compras ainda nao existe."),

    ATUALIZACAO_INVALIDA_DESCRITOR(ERRO_ATUALIZACAO.errorMessage + DESCRITOR_INVALIDO.errorMessage),
    ATUALIZACAO_INVALIDA_ITEM(ERRO_ATUALIZACAO.errorMessage + ITEM_ID_INVALIDO.errorMessage),
    ATUALIZACAO_INVALIDA_QUANTIDADE(ERRO_ATUALIZACAO.errorMessage + QUANTIDADE_INVALIDA.errorMessage),
    ATUALIZACAO_INVALIDA_COMPRA_NAO_ENCONTRADA(ERRO_ATUALIZACAO.errorMessage + COMPRA_NAO_ENCONTRADA.errorMessage),

    EXCLUSAO_INVALIDA_DESCRITOR(ERRO_EXCLUSAO.errorMessage + DESCRITOR_INVALIDO.errorMessage),
    EXCLUSAO_INVALIDA_ITEM(ERRO_EXCLUSAO.errorMessage + ITEM_ID_INVALIDO.errorMessage),
    EXCLUSAO_INVALIDA_COMPRA_NAO_ENCONTRADA(ERRO_EXCLUSAO.errorMessage + COMPRA_NAO_ENCONTRADA.errorMessage),

    COMPRA_JA_FEITA(ERRO_COMPRA.errorMessage + "compra ja adicionada."),

    PESQUISA_INVALIDA_COMPRA_NAO_ENCONTRADA(ERRO_PESQUISA.errorMessage + COMPRA_NAO_ENCONTRADA.errorMessage),
    PESQUISA_INVALIDA_DESCRITOR(ERRO_PESQUISA.errorMessage + DESCRITOR_INVALIDO.errorMessage),
    PESQUISA_INVALIDA_ITEM(ERRO_PESQUISA.errorMessage + ITEM_ID_INVALIDO.errorMessage),
    PESQUISA_INVALIDA_DATA_VN(ERRO_PESQUISA.errorMessage + "data nao pode ser vazia ou nula."),
    PESQUISA_INVALIDA_DATA(ERRO_PESQUISA.errorMessage + "data em formato invalido, tente dd/MM/yyyy"),

    FINALIZACAO_INVALIDA_DESCRITOR(ERRO_FINALIZACAO.errorMessage + DESCRITOR_INVALIDO.errorMessage),
    FINALIZACAO_INVALIDA_LOCAL(ERRO_FINALIZACAO.errorMessage + "local nao pode ser vazio ou nulo."),
    FINALIZACAO_INVALIDA_VALOR(ERRO_FINALIZACAO.errorMessage + "valor final da lista invalido."),
    NAO_HA_LISTAS_MAIS_RECENTE(ERRO_GERA_AUTOMATICO_RECENTE.errorMessage + "nenhuma lista de compras cadastrada com esse descritor."),
    NAO_HA_LISTAS_POR_ITEM(ERRO_GERA_AUTOMATICO_POR_ITEM.errorMessage + "nenhuma lista de compras cadastrada com esse descritor."),
    NAO_HA_LISTAS_ITENS_MAIS_RECENTES(ERRO_GERA_AUTOMATICO_ITENS_MAIS_PRESENTES.errorMessage + "nenhuma lista de compras cadastrada com esse descritor."),
	NAO_HA_COMPRA_POR_ITEM(ERRO_GERA_AUTOMATICO_POR_ITEM.errorMessage + "nao ha compras cadastradas com o item desejado."),
	NAO_HA_ITENS_CADASTRADOS_MAIS_PRESENTES(ERRO_GERA_AUTOMATICO_ITENS_MAIS_PRESENTES.errorMessage + "nao ha nenhum item que aparece em metade das listas cadastradas."),
	NAO_EXISTE_LISTA_PESQUISA_ESTABELECIMENTO(ERRO_PESQUISA_MELHOR_ESTABELECIMENTO.errorMessage + " nenhuma lista de compras cadastrada com esse descritor.");
	
	
    private String errorMessage;
    ListaDeComprasExceptionMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
