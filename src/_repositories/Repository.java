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
	 * @param o
	 */
	void save(T o);
	
	/**
	 * Deleta uma entidade do banco de dados pelo id.
	 * @param id
	 * @return
	 */
	boolean delete(int id);
	
	/**
	 * Recupera uma entidade do banco de dados pelo id.
	 * @param id
	 * @return
	 */
	T recovery(int id);
	
	/**
	 * Verifica se um dado objeto está contido a partir do id.
	 * @param id
	 * @return
	 */
	boolean contains(int id);

}
