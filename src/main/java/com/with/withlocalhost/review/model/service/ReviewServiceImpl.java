package com.with.withlocalhost.review.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.review.model.ReviewDto;
import com.with.withlocalhost.review.model.ReviewTourDto;
import com.with.withlocalhost.review.model.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private ReviewRepository reviewRepository;
	
	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	@Override
	public List<ReviewTourDto> myReviewList(String userId) throws SQLException {
		
		return reviewRepository.myReviewList(userId);
	}

	@Override
	public String modifyReviewList(ReviewDto reviewDto) throws SQLException {
		// TODO Auto-generated method stub
		int result = reviewRepository.modifyReview(reviewDto);
		if(result>0) {
			return "success";
		}
		
		return "fail";
	}

	@Override
	public String deleteReview(int reviewId) throws SQLException {
		int result = reviewRepository.delteReview(reviewId);
		if(result>0) {
			return "success";
		}
		return "fail";
	}

}
