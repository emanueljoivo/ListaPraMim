package _repositories;

public interface Repository<T> {
	
	void save(T o);
	
	boolean delete(int id);
	
	T read(int id);
	
	boolean contains(int id);

}
