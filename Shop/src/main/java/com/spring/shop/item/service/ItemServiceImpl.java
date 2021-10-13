package com.spring.shop.item.service;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.shop.item.vo.CategoryVO;
import com.spring.shop.item.vo.ItemVO;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CategoryVO> selectCateList() {
		
		return sqlSession.selectList("itemMapper.selectCateList");
	}

	@Override
	public void insertItem(ItemVO itemVO) {
		sqlSession.insert("itemMapper.insertItem", itemVO);
	}

	@Override
	public void insertCate(String cateName) {
		sqlSession.insert("itemMapper.insertCate", cateName);
	}

	//아이템 삭제 + 카테고리 삭제
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteCate(String cateCode) {
		sqlSession.delete("itemMapper.deleteItemByCateCode",cateCode);
		sqlSession.delete("itemMapper.deleteCate", cateCode);
	}

	@Override
	public void insertImgs(ItemVO itemVO) {
		sqlSession.insert("itemMapper.insertImgs", itemVO);
	}

	@Override
	public int selectNextNumber() {
		return sqlSession.selectOne("itemMapper.selectNextNumber");
		
	}

	
}
