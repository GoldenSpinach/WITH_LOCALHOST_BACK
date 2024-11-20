package com.with.withlocalhost.tour.model;

public class TourDto {
	private int tourId; // 투어 ID
	private String title; // 제목
	private int peopleCnt; // 인원 수
	private int pay; // 비용
	private String notice; // 공지사항
	private String meetLongitude; // 만남 장소 경도
	private String meetLatitude; // 만남 장소 위도
	private String meetAddress; // 만남 장소 주소
	private String mainImgUrl; // 메인 이미지 URL
	private String guidName; // 가이드 이름

	// 기본 생성자
	public TourDto() {
	}

	// 모든 필드를 포함한 생성자
	public TourDto(int tourId, String title, int peopleCnt, int pay, String notice, String meetLongitude,
			String meetLatitude, String meetAddress, String mainImgUrl, String guidName) {
		this.tourId = tourId;
		this.title = title;
		this.peopleCnt = peopleCnt;
		this.pay = pay;
		this.notice = notice;
		this.meetLongitude = meetLongitude;
		this.meetLatitude = meetLatitude;
		this.meetAddress = meetAddress;
		this.mainImgUrl = mainImgUrl;
		this.guidName = guidName;
	}

	// Getter와 Setter
	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
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

	public String getMeetLongitude() {
		return meetLongitude;
	}

	public void setMeetLongitude(String meetLongitude) {
		this.meetLongitude = meetLongitude;
	}

	public String getMeetLatitude() {
		return meetLatitude;
	}

	public void setMeetLatitude(String meetLatitude) {
		this.meetLatitude = meetLatitude;
	}

	public String getMeetAddress() {
		return meetAddress;
	}

	public void setMeetAddress(String meetAddress) {
		this.meetAddress = meetAddress;
	}

	public String getMainImgUrl() {
		return mainImgUrl;
	}

	public void setMainImgUrl(String mainImgUrl) {
		this.mainImgUrl = mainImgUrl;
	}

	public String getGuidName() {
		return guidName;
	}

	public void setGuidName(String guidName) {
		this.guidName = guidName;
	}

	// toString() 메서드 (디버깅 및 로그용)
	@Override
	public String toString() {
		return "TourDto{" + "tourId=" + tourId + ", title='" + title + '\'' + ", peopleCnt=" + peopleCnt + ", pay="
				+ pay + ", notice='" + notice + '\'' + ", meetLongitude='" + meetLongitude + '\'' + ", meetLatitude='"
				+ meetLatitude + '\'' + ", meetAddress='" + meetAddress + '\'' + ", mainImgUrl='" + mainImgUrl + '\''
				+ ", guidName='" + guidName + '\'' + '}';
	}
}
