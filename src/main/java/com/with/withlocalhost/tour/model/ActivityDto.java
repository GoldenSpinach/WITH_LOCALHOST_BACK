package com.with.withlocalhost.tour.model;

public class ActivityDto {
    private int actId;            // 활동 ID
    private int tourId;           // 투어 ID
    private int categoryId;       // 카테고리 ID
    private String actName;       // 활동 이름
    private String actContents;   // 활동 내용
    private String actAddress;    // 활동 주소
    private Double actLatitude;   // 활동 위도
    private Double actLongitude;  // 활동 경도
    private String actImgUrl;
    private String activityName;  // 카테고리 이름 (변경된 필드)
    private String activityType;  // 카테고리 타입 (변경된 필드)

    // 기본 생성자
    public ActivityDto() {}

    // 모든 필드를 받는 생성자
    public ActivityDto(int actId, int tourId, int categoryId, String actName, String actContents, 
                       String actAddress, Double actLatitude, Double actLongitude, 
                       String activityName, String activityType , String actImgUrl) {  // 수정된 생성자 파라미터 이름
        this.actId = actId;
        this.tourId = tourId;
        this.categoryId = categoryId;
        this.actName = actName;
        this.actContents = actContents;
        this.actAddress = actAddress;
        this.actLatitude = actLatitude;
        this.actLongitude = actLongitude;
        this.activityName = activityName;  // 수정된 필드
        this.activityType = activityType;  // 수정된 필드
        this.actImgUrl = actImgUrl;
    }

    // Getter 및 Setter 메서드
    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActContents() {
        return actContents;
    }

    public void setActContents(String actContents) {
        this.actContents = actContents;
    }

    public String getActAddress() {
        return actAddress;
    }

    public void setActAddress(String actAddress) {
        this.actAddress = actAddress;
    }

    public Double getActLatitude() {
        return actLatitude;
    }

    public void setActLatitude(Double actLatitude) {
        this.actLatitude = actLatitude;
    }

    public Double getActLongitude() {
        return actLongitude;
    }

    public void setActLongitude(Double actLongitude) {
        this.actLongitude = actLongitude;
    }

    public String getActivityName() {  // 수정된 getter
        return activityName;
    }

    public void setActivityName(String activityName) {  // 수정된 setter
        this.activityName = activityName;
    }

    public String getActivityType() {  // 수정된 getter
        return activityType;
    }

    public void setActivityType(String activityType) {  // 수정된 setter
        this.activityType = activityType;
    }

    public String getActImgUrl() {
		return actImgUrl;
	}

	public void setActImgUrl(String actImgUrl) {
		this.actImgUrl = actImgUrl;
	}

	// toString 메서드 - 객체의 상태를 문자열로 반환
    @Override
    public String toString() {
        return "ActivityDto{" +
                "actId=" + actId +
                ", tourId=" + tourId +
                ", categoryId=" + categoryId +
                ", actName='" + actName + '\'' +
                ", actContents='" + actContents + '\'' +
                ", actAddress='" + actAddress + '\'' +
                ", actLatitude=" + actLatitude +
                ", actLongitude=" + actLongitude +
                ", activityName='" + activityName + '\'' +  // 수정된 필드
                ", activityType='" + activityType + '\'' +  // 수정된 필드
                ", actImgUrl ='" + actImgUrl + '\'' +
                '}';
    }
}
