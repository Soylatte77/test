package com.spring.shop.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.shop.item.service.ItemService;
import com.spring.shop.item.vo.ItemVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource(name = "itemService")
	private ItemService itemService;
	
	//카테고리 관리 페이지로 이동
	@GetMapping("/categoryManage")
	public String goCategoryManage(Model model) {
		//선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "categoryManage");
		
		return "admin/category_manage";
	}
	
	//상품 등록 페이지로 이동
	@GetMapping("/regItem")
	public String goRegItem(Model model) {
		
		//선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "regItem");
		
		//카테고리 목록 조회를 위해 카테고리 리스트 조회 쿼리 실행
		model.addAttribute("list", itemService.selectCateList());
		
		return "admin/reg_item";
	}
	
	//상품 등록
	@PostMapping("/regItem")
	public String regItem(Model model, ItemVO itemVO) {
		itemService.insertItem(itemVO);
		
		return "redirect:/admin/regItem";
	}
	
	//상품 관리 페이지로 이동
	@GetMapping("/itemManage")
	public String goItemManage() {
		return "admin/item_manage";
	}
}
