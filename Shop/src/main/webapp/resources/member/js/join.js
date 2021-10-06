/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
   //$(document).on('click', '선택자', function() { 
   //});


});

/* 함수선언 영역*/
(function($){
	
	//비밀번호 일치 확인 후 submit
     goJoin = function(){
		var p1 = $('#pw').val()
		var p2 = $('#c_pw').val()  
		
		//비밀번호가 틀렸을 때
		if(p1 != p2){
			alert("비밀번호가 일치하지 않습니다.");
			//비밀번호 칸 초기화
			$('input[type="password"]').val('');
			$('#pw').focus();
			
			return;
		}
		
		//비밀번호가 일치할 때
		$('#joinForm').submit();
	
     };
})(jQuery);