package cn.edu.bitzh.tp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bitzh.tp.dao.IRegionDao;
import cn.edu.bitzh.tp.model.Region;

/**
* @author 古学懂_Victor
*/
@Repository
public class RegionDao implements IRegionDao {
	Session session = null;
	Transaction transaction = null;
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Region get(int id) {
		try {
			session = sessionFactory.openSession();
			Region region = session.get(Region.class, id);
			return region;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public List<Region> listChildRegions(int pid) {
		List<Region> regions=null;
		Query<Region> q;
		try {
			session = sessionFactory.openSession();
			q = session.createQuery("select r from Region r where pid = :pid");
			q.setParameter("pid", pid);
			return q.list();
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public int insert(Region t) {
		return 0;
	}

	@Override
	public boolean update(Region t) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public List<Region> list() {
		return null;
	}

}
