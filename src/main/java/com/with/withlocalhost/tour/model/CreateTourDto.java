package com.with.withlocalhost.tour.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CreateTourDto {
    private String guidName;
    private String title;
    private int peopleCnt;
    private int pay;
    private String notice;
    private String meet_address;
    private String meet_latitude;
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
    public CreateTourDto() {
    }

    // 모든 필드를 포함하는 생성자
    public CreateTourDto(String guidName, String title, int peopleCnt, int pay, String notice, 
                        String meet_address, String meet_latitude, String mainImgUrl, 
                        int cityId, int regionId, int needDate, MultipartFile img, 
                        String imgName, List<CategoryDto> categorys, List<OptionDto> options, 
                        List<CreateActivityDto> activities) {
        this.guidName = guidName;
        this.title = title;
        this.peopleCnt = peopleCnt;
        this.pay = pay;
        this.notice = notice;
        this.meet_address = meet_address;
        this.meet_latitude = meet_latitude;
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

    // Getter와 Setter
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

    public String getMeet_address() {
        return meet_address;
    }

    public void setMeet_address(String meet_address) {
        this.meet_address = meet_address;
    }

    public String getMeet_latitude() {
        return meet_latitude;
    }

    public void setMeet_latitude(String meet_latitude) {
        this.meet_latitude = meet_latitude;
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

    // toString 메소드
    @Override
    public String toString() {
        return "CreatTourDto{" +
                "guidName='" + guidName + '\'' +
                ", title='" + title + '\'' +
                ", peopleCnt=" + peopleCnt +
                ", pay=" + pay +
                ", notice='" + notice + '\'' +
                ", meet_address='" + meet_address + '\'' +
                ", meet_latitude='" + meet_latitude + '\'' +
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
