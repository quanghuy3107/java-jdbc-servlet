package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewsModel>{
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(long categoryid);
	Long save(NewsModel news);
	void update(NewsModel news);
	void delete(long ids);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem();
}
