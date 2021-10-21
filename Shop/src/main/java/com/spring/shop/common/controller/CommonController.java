package com.spring.shop.common.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.shop.common.service.CommonService;
import com.spring.shop.common.vo.BoardVO;
import com.spring.shop.common.vo.PageVO;
import com.spring.shop.item.service.ItemService;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Resource(name = "commonService")
	private CommonService commonService;
	@Resource(name = "itemService")
	private ItemService itemService;
	
	//게시판으로 이동
	@RequestMapping("/bookBoard")
	public String goBookBoard(Model model, BoardVO boardVO) {
		//커맨드 객체는 자동으로 넘어가기 때문에 따로 add 해줄 필요 없음
		
		//페이징 처리를 위해서는 먼저 전체 데이터 수를 구해야 함
		//쿼리문을 통해서 구해야 함
		int dataCnt = commonService.selectBoardCnt(boardVO);
		boardVO.setTotalCnt(dataCnt);
		
		//페이징 처리
		//페이징 처리에 관한 메소드
		boardVO.setPageInfo();
		
		
		model.addAttribute("cateList", itemService.selectCateList());
		model.addAttribute("boardList", commonService.selectBoardList(boardVO));
		//pageVO에는 startNUm, endNum 의 빈값으 채워줄 수 있음
		return "common/board_list";
	}
}
