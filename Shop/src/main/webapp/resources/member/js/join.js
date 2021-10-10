/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	//id input 칸을 클릭하면...
   	$(document).on('click', '#id', function() { 
   		//아이디 입력 안내 문구 지우기
   		$('#confirmId').remove();	
   		//join 버튼 다시 비활성화 하기
   		$('#joinBtn').addClass('disabled');
   
   });
   


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
     
     //아이디 중복 체크
     checkId = function(){
		var id = $('#id').val();
		
		//아이디가 빈값이면..
		if(id == ''){
			//아이디 확인 버튼 뒤의 요소의 id 값을 가져온다.
			var aaa = $('#checkIdDiv').next().attr('confirmId');
			
			//그 아이디 값이 aaa가 아니라면..
			if(aaa != 'aaa'){
		
				//after 선택한 태그 뒤에 html 코드를 넣는다
				$('#checkIdDiv').after('<div id="confirmId">*아이디를 입력하세요.</div>');
				//이렇게 하면 아이디 입력 문구가 한번만 입력됨
			}
			
			return;
		}
		
		
		 $.ajax({
			 url: '/member/checkId', //요청경로
			 type: 'post',
			 data: {'id': id}, //필요한 데이터
			 success: function(result) {
				//result = true = 이미 가입된 id
				//result = false = 미가입 id
				
				if(result){
					//기가입된 id를 입력했을 때
					$('#checkIdDiv').after('<div id="confirmId">*중복된 아이디 입니다.</div>');	
				}
				else{
					//미가입된 id를 입력했을 때 = 회원가입이 가능함
					$('#checkIdDiv').after('<div id="confirmId" style="color: blue;">*사용 가능한 아이디 입니다.</div>');
					
					//회원가입 가능 = join 버튼 활성화
					//join 버튼에 있는 클래스 속성 중 disabled 삭제
   					$('#joinBtn').removeClass('disabled');
				}

			 },
			 error: function() {
				 //ajax 실행 실패 시 실행되는 구간
				 alert('실패');
			 }
		 });
	
	
	
	
	 };
     
})(jQuery);