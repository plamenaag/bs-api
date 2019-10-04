package com.bookstore.api.dto;

import java.util.List;

public class PageResult {
	
	private List<?> results;
	private Integer startIndex; 
	private Integer endIndex; 
	private Integer itemCount;
	
	public PageResult(List<?> results, Integer startIndex, Integer endIndex, Integer itemCount){
		this.results = results;
		this.startIndex = startIndex; 
		this.endIndex = endIndex; 
		this.itemCount = itemCount;
	}

	public List<?> getResults() {
		return results;
	}

	public void setResults(List<?> results) {
		this.results = results;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
	
	
}
