package cn.edu.bitzh.tp.dao;

import java.util.List;

import cn.edu.bitzh.tp.model.Region;

/**
 * 
* @author 古学懂_Victor
*/
public interface IRegionDao {
	/**
	 * 根据id返回地区
	 * @author 古学懂_Victor
	 * @param id
	 * @return
	 */
	Region getRegionById(int id);
	/**
	 * 根据父id列出子地区列表
	 * @author 古学懂_Victor
	 * @param pid
	 * @return List 子地区列表
	 */
	List<Region> listChildRegions(int pid);
}
