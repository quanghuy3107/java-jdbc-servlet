package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;


public class UserDAO extends AbstracDao<UserModel> implements IUserDAO{

	@Override
	public UserModel findUsernamePasswordAndStatus(String userName, String password, Integer status) {
		
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
		sql.append(" INNER JOIN role AS r ON u.role_id = r.role_id");
		sql.append(" WHERE username = ? and password = ? and status = ?");
		List<UserModel> list = query(sql.toString(), new UserMapper(), userName, password, status);
		return list.isEmpty() ? null : list.get(0);

	}

	

}
