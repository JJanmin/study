<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<form action="update" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${dto.num}">
	<table class="table table-bordered" style="width: 400px;">
		<caption><b>상품 수정</b></caption>
		 <tr>
		 	<th bgcolor="tomato" width="100"> 상품명 </th>
		 	<td>
		 		<input type="text" class="form-control" name="sangpum" required="required" placeholder="상품명" value="${dto.sangpum}">
		 	</td>
		 </tr>
		 <tr>
		 	<th bgcolor="tomato" width="100"> 색상 </th>
		 	<td>
		 		<input type="color" class="form-control" name="color" value="${dto.color}">
		 	</td>
		 </tr>
		 <tr>
		 	<th bgcolor="tomato" width="100"> 상품사진 </th>
		 	<td>
		 		<b>사진 수정을 원할경우에만 선택해주세요</b>
		 		<input type="file" class="form-control" name="upload" multiple="multiple" >
		 	</td>
		 </tr>
		 <tr>
		 	<th bgcolor="tomato" width="100"> 가격 </th>
		 	<td>
		 		<input type="text" class="form-control" name="price" required="required" 
		 		style="width: 150px;"placeholder="가격" value="${dto.price}">
		 	</td>
		 </tr>
		 <tr>
		 	<th bgcolor="tomato" width="100"> 입고일 </th>
		 	<td>
		 		<input type="date" class="form-control" name="ipgoday" value="${dto.ipgoday}">
		 	</td>
		 </tr>
		 <tr>
		 	<td colspan="2" align="center">
		 	<button type="submit" class="btn btn-info" style="width: 100px;">상품수정</button>
		 	<button type="button" class="btn btn-success" style="width: 100px;"
		 	onclick="location.href='list'">상품목록</button>
		 	</td>
		 </tr>
	</table>
</form>
</body>
</html>