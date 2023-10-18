package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class CategoryModel extends AbstractModel<CategoryModel> {
	private Long category_id;
	private String code;
	private String name;

	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoryModel [category_id=" + category_id + ", code=" + code + ", name=" + name + "]";
	}
	
	
}
