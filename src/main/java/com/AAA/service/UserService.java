package com.AAA.service;

import com.AAA.dto.UserRegisterRequest;
import com.AAA.model.User;

public interface UserService {
	Integer register(UserRegisterRequest userRegisterRequest);
	
	User getUserById(Integer userId);
}
