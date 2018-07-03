package enums;

/**
 * Enum de mensagens de erro para exceções que ocorrem com itens.
 * 
 * @author lucas & Emanuel Joivo.
 *
 */
public enum ItemExceptionsMessages {
	ERRO_CADASTRO("Erro no cadastro de item: "),
	ERRO_ATUALIZACAO("Erro na atualizacao de item: "),
	ERRO_LISTAGEM("Erro na listagem de item: "),
	ERRO_PESQUISA("Erro na pesquisa de itens: "),
	ERRO_EXCLUSAO("Erro na exclusao de item: "),
	ERRO_CADASTRO_PRECO("Erro no cadastro de preco: "),

	ATRIBUTO_INVALIDO("atributo nao existe."),
	ATRIBUTO_INVALIDO_VN("atributo nao pode ser vazio ou nulo."),
	CATEGORIA_INVALIDA_VN("categoria nao pode ser vazia ou nula."),
	CATEGORIA_INVALIDA("categoria nao existe."),
	ID_INVALIDO("id invalido."),
	NOVO_VALOR_INVALIDO("novo valor de atributo nao pode ser vazio ou nulo."),
	ITEM_NOT_EXIST("item nao existe."),

	ATUALIZACAO_INVALIDA_ATRIBUTO(ERRO_ATUALIZACAO.errorMessage + ATRIBUTO_INVALIDO.errorMessage),
	ATUALIZACAO_INVALIDA_ID(ERRO_ATUALIZACAO.errorMessage + ID_INVALIDO.errorMessage),
	ATUALIZACAO_INVALIDA_ATRIBUTO_VN(ERRO_ATUALIZACAO.errorMessage + ATRIBUTO_INVALIDO_VN.errorMessage),
	ATUALIZACAO_INVALIDA_VALOR(ERRO_ATUALIZACAO.errorMessage + NOVO_VALOR_INVALIDO.errorMessage),
	ATUALIZACAO_INVALIDA_ITEM_NOT_EXIST(ERRO_ATUALIZACAO.errorMessage + ITEM_NOT_EXIST.errorMessage),
	ATUALIZACAO_INVALIDA_CATEGORIA(ERRO_ATUALIZACAO.errorMessage + CATEGORIA_INVALIDA.errorMessage),
	ATUALIZACAO_INVALIDA_UNIDADE(ERRO_ATUALIZACAO.errorMessage + "valor de quantidade nao pode ser menor que zero."),
	ATUALIZACAO_INVALIDA_KG(ERRO_ATUALIZACAO.errorMessage + "valor de quilos nao pode ser menor que zero."),

	CADASTRO_INVALIDO_NOME(ERRO_CADASTRO.errorMessage + "nome nao pode ser vazio ou nulo."),
	CADASTRO_INVALIDO_CATEGORIA(ERRO_CADASTRO.errorMessage + CATEGORIA_INVALIDA.errorMessage),
	CADASTRO_INVALIDO_CATEGORIA_VN(ERRO_CADASTRO.errorMessage + CATEGORIA_INVALIDA_VN.errorMessage),
	CADASTRO_INVALIDO_UNIDADE(ERRO_CADASTRO.errorMessage + "valor de unidade nao pode ser menor que zero."),
	CADASTRO_INVALIDO_QUILO(ERRO_CADASTRO.errorMessage + "valor de quilos nao pode ser menor que zero."),
	CADASTRO_INVALIDO_QUANTIDADE(ERRO_CADASTRO.errorMessage + "valor de quantidade nao pode ser menor que zero."),
	CADASTRO_INVALIDO_UNI_DE_MEDIDA(ERRO_CADASTRO.errorMessage + "unidade de medida nao pode ser vazia ou nula."),
	CADASTRO_INVALIDO_ITEM_EXIST(ERRO_CADASTRO.errorMessage + "item ja existe."),
	CADASTRO_INVALIDO_LOCAL(ERRO_CADASTRO.errorMessage + "local de compra nao pode ser vazio ou nulo."),
	CADASTRO_INVALIDO_PRECO(ERRO_CADASTRO.errorMessage + "preco de item invalido."),
	CADASTRO_DE_PRECO_ID(ERRO_CADASTRO_PRECO.errorMessage + "id de item invalido."),
	CADASTRO_DE_PRECO_LOCAL(ERRO_CADASTRO_PRECO.errorMessage + "local de compra nao pode ser vazio ou nulo."),
	CADASTRO_DE_PRECO_PRECO(ERRO_CADASTRO_PRECO.errorMessage + "preco de item invalido."),
    CADASTRO_DE_PRECO_ITEM_NOT_EXIST(ERRO_CADASTRO_PRECO.errorMessage + ITEM_NOT_EXIST.errorMessage),

	PESQUISA_INVALIDA_STR(ERRO_PESQUISA.errorMessage + "palavra pesquisada nao pode ser vazia ou nula."),
	PESQUISA_INVALIDA_CATEGORIA(ERRO_PESQUISA.errorMessage + CATEGORIA_INVALIDA.errorMessage),
	PESQUISA_INVALIDA_POSICAO(ERRO_PESQUISA.errorMessage + "posicao invalida."),
	PESQUISA_INVALIDA_ITEM_NOT_EXIST(ERRO_PESQUISA.errorMessage + ITEM_NOT_EXIST.errorMessage),
	LISTAGEM_INVALIDA_CATEGORIA_VN(ERRO_LISTAGEM.errorMessage + CATEGORIA_INVALIDA_VN.errorMessage),
	LISTAGEM_INVALIDA_CATEGORIA(ERRO_LISTAGEM.errorMessage + CATEGORIA_INVALIDA.errorMessage),
	LISTAGEM_INVALIDA_ITEM_NOT_EXIST(ERRO_LISTAGEM.errorMessage + ITEM_NOT_EXIST.errorMessage),
	LISTAGEM_INVALIDA_ID(ERRO_LISTAGEM.errorMessage + ID_INVALIDO.errorMessage),

	EXCLUSAO_INVALIDA_ID(ERRO_EXCLUSAO.errorMessage + ID_INVALIDO.errorMessage),
	EXCLUSAO_INVALIDA_ITEM_NOT_EXIST(ERRO_EXCLUSAO.errorMessage + ITEM_NOT_EXIST.errorMessage);

	private String errorMessage;
	
	ItemExceptionsMessages(String erroMessage) {
		this.errorMessage = erroMessage;
	}
	
	/**
	 * Método para pegar o valor do enum, que funciona como um index.
	 * 
	 * @return representação em string de uma mensagem de exceção.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
}
