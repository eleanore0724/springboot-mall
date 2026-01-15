package com.AAA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AAA.dao.UserDao;
import com.AAA.dto.UserRegisterRequest;
import com.AAA.model.User;
import com.AAA.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
		return userDao.createUser(userRegisterRequest);
	}

	@Override
	public User getUserById(Integer userId) {
		
		return userDao.getUserById(userId);
	}
}
