package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class UserModel extends AbstractModel<UserModel> {
	private Long user_id;
	private String userName;
	private String fullName;
	private String password;
	private Integer status;
	private Long role_Id;
	private RoleModel role = new RoleModel();
	
	

	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getRole_Id() {
		return role_Id;
	}
	public void setRole_Id(Long role_Id) {
		this.role_Id = role_Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserModel [user_id=" + user_id + ", userName=" + userName + ", fullName=" + fullName + ", password="
				+ password + ", status=" + status + ", role_Id=" + role_Id + ", role=" + role + "]";
	}

}
