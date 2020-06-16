package cn.edu.bitzh.tp.service;

import java.util.List;

import cn.edu.bitzh.tp.model.Scenery;
import cn.edu.bitzh.tp.dao.ISceneryDao;

/**
* @author 陈君锐
*/
public interface ISceneryService {
		
	int publishScenery(Scenery scenery);

	boolean updateScenery(Scenery scenery);
	
	boolean deleteScenery(int id);
	
	Scenery getDtl(int id);

	List<Scenery> listByRegion(int id);

	List<Scenery> list();
	
	List<Scenery> listAll();
}
