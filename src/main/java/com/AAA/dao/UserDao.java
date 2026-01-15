package com.AAA.dao;

import com.AAA.dto.UserRegisterRequest;
import com.AAA.model.User;

public interface UserDao {
	Integer createUser(UserRegisterRequest userRegisterRequest);
	User getUserById(Integer userId);
}
