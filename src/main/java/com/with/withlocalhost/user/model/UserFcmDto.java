package com.with.withlocalhost.user.model;


public class UserFcmDto {
    private String userId;
    private String fcmToken;

    // 기본 생성자
    public UserFcmDto() {
    }

    // 매개변수 생성자
    public UserFcmDto(String userId, String fcmToken) {
        this.userId = userId;
        this.fcmToken = fcmToken;
    }

    // Getter
    public String getUserId() {
        return userId;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    // Setter
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    // toString
    @Override
    public String toString() {
        return "UserFcmDto{" +
                "userId='" + userId + '\'' +
                ", fcmToken='" + fcmToken + '\'' +
                '}';
    }
}
