package com.spring.shop.common.vo;

public class BoardVO extends PageVO{
	//pageVO = page + baseSearch
	//검색할 때 검색 정보 + 페이징 처리 + 보드 정보 다 필요
	//boardVO를 매개변수로 넣어도 startNum, endNum과 검색 정보 전부 사용 가능 
	private int boardNum;
	private String title;
	private String writer;
	private String createDate;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
