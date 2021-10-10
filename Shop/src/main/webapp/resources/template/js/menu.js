/* 페이지 로딩 후 실행 */
$(document).ready(function() {

	//$(document).on('click', '선택자', function() { 
	//});

	var loginModal = document.getElementById('loginModal');
	loginModal.addEventListener('hidden.bs.modal', function(event) {

		// 모달이 꺼질때 안에 내용 초기화
		//input의 type이 버튼을 제외하고
		
		$('.modal input:not([type="button"])').val('');
		
	});

});

/* 함수선언 영역*/
(function($) {


})(jQuery);