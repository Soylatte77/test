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
	border: 0.5px solid #4b7bec;
}
.list-group-item.active {
	background-color: #4b7bec;
	border: #4b7bec;
}
</style>
</head>
<body>
	<div class="list-group">
		<c:forEach items="${sideMenuList }" var="sideMenuInfo">
			<a href="/admin/${sideMenuInfo.sideMenuPass}" class="list-group-item list-group-item-action 
	  		<c:if test="${sidePage eq sideMenuInfo.sideMenuPass }">active</c:if>" aria-current="true">${sideMenuInfo.sideMenuName }</a>
		</c:forEach>
	</div>
	

</body>
</html>