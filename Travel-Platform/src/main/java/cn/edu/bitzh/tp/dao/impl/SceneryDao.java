package cn.edu.bitzh.tp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bitzh.tp.dao.ISceneryDao;
import cn.edu.bitzh.tp.model.Scenery;

@Repository("ISceneryDao")
public class SceneryDao implements ISceneryDao {
	Session session = null;
	Transaction transaction = null;
	@Autowired
	SessionFactory sessionFactory;
	
	public Scenery searchScenery(int id){
		try{
			session = sessionFactory.openSession();
			//Scenery s = sessionFactory.getCurrentSession().createQuery("from SceneryContent where scenery_id = '" + id + "'");
			Scenery s = session.get(Scenery.class, id);
			//scenerys = query.list();
			return s;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}
	
	public List<Scenery> listBy(String wheresql){
		List<Scenery> scenerys;
		Query<Scenery> query;
		try{
			session = sessionFactory.openSession();
			query = session.createQuery(wheresql);
			scenerys = query.list();
			if (scenerys.isEmpty())
				return null;
			return scenerys;
		}catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}
	
	public int insertScenery(Scenery scenery){
		/*
		try{
			sessionFactory.getCurrentSession().persist(scenery);
			return scenery;
		}catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}*/
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			scenery.getSceneryContent().setScenery(scenery);
			int num = Integer.parseInt(session.save(scenery).toString());
			session.save(scenery.getSceneryContent());
			transaction.commit();
			return num;
		} catch (Exception x) {
			x.printStackTrace();
			return 0;
		} finally {
			sessionFactory.close();
		}
	}
}
