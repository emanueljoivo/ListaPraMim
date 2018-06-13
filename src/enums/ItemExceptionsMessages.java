package enums;

/**
 * Enum de mensagens de erro para exceções que ocorrem com itens.
 * 
 * @author lucas
 *
 */
public enum ItemExceptionsMessages {
	ERRO_CADASTRO("Erro no cadastro de item: "),
	ERRO_ATUALIZACAO("Erro na atualizacao de item: "),
	ERRO_LISTAGEM("Erro na listagem de itens: "),
	ERRO_PESQUISA("Erro na pesquisa de itens: "),
	ERRO_EXCLUSAO("Erro na exclusao de item: "),

	ATRIBUTO_INVALIDO("atributo nao existe."),
	ATRIBUTO_INVALIDO_VN("atributo nao pode ser vazio ou nulo."),
	CATEGORIA_INVALIDA_VN("categoria nao pode ser vazia ou nula."),
	CATEGORIA_INVALIDA("categoria nao existe."),
	ID_INVALIDO("id invalido."),
	NOVO_VALOR_INVALIDO("novo valor de atributo nao pode ser vazio ou nulo."),
	ITEM_NOT_EXIST("item nao existe."),

	ATUALIZACAO_INVALIDA_ATRIBUTO(ERRO_ATUALIZACAO.errorMessage + ATRIBUTO_INVALIDO.errorMessage),
	ATUALIZACAO_INVALIDA_ID(ERRO_ATUALIZACAO.errorMessage + ID_INVALIDO.errorMessage),
	ATUALIZACAO_INVALIDA_ATRIBUTO_VN(ERRO_ATUALIZACAO.errorMessage + ATRIBUTO_INVALIDO_VN),
	ATUALIZACAO_INVALIDA_VALOR(ERRO_ATUALIZACAO.errorMessage + NOVO_VALOR_INVALIDO.errorMessage),

	CADASTRO_INVALIDO_NOME(ERRO_CADASTRO.errorMessage + "nome nao pode ser vazio ou nulo."),
	CADASTRO_INVALIDO_CATEGORIA(ERRO_CADASTRO.errorMessage + CATEGORIA_INVALIDA.errorMessage),
	CADASTRO_INVALIDO_UNIDADE(ERRO_CADASTRO.errorMessage + "valor de unidade nao pode ser menor que zero."),
	CADASTRO_INVALIDO_QUILO(ERRO_CADASTRO.errorMessage + "valor de quilos nao pode ser menor que zero."),
	CADASTRO_INVALIDO_QUANTIDADE(ERRO_CADASTRO.errorMessage + "valor de quantidade nao pode ser menor que zero."),
	CADASTRO_INVALIDO_UNI_DE_MEDIDA(ERRO_CADASTRO.errorMessage + "unidade de medida nao pode ser vazia ou nula."),
	CADASTRO_INVALIDO_ITEM_EXIST(ERRO_CADASTRO.errorMessage + "item ja existe."),
	CADASTRO_INVALIDO_ITEM_NOT_EXIST(ERRO_CADASTRO.errorMessage + "item nao existe."),

	PESQUISA_INVALIDA_STR(ERRO_PESQUISA.errorMessage + "palavra pesquisada nao pode ser vazia ou nula."),
	LISTAGEM_INVALIDA_CATEGORIA_VN(ERRO_LISTAGEM.errorMessage + CATEGORIA_INVALIDA_VN.errorMessage),
	LISTAGEM_INVALIDA_CATEGORIA(ERRO_LISTAGEM.errorMessage + CATEGORIA_INVALIDA.errorMessage),

	EXCLUSAO_INVALIDA_ID(ERRO_EXCLUSAO.errorMessage + ID_INVALIDO.errorMessage),

	NAO_CONTEM_ITEM(ITEM_NOT_EXIST.errorMessage);
	
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
