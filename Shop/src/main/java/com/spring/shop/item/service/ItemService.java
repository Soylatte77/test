package com.spring.shop.item.service;

import java.util.List;

import com.spring.shop.item.vo.CategoryVO;
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

}
