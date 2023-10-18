package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.dao.impl.NewDao;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {
	public NewService() {
		// TODO Auto-generated constructor stub
	}
//	@Inject
	INewDAO newDao = new NewDao();
	@Override
	public List<NewsModel> findByCategoryId(long categoryid) {
		// TODO Auto-generated method stub
		return newDao.findByCategoryId(categoryid);
	}
	@Override
	public NewsModel save(NewsModel news) {
		news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		news.setCreatedBy("");
		
		Long newId = newDao.save(news);
		return newDao.findOne(newId);
	}
	@Override
	public NewsModel update(NewsModel news) {
		
		NewsModel oldnews = new NewsModel();
		oldnews = newDao.findOne(news.getNews_id());
		news.setCreatedDate(oldnews.getCreatedDate());
		news.setCreatedBy(oldnews.getCreatedBy());
		news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		news.setModifiedBy("");
		newDao.update(news);
		return newDao.findOne(news.getNews_id());
	}
	@Override
	public void delete(long[] ids) {
	
		for (long id : ids) {
			newDao.delete(id);
		}
		System.out.println("hoan hanh xoa");
		
	}
	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		
		return newDao.findAll( pageble);
	}
	@Override
	public int getTotalItem() {
		
		return newDao.getTotalItem();
	}
	

}
