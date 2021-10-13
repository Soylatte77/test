package com.spring.shop.item.service;

import java.util.List;

import com.spring.shop.item.vo.CategoryVO;
import com.spring.shop.item.vo.ImgVO;
import com.spring.shop.item.vo.ItemVO;

public interface ItemService {
	//상품 카테고리 목록 조회
	List<CategoryVO> selectCateList();

	//상품 등록
	void insertItem(ItemVO itemVO);
	
	//카테고리 등록
	void insertCate(String cateName);
	
	//카테고리 삭제
	void deleteCate(String cateCode);
	
	//상품 이미지 등록
	void insertImgs(ItemVO itemVO);
	//빈값에 list는 넣지 않음
	//왜 itemVO??
	//itemVO 하나에는 imgVO 여러개를 가질 수 있음
	//-> private List<ImgVO> imgList;
	
	//다음 img_code의 숫자를 조회
	int selectNextNumber();
	
}
