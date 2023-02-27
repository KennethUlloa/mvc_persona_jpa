package modelo.dao;

import java.util.List;

public interface GenericDAO<T,K> {
	void create(T obj);
	void update(T obj);
	void delete(K id);
	T getById(K id);
	List<T> getAll();
}
