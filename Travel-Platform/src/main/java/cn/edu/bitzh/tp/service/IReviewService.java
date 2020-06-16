package cn.edu.bitzh.tp.service;

import java.util.List;

import cn.edu.bitzh.tp.model.Review;

/**
 * @author 陈君锐
 */
public interface IReviewService {
	int publishReview(Review review);
	
	boolean deleteReview(int id);
	
	List<Review> listByScenery(int id);
	
	List<Review> listByUser(int id);
}
