package com.spring.shop.common.vo;

public class BaseSearchVO {
	//검색 기능

	//제목 or 작성자
	private String searchKeyword;
	private String searchValue;
	
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	
}
