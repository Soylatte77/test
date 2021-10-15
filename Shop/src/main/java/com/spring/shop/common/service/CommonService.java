package com.spring.shop.common.service;

import java.util.List;

import com.spring.shop.common.vo.BoardVO;
import com.spring.shop.common.vo.MenuVO;
import com.spring.shop.common.vo.PageVO;
import com.spring.shop.common.vo.SideMenuVO;

public interface CommonService {
	
	//메뉴 목록 조회
	List<MenuVO> selectMenuList();
	
	//사이드 메뉴 목록 조회
	List<SideMenuVO> selectSideMenuList(String menuCode);
	
	//게시판 목록 조회
	List<BoardVO> selectBoardList(BoardVO boardVO);
	//boardVO에는 pageVO + boardSearchVo 둘다 상속
	
	//전체 게시글 갯수 조회
	int selectBoardCnt();
}
