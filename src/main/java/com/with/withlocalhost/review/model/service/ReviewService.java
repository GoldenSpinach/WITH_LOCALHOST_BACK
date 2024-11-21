package com.with.withlocalhost.review.model.service;

import java.sql.SQLException;
import java.util.List;

import com.with.withlocalhost.review.model.ReviewDto;

public interface ReviewService {

	List<ReviewTourDto> myReviewList(String userId) throws SQLException;
	
	String modifyReviewList(ReviewDto reviewDto) throws SQLException;;
}
