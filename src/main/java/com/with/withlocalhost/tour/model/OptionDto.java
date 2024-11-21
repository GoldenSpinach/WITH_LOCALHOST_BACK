package com.with.withlocalhost.tour.model;

public class OptionDto {
	private int tourId; // 투어 ID
	private int categoryId; // 카테고리 ID
	private String optionName; // 옵션 이름
	private String optionType; // 옵션 타입

	// 기본 생성자
	public OptionDto() {
	}

	// 모든 필드를 받는 생성자
	public OptionDto(int tourId, int categoryId, String optionName, String optionType) {
		this.tourId = tourId;
		this.categoryId = categoryId;
		this.optionName = optionName;
		this.optionType = optionType;
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

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	// toString 메서드 - 객체의 상태를 문자열로 반환
	@Override
	public String toString() {
		return "OptionDto{" + "tourId=" + tourId + ", categoryId=" + categoryId + ", optionName='" + optionName + '\''
				+ ", optionType='" + optionType + '\'' + '}';
	}
}
