package cn.edu.bitzh.tp.service;

import java.util.List;

import cn.edu.bitzh.tp.dao.IRegionDao;
import cn.edu.bitzh.tp.model.Region;

/**
* @author 古学懂_Victor
*/
public interface IRegionService {
	/**
	 * 根据id返回地区
	 * @author 古学懂_Victor
	 * @param id
	 * @return
	 * @see IRegionDao
	 */
	Region get(int id);
	/**
	 * 根据父id列出子地区列表
	 * @author 古学懂_Victor
	 * @param pid
	 * @return List 子地区列表
	 * @see IRegionDao
	 */
	List<Region> listChildRegions(int pid);
	/**
	 * 需获取第1级地区（大洲），pid置0
	 * @author 古学懂_Victor
	 * @param pid
	 * @return List 子地区列表
	 * @see IRegionDao
	 */
	List<Region> listContineins();
}
