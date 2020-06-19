package cn.edu.bitzh.tp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bitzh.tp.model.Scenery;
import cn.edu.bitzh.tp.service.ISceneryService;
import cn.edu.bitzh.tp.dao.ISceneryDao;

@Service
public class SceneryService implements ISceneryService {

	@Autowired
	ISceneryDao sceneryDao;
	
	@Override
	public int publishScenery(Scenery scenery) {
		// TODO Auto-generated method stub
		return sceneryDao.insertScenery(scenery);
	}

	@Override
	public boolean updateScenery(Scenery scenery) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteScenery(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Scenery getDtl(int id) {
		return sceneryDao.searchScenery(id);
	}

	@Override
	public List<Scenery> listByRegion(int id) {
		String wheresql = ("from Scenery where scenery_ispublish ='true' and scenery_ischecked ='pass' and "
				+ "scenery_region ='" + id + "' order by scenery_publish_time desc");
		return sceneryDao.listBy(wheresql);
	}

	@Override
	public List<Scenery> list() {
		String wheresql = ("from Scenery where scenery_ispublish ='true' and scenery_ischecked ='pass' "
				+ "order by scenery_publish_time desc");
		return sceneryDao.listBy(wheresql);
	}

	@Override
	public List<Scenery> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
