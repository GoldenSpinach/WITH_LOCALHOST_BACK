package com.with.withlocalhost.tour.model;

public class CategoryDto {
    private int tourId;         // 투어 ID
    private int categoryId;     // 카테고리 ID
    private String categoryName; // 카테고리 이름
    private String categoryType; // 카테고리 타입

    // 기본 생성자
    public CategoryDto() {}

    // 모든 필드를 받는 생성자
    public CategoryDto(int tourId, int categoryId, String categoryName, String categoryType) {
        this.tourId = tourId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    // Getter 및 Setter 메서드
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    // toString 메서드 - 객체의 상태를 문자열로 반환
    @Override
    public String toString() {
        return "CategoryDto{" +
                "tourId=" + tourId +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType='" + categoryType + '\'' +
                '}';
    }
}
