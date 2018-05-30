package validation;

public interface ValidatorItem {
	
	/**
	 * Método que faz a validação dos dados de um item do tipo ItemPorUnidade
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item.
	 * @param unidade quantidade de items por unidade.
	 * @throws NullPointerException exceção lançada caso nome e categoria sejam strings nulas.
	 * @throws IllegalArgumentException exceção lançada caso nome e categoria sejam strings vazias,
	 * ou unidade for menor que zero.
	 */
	void validaItem(String nome, String categoria, int unidade) 
			throws NullPointerException, IllegalArgumentException;
	
	/**
	 * Método que faz a validação dos dados de um item do tipo ItemPorQuilo.
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item.
	 * @param kg valor em quilos do item.
	 * @throws NullPointerException exceção lançada caso nome e categoria sejam strings nulas.
	 * @throws IllegalArgumentException exceção lançada caso nome e categoria sejam strings vazias,
	 * ou kg for menor que zero.
	 */
	void validaItem(String nome, String categoria, double kg) 
			throws NullPointerException, IllegalArgumentException;
	
	/**
	 * Método que faz a validação dos dados de um item do tipo ItemPorQntdFixa
	 * 
	 * @param nome nome do item.
	 * @param categoria categoria do item.
	 * @param qtd quantidade de items desse tipo.
	 * @param unidadeDeMedida unidade de medida usada no cadastro.
	 * @throws NullPointerException exceção lançada caso nome, categoria 
	 * ou unidadeDeMedida sejam strings nulas.
	 * @throws IllegalArgumentException exceção lançada caso nome, categoria 
	 * ou unidadeDeMedida sejam strings vazias, ou qtd for menor que zero.
	 */
	void validaItem(String nome, String categoria, int qtd, String unidadeDeMedida) 
			throws NullPointerException, IllegalArgumentException;
}
