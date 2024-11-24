package com.with.withlocalhost.user.model.repository;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.with.withlocalhost.user.model.UserFcmDto;

@Mapper
public interface UserRepository {

	int addFcmToken(UserFcmDto userFcmDto) throws SQLException;
}
