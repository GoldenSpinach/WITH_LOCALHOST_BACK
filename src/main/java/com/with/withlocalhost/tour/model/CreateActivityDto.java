package com.with.withlocalhost.tour.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public class CreateActivityDto {
    private int tourId;
    private int categoryId;
    private String actName;
    private String actContents;
    private String actAddress;
    private String actLatitude;
    private String actLongitude;
    private MultipartFile img;
    private String imgName;
    private String actImgUrl;

    // 기본 생성자
    public CreateActivityDto() {}

    // 전체 필드를 초기화하는 생성자
    public CreateActivityDto(int tourId, int categoryId, String actName, String actContents, String actAddress, 
                             String actLatitude, String actLongitude, MultipartFile img, String imgName, String actImgUrl) {
        this.tourId = tourId;
        this.categoryId = categoryId;
        this.actName = actName;
        this.actContents = actContents;
        this.actAddress = actAddress;
        this.actLatitude = actLatitude;
        this.actLongitude = actLongitude;
        this.img = img;
        this.imgName = imgName;
        this.actImgUrl = actImgUrl;
    }

    // Getter and Setter Methods
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

    public String getActLatitude() {
        return actLatitude;
    }

    public void setActLatitude(String actLatitude) {
        this.actLatitude = actLatitude;
    }

    public String getActLongitude() {
        return actLongitude;
    }

    public void setActLongitude(String actLongitude) {
        this.actLongitude = actLongitude;
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

    
    
    public String getActImgUrl() {
		return actImgUrl;
	}

	public void setActImgUrl(String actImgUrl) {
		this.actImgUrl = actImgUrl;
	}

	// toString() Method
    @Override
    public String toString() {
        return "CreateActivityDto{" +
                "tourId=" + tourId +
                ", categoryId=" + categoryId +
                ", actName='" + actName + '\'' +
                ", actContents='" + actContents + '\'' +
                ", actAddress='" + actAddress + '\'' +
                ", actLatitude='" + actLatitude + '\'' +
                ", actLongitude='" + actLongitude + '\'' +
                ", img=" + img +
                ", imgName=" + imgName +  '\'' +
                ", actImgUrl=" + actImgUrl +  '\'' +
                '}';
    }
}
