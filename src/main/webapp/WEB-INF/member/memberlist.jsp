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
<button type="button" class="btn btn-danger" onclick="location.href='form'">회원가입</button>
<hr>
<table class="table table-bordered" style="width: 800px;">
	<caption><b>회원명단</b></caption>
	<tr bgcolor="orange">
	<th width="100">번호</th>
	<th width="100">이름</th>
	<th width="150">아이디</th>
	<th width="150">휴대폰</th>
	<th width="200">가입일</th>
	<th>수정/삭제</th>
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="i">
		<tr align="center">
			<td>${i.count}</td>
			<td>${dto.name}</td>
			<td>${dto.id}</td>
			<td>${dto.hp}</td>
			<td>
			<fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		<td>
			 <button type="button" class="btn btn-info btn-xs"
			onclick="location.href='updateform?num=${dto.num}'">수정</button> 
			<button type="button" class="btn btn- btn-xs"
			onclick="location.href='delete?num=${dto.num}'">삭제</button>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>