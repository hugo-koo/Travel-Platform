package cn.edu.bitzh.tp.dao;

import java.util.List;

import cn.edu.bitzh.tp.model.Review;

/**
 * @author 陈君锐
 */
public interface IReviewDao {
	int insertReview(Review review);
	
	boolean deleteReview(int id);
	
	List<Review> listBy(String wheresql);
}
