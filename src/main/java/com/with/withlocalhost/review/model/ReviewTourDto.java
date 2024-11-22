package com.with.withlocalhost.review.model;

import java.util.Date;

public class ReviewTourDto {

    private int tourId;
    private String guidName;
    private String title;
    private String tourContent;
    private Date startDate;
    private Date endDate;
    private int reservationPeople;
    private String reservationPay;
    private String reviewContent;
    private int reviewScore;

    // 기본 생성자
    public ReviewTourDto() {}

    // 필요한 필드만 받는 생성자
    public ReviewTourDto(int tourId, String guidName, String title, String tourContent,
                               Date startDate, Date endDate, int reservationPeople,
                               String reservationPay, String reviewContent, int reviewScore) {
        this.tourId = tourId;
        this.guidName = guidName;
        this.title = title;
        this.tourContent = tourContent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationPeople = reservationPeople;
        this.reservationPay = reservationPay;
        this.reviewContent = reviewContent;
        this.reviewScore = reviewScore;
    }

    // Getter와 Setter
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getGuidName() {
        return guidName;
    }

    public void setGuidName(String guidName) {
        this.guidName = guidName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTourContent() {
        return tourContent;
    }

    public void setTourContent(String tourContent) {
        this.tourContent = tourContent;
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

    public String getReservationPay() {
        return reservationPay;
    }

    public void setReservationPay(String reservationPay) {
        this.reservationPay = reservationPay;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "ReservationTourDto{" +
                "tourId=" + tourId +
                ", guidName='" + guidName + '\'' +
                ", title='" + title + '\'' +
                ", tourContent='" + tourContent + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reservationPeople=" + reservationPeople +
                ", reservationPay='" + reservationPay + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewScore=" + reviewScore +
                '}';
    }
}
