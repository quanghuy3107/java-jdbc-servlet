package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {
	UserModel findUsernamePasswordAndStatus(String userName, String password, Integer status);
}
