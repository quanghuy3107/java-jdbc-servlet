package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class NewsModel extends AbstractModel<NewsModel> {
	private Long news_id;
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private Long category_Id;
	private long[] news_ids;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Long getNews_id() {
		return news_id;
	}
	public void setNews_id(Long news_id) {
		this.news_id = news_id;
	}
	public Long getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(Long category_Id) {
		this.category_Id = category_Id;
	}
	@Override
	public String toString() {
		return "NewsModel [news_id=" + news_id + ", title=" + title + ", thumbnail=" + thumbnail + ", shortDescription="
				+ shortDescription + ", content=" + content + ", category_Id=" + category_Id + "]";
	}
	public long[] getNews_ids() {
		return news_ids;
	}
	public void setNews_ids(long[] news_ids) {
		this.news_ids = news_ids;
	}

}
