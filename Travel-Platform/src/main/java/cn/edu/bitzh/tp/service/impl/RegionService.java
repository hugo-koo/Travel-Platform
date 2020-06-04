package cn.edu.bitzh.tp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bitzh.tp.dao.IRegionDao;
import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.service.IRegionService;

/**
* @author 古学懂_Victor
*/
@Service
public class RegionService implements IRegionService {
	@Autowired
	IRegionDao rd;

	@Override
	public Region get(int id) {
		return rd.getRegionById(id);
	}

	@Override
	public List<Region> listChildRegions(int pid) {
		return rd.listChildRegions(pid);
	}

	@Override
	public List<Region> listContineins() {
		return rd.listChildRegions(0);
	}

	
}
