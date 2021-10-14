package com.spring.shop.common.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.shop.common.service.CommonService;
import com.spring.shop.item.service.ItemService;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Resource(name = "commonService")
	private CommonService commonService;
	@Resource(name = "itemService")
	private ItemService itemService;
	
	//게시판으로 이동
	@GetMapping("/bookBoard")
	public String goBookBoard(Model model) {
		model.addAttribute("cateList", itemService.selectCateList());
		model.addAttribute("boardList", commonService.selectBoardList());
		
		return "common/board_list";
	}
}
