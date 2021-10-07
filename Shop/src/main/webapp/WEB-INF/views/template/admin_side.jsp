<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="list-group">
  <a href="/admin/categoryManage" class="list-group-item list-group-item-action 
  	<c:if test="${sidePage eq 'categoryManage'}">active</c:if>" aria-current="true">
    	카테고리 관리
  </a>
  <a href="/admin/regItem" class="list-group-item list-group-item-action  
  	<c:if test="${sidePage eq 'regItem'}">active</c:if>">
  		상품 등록
  </a>
  <a href="/admin/itemManage" class="list-group-item list-group-item-action 
  	<c:if test="${sidePage eq 'itemManage'}">active</c:if>">상품 관리</a>
</div>
</body>
</html>