package validation;

import enums.ItemCategoria;
import enums.ItemException;

/**
 * Implementação da classe que valida os dados de itens compráveis do sistema.
 * 
 * @author lucas
 */

public class ValidatorItemImpl extends Validator implements ValidatorItem {
	
	/**
	 * Construtor de ValidatorItemImpl, que atribui valor ao atributo errorMessage, que é o responsável
	 * por definir qual mensagem de erro será mostrada.
	 */
	public ValidatorItemImpl() {}
	
	/**
	 * Método que verifica se o enum de categorias contém o valor passado pelo usuário.
	 * 
	 * @param categoria string passada pelo usuario.
	 * @return <code>true</code> se o valor existir no enum, <code>falso</code> senão.
	 */
	private boolean categoriaEhValida(String categoria) {
		
		ItemCategoria[] values = ItemCategoria.values();
		int i = 0;
		while ((values[i].getValue().equals(categoria.toLowerCase().trim())) && (i < values.length)) i++;
		
		return i < (values.length - 1);
	}
	
	/**
	 * Método que valida categoria e nome de um item (atributos gerais)
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item
	 * @throws NullPointerException exceção que será lançada caso algum dos dois seja nulo.
	 * @throws IllegalArgumentException exceção que será lançada caso algum dos dois seja vazio.
	 */
	private void validaCategoriaENome(String nome, String categoria) 
			throws NullPointerException, IllegalArgumentException {
		this.generalValidatorString(nome, ItemException.NOME_INVALIDO.getValue());
		this.generalValidatorString(categoria, ItemException.CATEGORIA_INVALIDA.getValue());
		
		if (!this.categoriaEhValida(categoria))
			throw new IllegalArgumentException(ItemException.CATEGORIA_VALOR_INVALIDO.getValue());
	}

	/**
	 * See {@link validation.ValidatorItem#validaItem(String, String, int)}
	 */
	@Override
	public void validaItem(String nome, String categoria, int unidade) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(unidade, ItemException.UNIDADE_INVALIDA.getValue());
	}
	
	/**
	 * See {@link validation.ValidatorItem#validaItem(String, String, double)}
	 */
	@Override
	public void validaItem(String nome, String categoria, double kg) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(kg, ItemException.QUILO_INVALIDO.getValue());
	}
	
	/**
	 * See {@link validation.ValidatorItem#validaItem(String, String, int, String)}
	 */
	@Override
	public void validaItem(String nome, String categoria, int qtd, String unidadeDeMedida) 
			throws NullPointerException, IllegalArgumentException {
		this.validaCategoriaENome(nome, categoria);
		this.generalValidatorNumber(qtd, ItemException.QUANTIDADE_INVALIDA.getValue());
		this.generalValidatorString(unidadeDeMedida, ItemException.UNIDADE_DE_MEDIDA_INVALIDA.getValue());
	}
}
