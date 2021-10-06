package com.spring.shop.member.service;

import com.spring.shop.member.vo.MemberVO;

public interface MemberService {
	//회원가입
	void insertMember(MemberVO memberVO);

	//로그인
	MemberVO selectMember(MemberVO memberVO);
}
