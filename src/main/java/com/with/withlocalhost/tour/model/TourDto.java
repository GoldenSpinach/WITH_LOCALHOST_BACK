package com.with.withlocalhost.tour.model;

import java.util.List;

import com.with.withlocalhost.review.model.ReviewDto;

public class TourDto {
    private int tourId; // 투어 ID
    private String title; // 제목
    private String content;
    private int peopleCnt; // 인원 수
    private int pay; // 비용
    private String notice; // 공지사항
    private String meetLongitude; // 만남 장소 경도
    private String meetLatitude; // 만남 장소 위도
    private String meetAddress; // 만남 장소 주소
    private String mainImgUrl; // 메인 이미지 URL
    private String guidName; // 가이드 이름
    private double reviewAvg; // 평균 리뷰 점수

    private List<CategoryDto> categorys; // 카테고리 리스트
    private List<OptionDto> options; // 옵션 리스트
    private List<ActivityDto> activities; // 활동 리스트
    private List<ReviewDto> reviews;

    // 기본 생성자
    public TourDto() {}

    // 모든 필드를 포함한 생성자
    public TourDto(int tourId, String title, String content,int peopleCnt, int pay, String notice, String meetLongitude,
            String meetLatitude, String meetAddress, String mainImgUrl, String guidName, double reviewAvg,
            List<CategoryDto> categorys, List<OptionDto> options, List<ActivityDto> activities , List<ReviewDto> reviews) {
        this.tourId = tourId;
        this.title = title;
        this.content = content;
        this.peopleCnt = peopleCnt;
        this.pay = pay;
        this.notice = notice;
        this.meetLongitude = meetLongitude;
        this.meetLatitude = meetLatitude;
        this.meetAddress = meetAddress;
        this.mainImgUrl = mainImgUrl;
        this.guidName = guidName;
        this.reviewAvg = reviewAvg;
        this.categorys = categorys;
        this.options = options;
        this.activities = activities;
        this.reviews = reviews;
    }

    // Getter와 Setter
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
    	return content;
    }
    public void setContent(String content) {
    	this.content = content;
    }
    public int getPeopleCnt() {
        return peopleCnt;
    }

    public void setPeopleCnt(int peopleCnt) {
        this.peopleCnt = peopleCnt;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getMeetLongitude() {
        return meetLongitude;
    }

    public void setMeetLongitude(String meetLongitude) {
        this.meetLongitude = meetLongitude;
    }

    public String getMeetLatitude() {
        return meetLatitude;
    }

    public void setMeetLatitude(String meetLatitude) {
        this.meetLatitude = meetLatitude;
    }

    public String getMeetAddress() {
        return meetAddress;
    }

    public void setMeetAddress(String meetAddress) {
        this.meetAddress = meetAddress;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public String getGuidName() {
        return guidName;
    }

    public void setGuidName(String guidName) {
        this.guidName = guidName;
    }

    public double getReviewAvg() {
        return reviewAvg;
    }

    public void setReviewAvg(double reviewAvg) {
        this.reviewAvg = reviewAvg;
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

    public List<ActivityDto> getActivitys() {
        return activities;
    }

    public void setActivitys(List<ActivityDto> activitys) {
        this.activities = activitys;
    }

    
    
    
    public List<ActivityDto> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityDto> activities) {
		this.activities = activities;
	}

	public List<ReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDto> reviews) {
		this.reviews = reviews;
	}

	// toString() 메서드 (디버깅 및 로그용)
    @Override
    public String toString() {
        return "TourDto{" +
                "tourId=" + tourId +
                ", title='" + title + '\'' +
                ", peopleCnt=" + peopleCnt +
                ", pay=" + pay +
                ", notice='" + notice + '\'' +
                ", meetLongitude='" + meetLongitude + '\'' +
                ", meetLatitude='" + meetLatitude + '\'' +
                ", meetAddress='" + meetAddress + '\'' +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", guidName='" + guidName + '\'' +
                ", reviewAvg=" + reviewAvg +
                ", categorys=" + categorys +
                ", options=" + options +
                ", activitys=" + activities +
                '}';
    }
}
