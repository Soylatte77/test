package com.spring.shop.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//아이디 중복 확인
	@Override
	public boolean isJoined(String id) {
		//쿼리 실행 결과 = id = 문자열 = String
		String result = sqlSession.selectOne("memberMapper.isJoined", id);

		//중복되는 id 가 없으면 null값
		return result == null ? false : true;
		//회원가입이 되어있니 ? 응 : 아니;
		//true = 응 = 이미 등록된 id
		//false = 아니 = 등록되지 않은 id
	}
	
	//회원가입
	@Override
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert("memberMapper.insertMember", memberVO);
		
	}
	//로그인
	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		
		return sqlSession.selectOne("memberMapper.selectMember", memberVO);
	}

}
