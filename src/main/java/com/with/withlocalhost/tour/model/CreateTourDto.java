package com.with.withlocalhost.tour.model;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public class CreateTourDto {
    private int tourId;
    private String guidId;
    private String guidName;
    private String title;
    private String tourContent;
    private int peopleCnt;
    private int pay;
    private String notice;
    private String meetAddress;
    private String meetLatitude;
    private String meetLongitude;
    private String mainImgUrl;
    private int cityId;
    private int regionId;
    private int needDate;
    private MultipartFile img;
    private String imgName;
    private List<CategoryDto> categorys; // 카테고리 리스트
    private List<OptionDto> options; // 옵션 리스트
    private List<CreateActivityDto> activities; // 활동 리스트

    // 기본 생성자
    public CreateTourDto() {}

    // 모든 필드를 포함하는 생성자
    public CreateTourDto(int tourId, String guidId, String guidName, String title, String tourContent, int peopleCnt, int pay, String notice,
                         String meetAddress, String meetLatitude, String meetLongitude, String mainImgUrl, int cityId,
                         int regionId, int needDate, MultipartFile img, String imgName, List<CategoryDto> categorys,
                         List<OptionDto> options, List<CreateActivityDto> activities) {
        this.tourId = tourId;
        this.guidId = guidId;
        this.guidName = guidName;
        this.title = title;
        this.tourContent = tourContent;
        this.peopleCnt = peopleCnt;
        this.pay = pay;
        this.notice = notice;
        this.meetAddress = meetAddress;
        this.meetLatitude = meetLatitude;
        this.meetLongitude = meetLongitude;
        this.mainImgUrl = mainImgUrl;
        this.cityId = cityId;
        this.regionId = regionId;
        this.needDate = needDate;
        this.img = img;
        this.imgName = imgName;
        this.categorys = categorys;
        this.options = options;
        this.activities = activities;
    }

    public String getGuidId() {
    	return this.guidId;
    }
    
    public void setGuidId(String guidId) {
    	this.guidId = guidId;
    }
    
    // Getter와 Setter 메서드
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

    public String getMeetAddress() {
        return meetAddress;
    }

    public void setMeetAddress(String meetAddress) {
        this.meetAddress = meetAddress;
    }

    public String getMeetLatitude() {
        return meetLatitude;
    }

    public void setMeetLatitude(String meetLatitude) {
        this.meetLatitude = meetLatitude;
    }

    public String getMeetLongitude() {
        return meetLongitude;
    }

    public void setMeetLongitude(String meetLongitude) {
        this.meetLongitude = meetLongitude;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getNeedDate() {
        return needDate;
    }

    public void setNeedDate(int needDate) {
        this.needDate = needDate;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
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

    public List<CreateActivityDto> getActivities() {
        return activities;
    }

    public void setActivities(List<CreateActivityDto> activities) {
        this.activities = activities;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "CreateTourDto{" +
                "tourId=" + tourId +
                ", guidName='" + guidName + '\'' +
                ", title='" + title + '\'' +
                ", tourContent='" + tourContent + '\'' +
                ", peopleCnt=" + peopleCnt +
                ", pay=" + pay +
                ", notice='" + notice + '\'' +
                ", meetAddress='" + meetAddress + '\'' +
                ", meetLatitude='" + meetLatitude + '\'' +
                ", meetLongitude='" + meetLongitude + '\'' +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", cityId=" + cityId +
                ", regionId=" + regionId +
                ", needDate=" + needDate +
                ", img=" + img +
                ", imgName='" + imgName + '\'' +
                ", categorys=" + categorys +
                ", options=" + options +
                ", activities=" + activities +
                '}';
    }
}
