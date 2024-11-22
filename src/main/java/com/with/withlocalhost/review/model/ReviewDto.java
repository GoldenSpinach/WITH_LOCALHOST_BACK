package com.with.withlocalhost.review.model;

public class ReviewDto {
	private String reservater;
	
	private int reservationId;	   // 리뷰 id
    private String reviewContent; // 리뷰 내용
    private Double reviewScore;   // 리뷰 점수
    
    // 기본 생성자
    public ReviewDto() {
    }
    
    // 전체 필드를 초기화하는 생성자
    public ReviewDto(String reservater,int reservationId ,String reviewContent, Double reviewScore) {
    	this.reservater = reservater;
    	this.reservationId = reservationId;
    	this.reviewContent = reviewContent;
        this.reviewScore = reviewScore;
    }
    
    public String getReservater() {
    	return reservater;
    }
    public void setReservater(String reservater) {
    	this.reservater = reservater;
    }
    
    public int getReservationId() {
    	return reservationId;
    }
    public void setReservationId(int reservationId) {
    	this.reservationId = reservationId;
    }
    
    // reviewContent의 getter와 setter
    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    // reviewScore의 getter와 setter
    public Double getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Double reviewScore) {
        this.reviewScore = reviewScore;
    }

    // toString() 메서드
    @Override
    public String toString() {
        return "ReviewDto{" +
        		"reservationId='" + reservationId + '\'' +
                "reviewContent='" + reviewContent + '\'' +
                ", reviewScore=" + reviewScore +
                '}';
    }
}

