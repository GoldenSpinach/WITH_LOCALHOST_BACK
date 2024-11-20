package com.with.withlocalhost.lookup.model;

public class RegionDto {
    private int regionId;
    private String regionName;

    // 기본 생성자
    public RegionDto() {}

    // 모든 필드를 매개변수로 받는 생성자
    public RegionDto(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    // Getter와 Setter
    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "RegionDto [regionId=" + regionId + ", regionName=" + regionName + "]";
    }
}

