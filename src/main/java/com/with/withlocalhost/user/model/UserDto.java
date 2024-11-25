package com.with.withlocalhost.user.model;

public class UserDto {
    private String userId;
    private String nickName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String imgUrl;
    private String birth;
    private String accessToken;
    private String refreshToken;

    // 기본 생성자
    public UserDto() {}

    // 모든 필드를 초기화하는 생성자
    public UserDto(String userId, String nickName, String email, String phoneNumber, String gender, String birth ,String imgUrl, String accessToken , String refreshToken) {
        this.userId = userId;
        this.nickName = nickName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birth = birth;
        this.imgUrl = imgUrl;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    // Getter & Setter
    public String getRefreshToken() {
    	return refreshToken;
    }
    
    public void setRefreshToken(String refreshToken) {
    	this.refreshToken = refreshToken;
    }
    
    
    public String getBirth() {
    	return birth;
    }
    
    public void setBirth() {
    	this.birth = birth;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // toString() 메서드
    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
