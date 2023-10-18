package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewsModel;

public class NewMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultset) {
		try {
			NewsModel newsModel = new NewsModel();
			newsModel.setNews_id(resultset.getLong("news_id"));
			newsModel.setTitle(resultset.getString("title"));
			newsModel.setThumbnail(resultset.getString("thumbnail"));
			newsModel.setCategory_Id(resultset.getLong("category_id"));
			newsModel.setContent(resultset.getString("content"));
			newsModel.setShortDescription(resultset.getString("shortdescription"));
			newsModel.setCreatedDate(resultset.getTimestamp("createddate"));
			newsModel.setModifiedDate(resultset.getTimestamp("modifieddate"));
			newsModel.setCreatedBy(resultset.getString("createdby"));
			newsModel.setModifiedBy(resultset.getString("modifiedby"));
			return newsModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
