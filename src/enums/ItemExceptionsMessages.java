package enums;

/**
 * Enum de mensagens de erro para exceções que ocorrem com itens.
 * 
 * @author lucas
 *
 */
public enum ItemExceptionsMessages {
	NOME_INVALIDO("Erro no cadastro de item: nome nao pode ser vazio ou nulo."),
	CATEGORIA_INVALIDA("Erro no cadastro de item: categoria nao pode ser vazia ou nula."),
	CATEGORIA_VALOR_INVALIDO("Erro no cadastro de item: o valor de categoria nao eh valido."),
	UNIDADE_INVALIDA("Erro no cadastro de item: valor de unidade nao pode ser menor que zero."),
	QUILO_INVALIDO("Erro no cadastro de item: valor de quilos nao pode ser menor que zero."),
	QUANTIDADE_INVALIDA("Erro no cadastro de item: valor de quantidade nao pode ser menor que zero."),
	UNIDADE_DE_MEDIDA_INVALIDA("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula."),
	CONTEM_ITEM("Erro no cadastro de item: item já existe."),
	NAO_CONTEM_ITEM("Item nao existe."),
	ATRIBUTO_INVALIDO("Atributo invalido.");
	
	private String value;
	
	ItemExceptionsMessages(String value) {
		this.value = value;
	}
	
	/**
	 * Método para pegar o valor do enum, que funciona como um index.
	 * 
	 * @return representação em string de uma mensagem de exceção.
	 */
	public String getErrorMessage() {
		return value;
	}
}
