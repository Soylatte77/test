<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
caption {
	caption-side: top;
}
</style>
</head>
<body>
<div class="card-body text-center">
     <h1 class="card-title m-b-0">Category List</h1>
</div>
<table class="table">
	<caption>Add Category</caption>
    <tr>
      <td>NAME</td>
      <td><input type="text" placeholder="Category Name" id="cateName"></td>
      <td><input type="submit" value="Add"></td>
    </tr>
</table>

<table class="table">
  <thead>
    <tr>
      <th scope="col">NO</th>
      <th scope="col">CODE</th>
      <th scope="col">NAME</th>
      <th scope="col">DELETE</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
</body>
</html>