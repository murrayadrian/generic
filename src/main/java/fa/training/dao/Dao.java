package fa.training.dao;

import java.util.List;

public interface Dao<T> {
	
	void save(T t);
	
	T getById(int id);
	
	List<T> getAll();
	
	T updateById(int id);
	
	void deleteById(int id);
}
