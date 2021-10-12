<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.btn{
	background-color: #4b7bec;
}
</style>
</head>
<body>
<div class="row">
   <div class="col-10">
      <div class="row">
         <div class="col-5" style="border-bottom: 2px solid #dddddd;">
            <h5>ITEM CATEGORY MANAGE</h5>
         </div>
      </div>
      <div style="height: 30px;"></div>
      <div class="row">
         <div class="col-10">
            <div style="font-size: 12px; color: red; margin-bottom: 5px;">*추가할 상품 카테고리명을 입력하세요.</div>
            	<form action="/admin/insertCate" method="post">
	            <div class="row">
                     <div class="col-8">
                        <div class="input-group mb-3">
                          <span class="input-group-text" id="basic-addon1">CATE_NAME</span>
                          <input type="text" class="form-control" name="cateName" required placeholder="Input here..." aria-label="Username" aria-describedby="basic-addon1">
                        </div>
                     </div>
                     <div class="col-4">
                      <input type="submit" class="btn btn-primary" value=" 추 가 " >
                     </div>
    	          </div>
                </form>
         </div>
      </div>
      <div style="height: 30px;"></div>
      <div class="row">
         <div class="col">
            <table class="table table-striped">
                 <thead>
                   <tr>
                        <th scope="col">NO.</th>
                        <th scope="col">CATE CODE</th>
                        <th scope="col">CATE NAME</th>
                        <th scope="col">DELETE</th>
                   </tr>
                 </thead>
                 <tbody>
                  <c:forEach items="${cateList}" var="cateInfo" varStatus="status">
                   <tr>
                        <th scope="row">${cateList.size() - status.index}</th>
                        <td class="align-middle">${cateInfo.cateCode}</td>
                        <td class="align-middle">${cateInfo.cateName}</td>
                        <td  class="align-middle">
                        	<form action="/admin/deleteCate" method="post">
                        	<input type="hidden" name="cateCode" value="${cateInfo.cateCode}">
                        	<input type="submit" class="btn btn-primary btn-sm" value=" 삭 제 " >
                       		</form>
                        </td>
                   </tr>
                   </c:forEach>
                 </tbody>
            </table>
         </div>
      </div>
   </div>
</div>
</body>
</html>