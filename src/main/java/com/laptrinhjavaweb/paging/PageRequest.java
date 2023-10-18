package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public class PageRequest implements Pageble{
	
	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	
	public PageRequest(Integer page , Integer maxPageItem , Sorter sorter ) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}
	
	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if(this.getPage() != null && this.getLimit() != null) {
			return (this.getPage() - 1) * this.getLimit();
		}
			return null;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		if(this.sorter != null) {
			return this.sorter;
		}
		return null;
	}

}
