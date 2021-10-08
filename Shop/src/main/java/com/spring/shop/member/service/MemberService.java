package com.spring.shop.member.service;

import com.spring.shop.member.vo.MemberVO;

public interface MemberService {
	
	//아이디 중복 확인
	//boolean T/F
	boolean isJoined(String id);
	
	//회원가입
	void insertMember(MemberVO memberVO);

	//로그인
	MemberVO selectMember(MemberVO memberVO);
	
	
}
