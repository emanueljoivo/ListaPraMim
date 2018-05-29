package _errormessages;

import enums.ItemErrors;

/**
 * Implementação da classe que retorna as mensagens de um possível erro ao tentar cadastrar um item.
 * @author lucas
 */

public class ItemExceptionMessage implements ExceptionMessage {
	
	private ItemErrors itemErrors;
	
	/**
	 * Construtor de ItemExceptionMessage, que inicialmente, deixa itemErrors nulo.
	 */
	public ItemExceptionMessage() {
		itemErrors = null;
	}

	/**
	 * See {@link _errormessages.ExceptionMessage#getMessage()}
	 */
	@Override
	public String getMessage() {
		if (itemErrors != null) {
			switch (itemErrors) {
			case CATEGORIA_INVALIDA:
				return "Erro no cadastro de item: categoria nao pode ser vazia ou nula";
			case NOME_INVALIDO:
				return "Erro no cadastro de item: nome nao pode ser vazio ou nulo";
			case UNIDADE_INVALIDA:
				return "Erro no cadastro de item: valor de unidade nao pode ser menor que zero";
			case QUILO_INVALIDO:
				return "Erro no cadastro de item: valor de quilos nao pode ser menor que zero";
			case QUANTIDADE_INVALIDA:
				return "Erro no cadastro de item: valor de quantidade nao pode ser menor que zero";
			case UNIDADE_DE_MEDIDA_INVALIDA:
				return "Erro no cadastro de item: valor de unidade de medida nao pode ser menor que zero";
			}
		}
		
		return null;
	}

	/**
	 * See {@link _errormessages.ExceptionMessage#setEnum(Enum)}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setEnum(Enum e) {
		itemErrors = (ItemErrors) e;
	}
}
