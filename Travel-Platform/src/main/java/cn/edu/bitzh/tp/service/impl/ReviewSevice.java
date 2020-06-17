package cn.edu.bitzh.tp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bitzh.tp.dao.IReviewDao;
import cn.edu.bitzh.tp.model.Review;
import cn.edu.bitzh.tp.service.IReviewService;

@Service
public class ReviewSevice implements IReviewService {

	@Autowired
	IReviewDao reviewDao;
	
	@Override
	public int publishReview(Review review) {
		// TODO Auto-generated method stub
		return reviewDao.insertReview(review);

	}
	
	@Override
	public boolean deleteReview(int id) {
		return true;
	}

	@Override
	public List<Review> listByScenery(int id) {
		String wheresql = ("from Review where scenery_review_id ='" + id + "' order by scenery_review_time desc");
		return reviewDao.listBy(wheresql);

	}

	@Override
	public List<Review> listByUser(int id) {
		String wheresql = ("from Review where user_review_id ='" + id + "' order by scenery_review_time desc");
		return reviewDao.listBy(wheresql);
	}

}
