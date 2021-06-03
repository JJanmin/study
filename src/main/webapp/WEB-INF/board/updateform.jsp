<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<c:if test="${sessionScope.loginok==null}">
	<c:redirect url="../login"/>
</c:if>
<form action="update" method="post" enctype="multipart/form-data">
	<!-- hidden -->
	<input type="hidden" name="num" value="${dto.num}">
	<input type="hidden" name="pageNum" value="${pageNum}">

	<table class="table table-bordered" style="width: 500px;">
		<caption><b>수정</b></caption>
		<tr>
			<th bgcolor="#ddd" width="120">제목</th>
			<td>
			<input type="text" name="subject" value="${dto.subject}"
			class="form-control" required="required">
			</td>
		</tr>
		<tr>
			<th bgcolor="#ddd" width="120">사진</th>
			<td>
			<b>수정이 필요한 경우에만 선택</b>
			<input type="file" name="photo" class="form-control" multiple="multiple" >
			</td>
		</tr>
		<tr>
			<th bgcolor="#ddd" width="120">내용</th>
			<td>
			<textarea name="content" class="form-control" required="required"
			style="width: 350px; height: 100px;">${dto.content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-default" style="width: 120px;">수정</button>
			<button type="button" class="btn btn-default" style="width: 120px;"
			onclick="location.href='history.back()'">이전</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>