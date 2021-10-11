<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOK SHOP</title>
<link rel="stylesheet" href="${path}/resources/common/reset.css?ver=1"> 
<script type="text/javascript" src="/resources/template/js/menu.js?ver=5"></script>
<style type="text/css">
.row{
	padding-top: 20px;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col text-end">
			<c:choose>
				<c:when test="${not empty sessionScope.loginInfo }">
					${loginInfo.id } 님 반갑습니다.  
					<a href="/member/logout">LOGOUT</a>
				</c:when>
				<c:otherwise>
					<a href="/member/join">JOIN</a> 
					<!-- 모달 버튼 실행하기 위한 속성 추가 -->
					<a data-bs-toggle="modal" data-bs-target="#loginModal">LOGIN</a> 
				</c:otherwise>
			</c:choose>			
		</div>
	</div>
	
	<div class="row">
		<div class="col text-center">
			<h1>BOOK SHOP</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col text-center">
			<nav class="navbar navbar-expand-lg navbar-light bg-light" >
				<div class="container-fluid">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
						aria-controls="navbarNavAltMarkup" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-center" id="navbarNavAltMarkup">
						<div class="navbar-nav">
							<c:choose>
								<c:when test="${empty sessionScope.loginInfo or sessionScope.loginInfo.isAdmin eq 'N' }">
									<a class="nav-link active" aria-current="page" href="#">HOME</a>
									<c:forEach items="${cateList }" var="cateInfo">
									<a class="nav-link active" href="#">${cateInfo.cateName }</a> 
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${menuList }" var="menuInfo">
									<a class="nav-link active" href="/admin/${menuInfo.menuUri }">${menuInfo.menuName }</a> 
									</c:forEach>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>




	<!-- Modal -->
	<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="loginModalLabel">LOGIN</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
  	     <form action="/member/login" method="post">
	      <div class="modal-body">
	      	<div class="form-floating mb-3">
			  <input type="text" class="form-control" id="idInput" placeholder="Your ID" name="id" required>
			  <label for="idInput">Your ID</label>
			</div>
			<div class="form-floating">
			  <input type="password" class="form-control" id="pwInput" placeholder="Your PW" name="pw" required>
			  <label for="pwInput">Your PW</label>
			</div>
	      </div>
	      <div class="col-12 d-grid p-1">
             <input type="submit" class="btn btn-primary btn-block" value="L O G I N"  style="background-color: #4b7bec;">
          </div>
			</form>
	    </div>
	  </div>
	</div>
	     <!--  <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div> -->









</body>
</html>