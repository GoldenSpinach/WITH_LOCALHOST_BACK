package com.with.withlocalhost.user.model.service;

import java.sql.SQLException;

import com.with.withlocalhost.user.model.UserFcmDto;

public interface UserService {
	String addFcmToken(UserFcmDto userFcmDto) throws SQLException;
}
