package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	UserModel findUsernamePasswordAndStatus(String userName, String password, Integer status);
}
