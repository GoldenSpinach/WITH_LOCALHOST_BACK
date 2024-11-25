package com.with.withlocalhost.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.with.withlocalhost.review.model.ReviewDto;
import com.with.withlocalhost.review.model.ReviewTourDto;
import com.with.withlocalhost.review.model.service.ReviewService;
import com.with.withlocalhost.tour.model.TourDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@Tag(name = "review API", description = "리뷰 관련 API")  // @Api 대신 @Tag 사용
@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:5173")
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
	public ResponseEntity<?> myReviewList(HttpServletRequest request , @PathVariable("userId") String userId) throws Exception{
		List<ReviewTourDto> reviewTourList = reviewService.myReviewList(userId);
		return ResponseEntity.ok(reviewTourList);
	}
	
	
	/*
	 * 리뷰 수정하기
	 */
	@Operation(summary = "review 수정", description = "")
	@PostMapping("/modify")
	public ResponseEntity<?> modifyReview(HttpServletRequest request ,@RequestBody ReviewDto reviewDto) throws Exception{
		String userId = (String) request.getAttribute("userId");
		System.out.println(reviewDto);
		reviewDto.setReservater(userId);
		return ResponseEntity.ok(reviewService.modifyReviewList(reviewDto));
	}
	
	/*
	 * 리뷰 삭제
	 */
	@Operation(summary="review 삭제 reservationId 만 넘겨도 삭제가능")
	@PostMapping("/delete")
	public ResponseEntity<?> delteReview(HttpServletRequest request ,@RequestParam int reviewId) throws Exception{
		return ResponseEntity.ok(reviewService.deleteReview(reviewId));
	}
	
	
}
