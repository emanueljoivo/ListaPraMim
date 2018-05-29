package _errormessages;

import enums.MensagensDeErro;

public class ItemExceptionMessage implements MensagemDeErro {

	@Override
	public String getMessage(MensagensDeErro msgs) {
		switch (msgs) {
		case CATEGORIA_INVALIDA:
			return "Erro no cadastro de item: categoria nao pode ser vazia ou nula";
		case NOME_INVALIDO:
			return "Erro no cadastro de item: nome nao pode ser vazio ou nulo";
		case QUILO_INVALIDO:
			return "Erro no cadastro de item: valor de quilos nao pode ser menor que zero";
		case QUANTIDADE_INVALIDA:
			return "Erro no cadastro de item: valor de quantidade nao pode ser menor que zero";
		}
		return null;
	}
}
