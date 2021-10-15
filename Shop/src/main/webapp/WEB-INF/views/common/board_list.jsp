<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.table{
	border: 1px solid black;
	text-align: center;
}
tr, th, td{
	border: 1px solid black;
}
#title{
	border-bottom: 1px solid gray;
}
</style>
</head>
<body>
<div class="row justify-content-center">
	<div class="col-10">
		<form action="/common/bookBoard" method="post">
		<div class="col-3">
			<select class="form-select" name="searchKeyword">
			  <option value="TITLE">제목</option>
			  <option value="WRITER">작성자</option>
			</select>
		</div>
		<div class="col-4">
			 <input type="text" class="form-control" name="searchValue" placeholder="">
		</div>
		<div class="col-3 d-grid">
			<input type="submit" class="btn btn-primary" value="검색">
		</div>
	</form>
	</div>
</div>
<div class="row justify-content-center">
	<div class="col-10">
		<table class="table">
		  <colgroup>
		  <col width="10%">
		  <col width="20%">
		  <col width="30%">
		  <col width="40%">
		  </colgroup>
		  <thead>
		    <tr>
		      <th scope="col">NO</th>
		      <th scope="col">제목</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${boardList }" var="board">
		    <tr>
		      <th scope="row">${board.boardNum }</th>
		      <td>${board.title }</td>
		      <td>${board.writer }</td>
		      <td>${board.createDate }</td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
</div>
<div class="row">
	<div class="col text-center pagingDiv">
		<!-- pageVO.beginPage = pageVo.getBeginPage(); -->
		<c:if test="${boardVO.prev }">
			<a href="/common/bookBoard?nowPage=${boardVO.beginPage - 1 }">이전</a>
		</c:if>			
		<!-- 페이지 번호를 순서대로 출력하기 위한 for문 -->
		<!-- nowPage=${pageNumber } 현재 사용자가 클릭한 페이지 번호 값을 가져가야 한다. -->
		<c:forEach begin="${boardVO.beginPage }" end="${boardVO.endPage }" var="pageNumber">
		 	<a href="/common/bookBoard?nowPage=${pageNumber }" <c:if test="${boardVO.nowPage eq pageNumber }" >class="selectedPage"</c:if> >${pageNumber }</a>
		</c:forEach>
		<c:if test="${boardVO.next }">
			<a href="/common/bookBoard?nowPage=${boardVO.endPage + 1 }">다음</a>
		</c:if>			
	</div>
</div>

<div class="row">
	<div class="col">
		<nav aria-label="...">
		  <ul class="pagination justify-content-center">
		    <li class="page-item <c:if test="${!boardVO.prev }">disabled</c:if>">
		      <a class="page-link"  href="/common/bookBoard?nowPage=${boardVO.beginPage - 1 }">이전</a>
		    </li>
		    
		    <c:forEach begin="${boardVO.beginPage }" end="${boardVO.endPage }" var="pageNumber">
			    <li class="page-item <c:if test="${boardVO.nowPage eq pageNumber }">active </c:if>"><a class="page-link" href="/common/bookBoard?nowPage=${pageNumber}">${pageNumber }</a></li>
			</c:forEach>
		    
		    <li class="page-item <c:if test="${!boardVO.next }">disabled</c:if>">
		      <a class="page-link" href="/common/bookBoard?nowPage=${boardVO.endPage + 1 }">다음</a>
		    </li>
		  </ul>
		</nav>
	</div>
</div>
</body>
</html>