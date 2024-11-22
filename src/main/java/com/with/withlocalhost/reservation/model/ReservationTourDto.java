package com.with.withlocalhost.reservation.model;

import java.util.Date;
import java.util.List;

import com.with.withlocalhost.review.model.ReviewDto;
import com.with.withlocalhost.tour.model.ActivityDto;
import com.with.withlocalhost.tour.model.CategoryDto;
import com.with.withlocalhost.tour.model.OptionDto;

public class ReservationTourDto {

    private int tourId;
    private String guidName;
    private String title;
    private String tourContent;
    private int peopleCnt;
    private String mainImgUrl;
    private String reservater;
    private Date startDate;
    private Date endDate;
    private int reservationPeople;
    private String reservationPay;
    private String reservationStatus;

    private List<CategoryDto> categorys;
    private List<OptionDto> options;
    private List<ReviewDto> reviews;

    // 기본 생성자
    public ReservationTourDto() {}

    // 모든 필드를 받는 생성자
    public ReservationTourDto(int tourId, String guidName, String title, String tourContent, int peopleCnt,
                          String mainImgUrl, String reservater, Date startDate, Date endDate, int reservationPeople,
                          String reservationPay, String reservationStatus, List<CategoryDto> categorys,
                          List<OptionDto> options, List<ReviewDto> reviews) {
        this.tourId = tourId;
        this.guidName = guidName;
        this.title = title;
        this.tourContent = tourContent;
        this.peopleCnt = peopleCnt;
        this.mainImgUrl = mainImgUrl;
        this.reservater = reservater;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationPeople = reservationPeople;
        this.reservationPay = reservationPay;
        this.reservationStatus = reservationStatus;
        this.categorys = categorys;
        this.options = options;
        this.reviews = reviews;
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

    public int getPeopleCnt() {
        return peopleCnt;
    }

    public void setPeopleCnt(int peopleCnt) {
        this.peopleCnt = peopleCnt;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
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

    public String getReservationPay() {
        return reservationPay;
    }

    public void setReservationPay(String reservationPay) {
        this.reservationPay = reservationPay;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public List<CategoryDto> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<CategoryDto> categorys) {
        this.categorys = categorys;
    }

    public List<OptionDto> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDto> options) {
        this.options = options;
    }

    public List<ReviewDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDto> reviews) {
        this.reviews = reviews;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "ReservationDto{" +
                "tourId=" + tourId +
                ", guidName='" + guidName + '\'' +
                ", title='" + title + '\'' +
                ", tourContent='" + tourContent + '\'' +
                ", peopleCnt=" + peopleCnt +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", reservater='" + reservater + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reservationPeople=" + reservationPeople +
                ", reservationPay='" + reservationPay + '\'' +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", categorys=" + categorys +
                ", options=" + options +
                ", reviews=" + reviews +
                '}';
    }
}
