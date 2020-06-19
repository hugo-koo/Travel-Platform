package cn.edu.bitzh.tp.dao;

import java.util.List;

/**
 * 
 * @author 古学懂_Victor
 * @param <T>
 */
public interface IBaseDao<T> {
	public int insertOrUpdate(T t);

	public boolean update(T t);

	public boolean delete(int id);

	public T get(int id);

	public List<T> list();

}
