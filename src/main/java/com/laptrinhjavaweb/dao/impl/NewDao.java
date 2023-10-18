package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public class NewDao extends AbstracDao<NewsModel> implements INewDAO{
	
	@Override
	public List<NewsModel> findByCategoryId(long categoryid) {
		String sql = "SELECT * FROM news WHERE category_id = ?";
		return query(sql, new NewMapper(), categoryid);
		
	}

	@Override
	public Long save(NewsModel news) {
		String sql = "INSERT INTO news(title,thumbnail,shortdescription,content , category_id, createddate, createdby) VALUES (?,?,?,?,?,?,?)";
		return insert(sql, news.getTitle(), news.getThumbnail(), news.getShortDescription() , news.getContent() , news.getCategory_Id(), news.getCreatedDate(), news.getCreatedBy());
	}

	@Override
	public void update(NewsModel news) {
		String sql = "UPDATE news SET title = ?, thumbnail = ?, content = ?, shortdescription = ? , category_id = ?, modifieddate = ?, modifiedby = ? WHERE news_id = ?";
		update(sql, news.getTitle(), news.getThumbnail(), news.getContent() , news.getShortDescription(), news.getCategory_Id(), news.getModifiedDate(), news.getModifiedBy(), news.getNews_id());
		
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE news_id = ?";
		update(sql, id);
		
	}

	@Override
	public NewsModel findOne(Long id) {
		System.out.println(id);
		String sql = "SELECT * FROM news WHERE news_id = ?";
		List<NewsModel> list = query(sql, new NewMapper(), id);
		System.out.println("da di qua");
		System.out.println(list.get(0));
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news ");
//		if(sortName != null && sortBy != null) {
//			sql.append("ORDER BY ? ? ");
////			return query(sql.toString(), new NewMapper() , sortName, sortBy );
//			if(limit != null && offset != null) {
//				sql.append("LIMIT ? OFFSET ?");
//				return query(sql.toString(), new NewMapper(),sortName, sortBy, limit, offset);
//				
//			}else {
//				return query(sql.toString(), new NewMapper(),sortName, sortBy );
//			}
//		}else {
//			if(limit != null && offset != null) {
//				sql.append("LIMIT ? OFFSET ?");
//				return query(sql.toString(), new NewMapper(), limit, offset);
//				
//			}else {
//				return query(sql.toString(), new NewMapper() );
//			}
//		}
		
		if(pageble.getSorter() != null) {
			sql.append("ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+" ");
		}
		if(pageble.getLimit() != null && pageble.getOffset() != null) {
			sql.append(" LIMIT "+pageble.getLimit()+" OFFSET "+pageble.getOffset()+"");
		}
		
		return query(sql.toString(), new NewMapper() );
		
		
		
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM news ";
		return getTotalItem(sql);
	}
	
}
