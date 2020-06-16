package cn.edu.bitzh.tp.service.impl;

import cn.edu.bitzh.tp.dao.ProduceRequestDao;
import cn.edu.bitzh.tp.service.ProduceRequestService;

public class ProduceRequestServiceImpl implements ProduceRequestService {

	private ProduceRequestDao  produceRequestDao;
	
	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		
		
		System.out.println("ProduceRequestService start\n");
		produceRequestDao.save();
		
		return false;
		
		
		
		
	}

	public ProduceRequestDao getProduceRequestDao() {
		return produceRequestDao;
	}

	public void setProduceRequestDao(ProduceRequestDao produceRequestDao) {
		this.produceRequestDao = produceRequestDao;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
