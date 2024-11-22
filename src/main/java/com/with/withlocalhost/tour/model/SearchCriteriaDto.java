package com.with.withlocalhost.tour.model;

import java.util.Date;
import java.util.List;

public class SearchCriteriaDto {

    private Date startDate; // 시작일
    private Date endDate;   // 종료일
    private int regionId;   // 지역 이름
    private List<Integer> options;   // 옵션
    private List<Integer> categories; // 카테고리
    private List<Integer> cities;    // 도시

    // 기본 생성자
    public SearchCriteriaDto() {
    }

    // 모든 필드를 포함하는 생성자
    public SearchCriteriaDto(Date startDate, Date endDate, int regionId, List<Integer> options, List<Integer> categories, List<Integer> cities) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.regionId = regionId;
        this.options = options;
        this.categories = categories;
        this.cities = cities;
    }

    // Getter 및 Setter
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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> options) {
        this.options = options;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<Integer> getCities() {
        return cities;
    }

    public void setCities(List<Integer> cities) {
        this.cities = cities;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "SearchCriteriaDto{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", regionId=" + regionId +
                ", options=" + options +
                ", categories=" + categories +
                ", cities=" + cities +
                '}';
    }
}
