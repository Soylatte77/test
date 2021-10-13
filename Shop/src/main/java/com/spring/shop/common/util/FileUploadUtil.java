package com.spring.shop.common.util;

import java.util.Calendar;

public class FileUploadUtil {
	//파일 첨부 담당 클래스
	
	//현재 날짜와 시간을 문자열로 리턴
	//파일 첨부할때 날짜/시간/파일명으로 구분
	//static 어디서나 사용 가능
	public static String getNowDateTime() {
		//캘린더 객체 생성
		Calendar cal = Calendar.getInstance();
		//현재 날짜 및 시간을 문자열로 저장할 변수
		String nowDateTime = "";
		
		//현재 날짜 및 시간을 문자열로 생성
		//문자열 연결
		nowDateTime += cal.get(Calendar.YEAR);
		nowDateTime += cal.get(Calendar.MONTH) + 1;
		nowDateTime += cal.get(Calendar.DATE);
		nowDateTime += cal.get(Calendar.HOUR);
		nowDateTime += cal.get(Calendar.MINUTE);
		nowDateTime += cal.get(Calendar.SECOND);
		nowDateTime += cal.get(Calendar.MILLISECOND);
		
		return nowDateTime;

	}
	
	
	//파일 첨부 사전 준비 기능
	//파일 업로드 기능
}
