package com.with.withlocalhost.review.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.review.model.ReviewDto;
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
		int result = reviewRepository.modifyReviewList(reviewDto);
		if(result>0) {
			return "success";
		}
		
		return "fail";
	}

}
