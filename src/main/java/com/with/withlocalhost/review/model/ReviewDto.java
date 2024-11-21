package com.with.withlocalhost.review.model;

public class ReviewDto {
    private String reservater;
    private String reviewContent; // 리뷰 내용
    private Double reviewScore;   // 리뷰 점수
    
    // 기본 생성자
    public ReviewDto() {
    }
    
    // 전체 필드를 초기화하는 생성자
    public ReviewDto(String reservator ,String reviewContent, Double reviewScore) {
        this.reservater = reservator;
    	this.reviewContent = reviewContent;
        this.reviewScore = reviewScore;
    }

    public String getReservator() {
    	return reservater;
    }
    
    public void setReservator(String reservator) {
    	this.reservater = reservator;
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
                "reviewContent='" + reviewContent + '\'' +
                ", reviewScore=" + reviewScore +
                '}';
    }
}

