package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewService {
	List<NewsModel> findByCategoryId(long categoryid);
	NewsModel save(NewsModel news);
	NewsModel update(NewsModel news);
	void delete(long[] ids);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem(); 
}
