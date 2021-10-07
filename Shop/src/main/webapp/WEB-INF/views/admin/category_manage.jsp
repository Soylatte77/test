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
   <div class="col-12">
      <div class="row" style="margin-top: 10px;">
         <div class="col-5" style="border-bottom: 2px solid #dddddd;">
            <h5>ITEM CATEGORY MANAGE</h5>
         </div>
      </div>
      <div style="height: 30px;"></div>
      <div class="row">
         <div class="col-10">
            <div style="font-size: 12px; color: red; margin-bottom: 5px;">*추가할 상품 카테고리명을 입력하세요.</div>
            <div class="row">
                     <div class="col-8">
                        <div class="input-group mb-3">
                          <span class="input-group-text" id="basic-addon1">ITEM_NAME</span>
                          <input type="text" class="form-control" placeholder="Input here..." aria-label="Username" aria-describedby="basic-addon1">
                        </div>
                     </div>
                     <div class="col-4">
                      <input type="button" class="btn btn-primary" value=" 추 가 " >
                     </div>
               </div>
         </div>
      </div>
      <div style="height: 30px;"></div>
      <div class="row">
         <div class="col">
            <table class="table table-striped">
                 <thead>
                   <tr>
                        <th scope="col">NO</th>
                        <th scope="col">CODE</th>
                        <th scope="col">NAME</th>
                        <th scope="col">DELETE</th>
                   </tr>
                 </thead>
                 <tbody>
                  <c:forEach items="${cateList }" var="cateList" varStatus="status">
                   <tr>
                        <th scope="row"></th>
                        <td class="align-middle">${cateList.cateCode}</td>
                        <td class="align-middle">${cateList.cateName }</td>
                        <td  class="align-middle"><input type="button" class="btn btn-primary btn-sm" value=" 삭 제 " ></td>
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