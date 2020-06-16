package cn.edu.bitzh.tp.service;

import java.util.List;

/**
 * @author 古学懂_Victor
 */
public interface IBaseService<T> {
	public int insert(T t);

	public boolean update(T t);

	public boolean delete(int id);

	public T get(int id);

	public List<T> list();
	
	public List<T> listBy(int type, Object value);

}