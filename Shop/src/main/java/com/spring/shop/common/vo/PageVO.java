package com.spring.shop.common.vo;

public class PageVO extends BaseSearchVO{
	//페이징 처리 클래스
	
	//검색 조건vo를 상속
	
	//현재 선택된 페이지 번호
	private int nowPage;

	//전체 데이터 수(게시글 수)
	private int totalCnt;
	
	//화면에 보이는 첫 페이지 
	//총 페이지는 10 페이지 중 1~5 [next] 중에서 1 페이지
	private int beginPage;
	
	//화면에 보이는 마지막 페이지
	//총 페이지는 10 페이지 중 1~5 [next] 중에서 5 페이지
	private int endPage;
	
	//한 화면에 보여지는 게시글 수
	private int displayCnt;
	
	//한 번에 보여지는 페이지 수
	//1 2 3 4 5 ..... 10
	private int displayPageCnt;
	
	//[이전] 버튼의 유무
	private boolean prev;
	
	//[다음] 버튼의 유무
	private boolean next;
	
	//시작하는 rowNum
	private int startNum;
	//끝나는 rowNum
	private int endNum;
	
	public PageVO() {
		nowPage = 1;
	
		//한 화면에 데이터 5개씩
		displayCnt = 5;
		
		//한 번에 보여지는 페이지의 수
		//1 2 3 4 5
		//6 7 8 9 10
		displayPageCnt = 5;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	 
	public int getStartNum() {
		return startNum;
	}

	public void setStartNum() {
		this.startNum = (nowPage - 1) * displayCnt + 1;
					   //현재 페이지    한 화면에 보여줄 게시글
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum() {
		this.endNum = nowPage * displayCnt;
	}

	//이 메소드 호출 시 페이징 처리의 모든 정보가 세팅됨
	public void setPageInfo() {
		//화면에 보이는 마지막 페이지 번호를 설정
		//ceil 올림 함수
		endPage = (int)(Math.ceil(nowPage / (double)displayPageCnt)) * displayPageCnt;
		//화면에 보이는 첫페이지 번호를 세팅
		beginPage = endPage - displayPageCnt + 1;
	
		//전체 페이지 수
		int totalPage = (int)(Math.ceil(totalCnt / (double)displayCnt));
		
		//넥스트 버튼의 유무
		//endPage
		if(endPage < totalPage) {
			next = true;
		}
		else {
			next = false;
			//토탈 페이지를 엔드 페이지에 넣어라
			endPage = totalPage;
			//     1 2 3 4 5 넥스트
			//이전 6 7 8 9 10
			//실제 페이지가 8까지일 때 8까지만 표시하고 9 10은 지운다
		}
		
		//prev 이전 버튼의 유무
		prev = beginPage ==  1 ? false : true;
		
		//이 메소드 호출될 때 자동으로 스타트,엔드 넘에 넣어줌
		setStartNum();
		setEndNum();
	}
	
	
	
}
