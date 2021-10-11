<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.list-group-item{
	border: 2px solid #4b7bec;
}
.list-group-item.active {
	background-color: #4b7bec;
	border: #4b7bec;
}
</style>
</head>
<body>
<c:choose>
	<c:when test="${sidePage eq 'categoryManage' or sidePage eq 'regItem' or sidePage eq 'itemManage'}" >
	<div class="list-group">
	  <a href="/admin/categoryManage" class="list-group-item list-group-item-action 
	  	<c:if test="${sidePage eq 'categoryManage'}">active</c:if>" aria-current="true">카테고리 관리</a>
	  	
	  <a href="/admin/regItem" class="list-group-item list-group-item-action  
	  	<c:if test="${sidePage eq 'regItem'}">active</c:if>">상품 등록</a>
	  	
	  <a href="/admin/itemManage" class="list-group-item list-group-item-action 
	  	<c:if test="${sidePage eq 'itemManage'}">active</c:if>">상품 관리</a>
	</div>
	</c:when>
	
	<c:when test="${sidePage eq 'memberList' or sidePage eq 'memberManage'}" >
	<div class="list-group">
	  <a href="/admin/memberManage" class="list-group-item list-group-item-action  
	  	<c:if test="${sidePage eq 'memberManage'}">active</c:if>">회원 관리</a>
	  	
	  <a href="/admin/memberList" class="list-group-item list-group-item-action 
	  	<c:if test="${sidePage eq 'memberList'}">active</c:if>" aria-current="true">회원 목록</a>
	  	
	</div>
	</c:when>
	

</c:choose>
</body>
</html>