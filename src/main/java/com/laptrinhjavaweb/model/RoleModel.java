package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class RoleModel extends AbstractModel<RoleModel> {
	private Long role_id;

	private String Name;
	private String code;
	private Long userId;
	private Long newsId;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "RoleModel [role_id=" + role_id + ", Name=" + Name + ", code=" + code + ", userId=" + userId
				+ ", newsId=" + newsId + "]";
	}	
	
	
}
