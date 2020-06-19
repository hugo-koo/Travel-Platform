package cn.edu.bitzh.tp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bitzh.tp.dao.IReviewDao;
import cn.edu.bitzh.tp.model.Review;
import cn.edu.bitzh.tp.model.Scenery;

@Repository("IReviewDao")
public class ReviewDao implements IReviewDao {
	Session session = null;
	Transaction transaction = null;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int insertReview(Review review) {
		/*try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			note.getNoteDtl().setNote(note);
			int num = Integer.parseInt(session.save(note).toString());
			session.save(note.getNoteDtl());
			transaction.commit();
			return num;
		} catch (Exception x) {
			x.printStackTrace();
			return 0;
		} finally {
			sessionFactory.close();
		}*/
		return 0;
	}

	@Override
	public boolean deleteReview(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Review> listBy(String wheresql) {
		/*List<Review> reviews;
		Query<Review> query;
		try{
			session = sessionFactory.openSession();
			query = session.createQuery(wheresql);
			reviews = query.list();
			if (reviews.isEmpty())
				return null;
			return reviews;
		}catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}*/
		return null;
	}

}
