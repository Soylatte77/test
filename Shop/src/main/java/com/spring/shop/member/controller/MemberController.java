package com.spring.shop.member.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.shop.member.service.MemberService;
import com.spring.shop.member.vo.MemberVO;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Resource(name = "memberService") 
	private MemberService memberService;
	
	//회원가입 페이지 이동
	@GetMapping("/join")
	public String joinForm() {
		return "member/join";
	}
	
	//회원가입 하기
	@PostMapping("/join")
	public String join(MemberVO memberVO) {
	
		memberService.insertMember(memberVO);
		
		//컨트롤러로 이동할 때
		return "redirect:/item/itemList";
	}
	
	//로그인
	@PostMapping("/login")
	public String login(MemberVO memberVO, HttpSession session) {
		MemberVO loginInfo = memberService.selectMember(memberVO);
		
		//로그인 성공
		if(loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			
			//관리자인지 일반회원인지 구분
			if(loginInfo.getIsAdmin().equals("Y")) {
				//관리자일 때
				return "redirect:/admin/categoryManage";
			}
			else {
				//일반 회원일 때
				return "redirect:/item/itemList";
			}
		
		}
		//로그인 실패했을 때
		return "redirect:/item/itemList";
	}
	
}
