package com.with.withlocalhost.user.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.user.model.UserFcmDto;
import com.with.withlocalhost.user.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public String addFcmToken(UserFcmDto userFcmDto) throws SQLException {
		int result = userRepository.addFcmToken(userFcmDto);
		if (result > 0) {
			return "success";
		}
		return "fail";
	}

}
