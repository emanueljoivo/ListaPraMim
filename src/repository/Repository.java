package repository;

public interface Repository<T> {
	
	public void save(T o);
	
	public boolean delete(long id);
	
	public T read(long id);

}
