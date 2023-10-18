package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dao.impl.UserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{
	
	private IUserDAO userDao = new UserDAO();
	
	@Override
	public UserModel findUsernamePasswordAndStatus(String userName, String password, Integer status) {
		// TODO Auto-generated method stub
		return userDao.findUsernamePasswordAndStatus(userName, password, status);
	}

}
