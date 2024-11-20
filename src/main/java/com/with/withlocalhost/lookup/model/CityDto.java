package com.with.withlocalhost.lookup.model;

public class CityDto {
	private int cityId;
	private String cityName;
	private int regionId;

	// 기본 생성자
	public CityDto() {
	}

	// 모든 필드를 매개변수로 받는 생성자
	public CityDto(int cityId, String cityName, int regionId) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.regionId = regionId;
	}

	// Getter와 Setter
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	// toString 메서드
	@Override
	public String toString() {
		return "CityDto [cityId=" + cityId + ", cityName=" + cityName + ", regionId=" + regionId + "]";
	}
}
