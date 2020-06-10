package cn.edu.bitzh.tp.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.edu.bitzh.tp.dao.ProduceRequestDao;

public class ProduceRequestDaoImpl extends HibernateDaoSupport implements ProduceRequestDao {

	Session session = null;
	Transaction transaction = null;
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	
	
	
	
	
	@Override
	public int save() {
		
		
		System.out.println(" ProduceRequestDao start\n");
		// TODO Auto-generated method stub
		return 0;
	}









	
	
	
	
	

}
