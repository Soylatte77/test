package com.spring.shop.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.common.service.CommonService;
import com.spring.shop.common.util.FileUploadUtil;
import com.spring.shop.item.service.ItemService;
import com.spring.shop.item.vo.ImgVO;
import com.spring.shop.item.vo.ItemVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource(name = "itemService")
	private ItemService itemService;
	@Resource(name = "commonService")
	private CommonService commonService;

	// 카테고리 관리 페이지로 이동
	@GetMapping("/categoryManage")
	public String goCategoryManage(Model model) {

		// 선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "categoryManage");

		// 관리자 상단 메뉴 조회 쿼리
		model.addAttribute("menuList", commonService.selectMenuList());

		//사이드 메뉴 조회 쿼리
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_001"));
		
		//카테고리 목록 조회
		model.addAttribute("cateList", itemService.selectCateList());

		return "admin/category_manage";
	}

	// 카테고리 등록
	@PostMapping("/insertCate")
	public String insertCate(String cateName) {

		itemService.insertCate(cateName);

		return "redirect:/admin/categoryManage";
	}

	// 카테고리 삭제
	@PostMapping("/deleteCate")
	public String deleteCate(String cateCode) {
		itemService.deleteCate(cateCode);

		return "redirect:/admin/categoryManage";
	}

	// 상품 등록 페이지로 이동
	@GetMapping("/regItem")
	public String goRegItem(Model model) {
		// 관리자 상단 메뉴 조회 쿼리
		model.addAttribute("menuList", commonService.selectMenuList());

		// 선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "regItem");

		// 카테고리 목록 조회를 위해 카테고리 리스트 조회 쿼리 실행
		model.addAttribute("list", itemService.selectCateList());

		//사이드 메뉴 조회 쿼리
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_001"));
	
		return "admin/reg_item";
	}

	// 상품 등록
	@PostMapping("/regItem")
	public String regItem(Model model, ItemVO itemVO, MultipartHttpServletRequest multi) {
		//실제 첨부파일도 upload
			//파일 네임이 여러개 들어올 수 있는 장소
			//파일이 첨부되는 input 태그의 name 속성값을 가져옴
		Iterator<String> inputNames = multi.getFileNames();
		
		//파일이 첨부된 폴더 지정
		//집
		String uploadPath = "C:\\git\\ShinMinHwi\\test\\Shop\\src\\main\\webapp\\resources\\images\\";
		
		
		//모든 첨부파일 정보가 들어갈 imgVO를 담을 수 있는 바구니
		List<ImgVO> imgList = new ArrayList<ImgVO>();
		
		//다음에 들어갈 IMG_CODE의 숫자를 조회
		int nextImgCode = itemService.selectNextNumber();
		
		//inputNames 안의 여러 개의 문자열String을 들어있는 만큼 반복 반복
		while(inputNames.hasNext()) {
			String inputName = inputNames.next();
			//하나의 input 태그의 파일 정보
			multi.getFile(inputName);
			
			
			//위에서 가져온 파일 정보에서 원본 파일명 가져오기
			//file.getOriginalFilename();
			//파일의 첨부된 이름
			//file.getName();
			
			//실제 파일 폴더에 저장하기
				//반드시 트랜잭션 처리해야함
			try {
				//다중 첨부
				//file2 = 사진 여러장 들어옴
				if(inputName.equals("file2")) {
					List<MultipartFile> fileList = multi.getFiles(inputName);

					//파일이 여러 장 = for문 돌리기
					for(MultipartFile file: fileList) {
						String attchedFileName = FileUploadUtil.getNowDateTime() + "_" +  file.getOriginalFilename();
						
						//날짜시간 구하는 메소드 변수로 만들기
						String uploadFile = uploadPath + attchedFileName;
						
						//지정된 경로에 파일 저장하기
						file.transferTo(new File(uploadFile));	
						
						ImgVO img = new ImgVO();
						img.setImgCode("IMG_00" +  String.format("%03d", nextImgCode++));
						img.setOriginImgName(file.getOriginalFilename());
						img.setAttachedImgName(attchedFileName);
						//img.setItemCode();
						
						//다중첨부 = 메인사진이 아님
						img.setIsMain("N");
						
						imgList.add(img);
						//imgList에 첨부파일의 갯수만큼 imgVO가 차곡차곡 쌓임
					}
				}
				//단일 첨부
				else {
					//첨부된 파일 정보가 하나 담겨있음
					MultipartFile file = multi.getFile(inputName);
					String attchedFileName = FileUploadUtil.getNowDateTime() + "_" +  file.getOriginalFilename();
					
					//날짜시간 구하는 메소드 변수로 만들기
					String uploadFile = uploadPath + attchedFileName;
					
					//지정된 경로에 파일 저장하기
					file.transferTo(new File(uploadFile));	
					
					ImgVO img = new ImgVO();
					img.setImgCode("IMG_00" +  String.format("%03d", nextImgCode++));
					img.setOriginImgName(file.getOriginalFilename());
					img.setAttachedImgName(attchedFileName);
					//img.setItemCode();
					
					//단일 첨부 = 무조건 메인 사진
					img.setIsMain("Y");
					
					imgList.add(img);
				}
				
				
			} catch (IllegalStateException e) {
				//부적절한 상태
				e.printStackTrace();
			} catch (IOException e) {
				//input output 오류
				e.printStackTrace();
			}
		}
		
		//상품 정보 insert
		itemService.insertItem(itemVO);
		
		//상품 이미지 정보 insert
		itemService.insertImgs(itemVO);

		return "redirect:/admin/regItem";
	}

	// 상품 관리 페이지로 이동
	@GetMapping("/itemManage")
	public String goItemManage(Model model) {
		// 관리자 상단 메뉴 조회 쿼리
		model.addAttribute("menuList", commonService.selectMenuList());
		// 선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "itemManage");
		return "admin/item_manage";
	}

	//회원목록으로 이동
	@GetMapping("/memberList")
	public String memberList(Model model) {
		// 선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "memberList");
		
		// 관리자 상단 메뉴 조회 쿼리
		model.addAttribute("menuList", commonService.selectMenuList());

		//사이드 메뉴 조회 쿼리
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_002"));
		return "admin/member_list";
	}
	// 회원관리 이동
	@GetMapping("/memberManage")
	public String memberManage(Model model) {
		// 관리자 상단 메뉴 조회 쿼리
		model.addAttribute("menuList", commonService.selectMenuList());

		//사이드 메뉴 조회 쿼리
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_002"));
		
		return "admin/member_manage";
	}
}
