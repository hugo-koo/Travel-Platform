package cn.edu.bitzh.tp.dao;

import java.util.List;

import cn.edu.bitzh.tp.model.Scenery;
import cn.edu.bitzh.tp.model.SceneryContent;

public interface ISceneryDao /*extends IBaseDao<Scenery>*/{
	Scenery searchScenery(int id);
	
	List<Scenery> listBy(String wheresql);
	
	int insertScenery(Scenery scenery);
}
