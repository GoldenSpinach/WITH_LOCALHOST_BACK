package com.with.withlocalhost.review.model.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.with.withlocalhost.review.model.ReviewDto;
import com.with.withlocalhost.review.model.ReviewTourDto;

@Mapper
public interface ReviewRepository {
	
	List<ReviewTourDto> myReviewList(String userId) throws SQLException;
	
	int modifyReviewList(ReviewDto reviewDto) throws SQLException;
	
}
