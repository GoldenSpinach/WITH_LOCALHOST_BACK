package com.with.withlocalhost.user.model.repository;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.with.withlocalhost.user.model.UserDto;
import com.with.withlocalhost.user.model.UserFcmDto;

@Mapper
public interface UserRepository {

    // FCM 토큰 추가/갱신
    int addFcmToken(UserFcmDto userFcmDto) throws SQLException;

    // 사용자 정보 갱신 (회원가입 이후 정보 업데이트)
    int userJoin(UserDto userDto) throws SQLException;

    // 사용자 ID 조회
    UserDto findUserById(String userId) throws SQLException;

    // 사용자 추가 (회원가입)
    int addUser(UserDto userDto) throws SQLException;

    // Refresh Token 조회
    String getRefreshToken(String userId) throws SQLException;

    // Refresh Token 업데이트
    int updateRefreshToken(String userId, String refreshToken) throws SQLException;
    
    //RefreshToken 가져오기
    String findRefreshTokenByUserId(String userId) throws SQLException;
}

