package com.with.withlocalhost.review.model;

import java.util.Date;

import java.util.Date;

public class ReviewTourDto {

    private int tourId;
    private int reservationId;
    private String reservater;
    private Date startDate;
    private Date endDate;
    private int reservationPeople;
    private int reservationPay;
    private String reservationStatus;
    private String reviewContent;
    private double reviewScore;
    private double reviewAvg;

    // 기본 생성자
    public ReviewTourDto() {
    }

    // 모든 필드를 포함한 생성자
    public ReviewTourDto(int tourId, int reservationId, String reservater, Date startDate, Date endDate,
                         int reservationPeople, int reservationPay, String reservationStatus, 
                         String reviewContent, double reviewScore, double reviewAvg) {
        this.tourId = tourId;
        this.reservationId = reservationId;
        this.reservater = reservater;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationPeople = reservationPeople;
        this.reservationPay = reservationPay;
        this.reservationStatus = reservationStatus;
        this.reviewContent = reviewContent;
        this.reviewScore = reviewScore;
        this.reviewAvg = reviewAvg;
    }

    // Getter와 Setter
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservater() {
        return reservater;
    }

    public void setReservater(String reservater) {
        this.reservater = reservater;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getReservationPeople() {
        return reservationPeople;
    }

    public void setReservationPeople(int reservationPeople) {
        this.reservationPeople = reservationPeople;
    }

    public int getReservationPay() {
        return reservationPay;
    }

    public void setReservationPay(int reservationPay) {
        this.reservationPay = reservationPay;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public double getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(double reviewScore) {
        this.reviewScore = reviewScore;
    }

    public double getReviewAvg() {
        return reviewAvg;
    }

    public void setReviewAvg(double reviewAvg) {
        this.reviewAvg = reviewAvg;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "ReviewTourDto{" +
                "tourId=" + tourId +
                ", reservationId=" + reservationId +
                ", reservater='" + reservater + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reservationPeople=" + reservationPeople +
                ", reservationPay=" + reservationPay +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewScore=" + reviewScore +
                ", reviewAvg=" + reviewAvg +
                '}';
    }
}
