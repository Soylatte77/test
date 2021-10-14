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
<div class="row">
	<!-- List<ImgVO>.get(0) = imgVO -->
	<c:forEach items="${itemList}" var="itemInfo">
	<div class="col-2">
		<div class="card" style="width: 18rem;">
		  <img src="/resources/images/${itemInfo.imgList[0].attachedImgName }" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">${itemInfo.itemName }</h5>
		    <p class="card-text">${itemInfo.itemContent }</p>
		    <p class="card-text">${itemInfo.itemPrice }</p>
		  </div>
		</div>
	</div>
	</c:forEach>
</div>
</body>
</html>
