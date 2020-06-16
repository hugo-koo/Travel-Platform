package cn.edu.bitzh.tp.controller;

import java.util.List;

import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.service.IRegionService;

/**
* @author 古学懂_Victor
*/
public interface IRegionController {
	/**
	 * 
	 * @author 古学懂_Victor
	 * @return List 大洲
	 */
	public List<Region> listContineins();
	/**
	 * 
	 * @author 古学懂_Victor
	 * @param pid
	 * @return
	 * @see IRegionService
	 */
	public List<Region> listChildRegions(int pid);
}
