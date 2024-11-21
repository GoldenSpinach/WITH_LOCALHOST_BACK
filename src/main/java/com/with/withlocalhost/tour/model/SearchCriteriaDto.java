package com.with.withlocalhost.tour.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import java.util.Date;
import java.util.Map;

public class SearchCriteriaDto {

    private Date startDate;    // 시작일
    private Date endDate;      // 종료일
    private List<Integer> options;   // 옵션
    private int regionId;    // 지역 이름
    private int cityId;      // 도시 이름

    // 기본 생성자
    public SearchCriteriaDto() {
    }

    // 모든 필드를 초기화하는 생성자
    public SearchCriteriaDto(Date startDate, Date endDate, List<Integer> options, int regionId, int cityId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.options = options;
        this.regionId = regionId;
        this.cityId = cityId;
    }

    // Getter와 Setter

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

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> options) {
        this.options = options;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "SearchCriteriaDto{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", options=" + options +
                ", regionName='" + regionId + '\'' +
                ", cityName='" + cityId + '\'' +
                '}';
    }
}
