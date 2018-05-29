package enums;

/**
 * Enum de mensagens de erro para exceções que ocorrem com itens.
 * 
 * @author lucas
 *
 */
public enum ItemException {
	NOME_INVALIDO("Erro no cadastro de item: nome nao pode ser vazio ou nulo"),
	CATEGORIA_INVALIDA("Erro no cadastro de item: categoria nao pode ser vazia ou nula"),
	UNIDADE_INVALIDA("Erro no cadastro de item: valor de unidade nao pode ser menor que zero"),
	QUILO_INVALIDO("Erro no cadastro de item: valor de quilos nao pode ser menor que zero"),
	QUANTIDADE_INVALIDA("Erro no cadastro de item: valor de quantidade nao pode ser menor que zero"),
	UNIDADE_DE_MEDIDA_INVALIDA("Erro no cadastro de item: valor de unidade de medida nao pode ser menor que zero");
	
	private String value;
	
	ItemException(String value) {
		this.value = value;
	}
	
	/**
	 * Método para pegar o valor do enum, que funciona como um index.
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}
}
