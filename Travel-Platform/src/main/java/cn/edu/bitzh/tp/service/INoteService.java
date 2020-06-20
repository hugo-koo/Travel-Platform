package cn.edu.bitzh.tp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bitzh.tp.dao.INoteDao;
import cn.edu.bitzh.tp.model.Note;

/**
 * @author 古学懂_Victor
 * @see INoteDao
 */
public interface INoteService extends IBaseService<Note> {
	/** Used for list all notes */
	public static final int ALL = 0;
	/** Used for query by author */
	public static final int AUTHOR = 1;
	public static final int DATE = 2;

	/**
	 * 插入游记
	 * 
	 * @author 古学懂_Victor
	 * @return 游记主键
	 */
	int insert(Note note);

	boolean delete(int id);

	/**
	 * 更新游记
	 * 
	 * @author 古学懂_Victor
	 * @param note
	 * @return boolean 成功与否
	 */
	boolean update(Note note);

	/**
	 * 根据条件获取游记列表
	 * 
	 * @author 古学懂_Victor
	 * @param type
	 * @param value
	 * @return
	 */
	List<Note> listBy(int type, Object value);

	/**
	 * 列出所有游记
	 * 
	 * @author 古学懂_Victor
	 * @return
	 */
	List<Note> listAllNotes();

	/**
	 * 根据ID获取游记
	 * 
	 * @author 古学懂_Victor
	 * @param id
	 * @return
	 */
	Note get(int id);

	List<Note> listHotestNotes();

	int like(HttpServletRequest request, HttpServletResponse response, int id);

}
