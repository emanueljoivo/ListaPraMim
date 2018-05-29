package enums;

/**
 * Enum de mensagens de erro para exceções que ocorrem com itens.
 * 
 * @author lucas
 *
 */
public enum ItemException {
	NOME_INVALIDO(0), CATEGORIA_INVALIDA(1), UNIDADE_INVALIDA(2), QUILO_INVALIDO(3),
	QUANTIDADE_INVALIDA(4), UNIDADE_DE_MEDIDA_INVALIDA(5);
	
	private int value;
	
	ItemException(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
