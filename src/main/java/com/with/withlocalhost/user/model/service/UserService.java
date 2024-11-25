package com.with.withlocalhost.user.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.with.withlocalhost.user.model.UserDto;
import com.with.withlocalhost.user.model.UserFcmDto;

public interface UserService {
	String addFcmToken(UserFcmDto userFcmDto) throws SQLException;
	
	String userJoin(UserDto userDto) throws SQLException;
	
	Map<String, Object> userLogin(String authorizationCode) throws SQLException;
}
