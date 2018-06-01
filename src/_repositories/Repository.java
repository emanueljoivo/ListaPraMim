package _repositories;

/**
 * Interface que define contrato de CRUD básico no qual
 * qualquer repositorio do sistema deve oferecer para 
 * comunicação com banco de dados.
 *
 * @author Emanuel Joivo
 *
 * @param <T> 
 */
public interface Repository<T> {
	
	/**
	 * Salva uma entidade no banco de dados.
	 * @return O método retorna <code> true </code> caso o item seja salvo com sucesso e <code>false</code> no caso
	 * contrário.
	 */
	boolean save(T o);
	
	/**
	 * Deleta uma entidade do banco de dados pelo id.
	 * @return O método retorna <code> true </code> caso o item seja deletado com sucesso e <code>false</code>
	 * no caso contrário.
	 */
	boolean delete(int id);
	
	/**
	 * Recupera uma entidade do banco de dados pelo id.
	 * @return O método retorna um objeto T caso o encontre pelo seu identificador e retorna <code>null</code> caso não
	 * encontre.
	 */
	T recovery(int id);
	
	/**
	 * Verifica se um dado objeto está contido a partir do identificador único.
	 * @return O método retorna <code>true</code> caso haja objeto como o referido id na base de dados e
	 * <code>false</code> no caso contrário.
	 */
	boolean contains(int id);

}
