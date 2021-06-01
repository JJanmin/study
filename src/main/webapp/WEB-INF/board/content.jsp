<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<form action="content" method="post" enctype="multipart/form-data">
	<!-- hidden -->
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="pageNum" value="${pageNum}">
	<input type="hidden" name="reg" value="${reg}">
	<input type="hidden" name="restep" value="${restep}">
	<input type="hidden" name="relevel" value="${relevel}">	
	<input type="hidden" name="id" value="${sessionScope.myid}">	
	<input type="hidden" name="writer" value="${name}">

	<table class="table table-bordered" style="width: 500px;">
		<caption><B>내용보기</B></caption>
		<tr>
			<td>
			<span>${dto.subject}</span>
			<span style="float: right;"><fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm" /></span>
			</td>
		</tr>
		<tr>
			<td>
			<span>${dto.writer}(${sessionScope.myid})</span>
			<span style="float: right;">조회수 ${dto.readcount}</span>
			</td>
		</tr>
		<tr>
			<td>
			<span>${dto.content}</span><br>
			<c:forTokens var="s" items="${dto.uploadname}" delims=",">
				<img src="../image/${s}" style="max-width: 300px;">
			</c:forTokens>
			</td>
		</tr>
		<tr>
			<td align="right">
				<c:if test="${sessionScope.loginok!=null}">
					<button type="button" 
					onclick="location.href='form?num=${dto.num}&reg=${dto.reg}&restep=${dto.restep}
					&relevel=${dto.relevel}&pageNum=${pageNum}'">답글쓰기</button>
				</c:if>
				<c:if test="${sessionScope.myid==dto.id}">
					<button type="button" 
					onclick="location.href='updateform?num=${dto.num}&pageNum=${pageNum}'">수정</button>
					<button type="button" 
					onclick="location.href='delete?num=${dto.num}&pageNum=${pageNum}'">삭제</button>
				</c:if>
				
				<button type="button" onclick="location.href='list?pageNum=${pageNum}'">목록</button>
			</td>
			</tr>	
	</table>
</form>
</body>
</html>