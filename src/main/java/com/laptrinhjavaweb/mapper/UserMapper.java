package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel userModel = new UserModel();
			userModel.setUser_id(rs.getLong("user_id"));
			userModel.setUserName(rs.getString("username"));
			userModel.setPassword(rs.getString("password"));
			userModel.setFullName(rs.getString("fullname"));
			userModel.setStatus(rs.getInt("status"));
			userModel.setRole_Id(rs.getLong("role_id"));
			
			
			userModel.setCreatedDate(rs.getTimestamp("createddate"));
			userModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			userModel.setCreatedBy(rs.getString("createdby"));
			userModel.setModifiedBy(rs.getString("modifiedby"));
			try {
				RoleModel role;
				role = new RoleModel();
				role.setName(rs.getString("name"));
				role.setCode(rs.getString("code"));
				userModel.setRole(role);;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
