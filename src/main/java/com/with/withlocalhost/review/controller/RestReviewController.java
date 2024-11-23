package com.with.withlocalhost.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.with.withlocalhost.review.model.ReviewDto;
import com.with.withlocalhost.review.model.ReviewTourDto;
import com.with.withlocalhost.review.model.service.ReviewService;
import com.with.withlocalhost.tour.model.TourDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "review API", description = "리뷰 관련 API")  // @Api 대신 @Tag 사용
@RestController
@RequestMapping("review")
public class RestReviewController {
	
	private final ReviewService reviewService;
	
	public RestReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	

	/*
	 * 내 리뷰 보기
	 */
	@Operation(summary = "my 리뷰 리스트 조회", description = "")
	@GetMapping("/{userId}")
	public ResponseEntity<?> myReviewList(@PathVariable("userId") String userId) throws Exception{
		List<ReviewTourDto> reviewTourList = reviewService.myReviewList(userId);
		return ResponseEntity.ok(reviewTourList);
	}
	
	
	/*
	 * 리뷰 수정하기
	 */
	@Operation(summary = "review 수정", description = "")
	@PostMapping("/reviewlist")
	public ResponseEntity<?> modifyReviewList(@RequestBody ReviewDto reviewDto) throws Exception{
		return ResponseEntity.ok(reviewService.modifyReviewList(reviewDto));
	}
	
	
}
