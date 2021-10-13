<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.main{
	background-color: #dddddd;
}
</style>
</head>
<body>
<div>
</div>
<div class="row justify-content-center" >
	<div class="col-12 main">
	<form class="row g-3"  action="/admin/regItem" method="post" enctype="multipart/form-data">
		<div class="col-6">
			<label for="cateName">Category Name</label>
			<select class="form-select" aria-label="Default select example" id="cateName" name="cateCode">
		    	<option>Select Category Name</option>
		    	<c:forEach items="${list }" var="cateInfo">
					<option value="${cateInfo.cateCode }" >${cateInfo.cateName }</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-12">
			  <label for="itemName" class="form-label">Item Name</label>
              <input type="text" name="itemName" class="form-control" id="itemName" placeholder="input here...">
		</div>
		<div class="col-12">
			  <label for="itemPrice" class="form-label">Item Price</label>
              <input type="text" name="itemPrice" class="form-control" id="itemPrice" placeholder="input here...">
		</div>
		<div class="col-12">
			<div class="mb-3">
			  <label for="formFile" class="form-label">Representative Picture</label>
			  <input class="form-control" type="file" name="file1" id="formFile" >
			</div>
			<div class="mb-3">
			  <label for="formFileMultiple" class="form-label">Additional Picture</label>
			  <input class="form-control" type="file" name="file2" id="formFileMultiple" multiple>
			</div>
		</div>
		<div class="col-12 text-center">
        	<input type="submit" class="btn btn-primary" value="REGISTRATION">
        </div>
	</form>
	</div>
</div>
</body>
</html>