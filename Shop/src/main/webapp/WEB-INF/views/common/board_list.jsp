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
</style>
</head>
<body>
<div class="row justify-content-center">
	<div class="col-7">
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
</body>
</html>