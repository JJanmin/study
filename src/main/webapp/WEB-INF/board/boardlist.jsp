<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<!-- 로그인을 해야 만 글쓰기 가능 -->
<c:if test="${sessionScope.loginok!=null}">
<button type="button" class="btn btn-warning" style="margin-left: 300px; width: 120px;"
onclick="location.href='form'">글쓰기</button>
</c:if>
<table class="table table-bordered" style="width: 800px;">
	<caption><b>답변형 게시판</b></caption>
	<tr bgcolor="orange">
		<th width="50">번호</th>
		<th width="350">제목</th>
		<th width="100">작성자</th>
		<th width="120">작성일</th>
		<th width="50">조회</th>
	</tr>
	<c:if test="${totalCount==0}">
		<tr>
			<td colspan="5" align="center">
			<b>저장된 글이 없습니다.</b>
			</td>
		</tr>
	</c:if>
	<c:if test="${totalCount>0}">
		<c:forEach var="dto" items="${list}">
			<tr>
				<td align="center">${no}</td>
				<c:set var="no" value="${no-1}"/>
				<td>
					<!-- 답글인경우relevel만큼 공백 -->
					<c:if test="${dto.relevel>0}">
						<c:forEach var="sp" begin="1" end="${dto.relevel}">
							&nbsp;&nbsp;&nbsp;
						</c:forEach>
						<!-- 답글 이미지 -->
						<img src="../image/re.png">
					</c:if>
					<a href="content?num=${dto.num}&pageNum=${currentPage}&key=list"
					style="color:black; text-decoration:none;">${dto.subject}</a>
					<c:if test="${dto.uploadname!='no'}">
						<span class="glyphicon glyphicon-picture" style="font-size: 0.8em;"></span>
					</c:if>
				</td>
				<td align="center">${dto.writer}</td>
				<td align="center">
				<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td align="center">${dto.readcount}</td>
				</tr>
		</c:forEach>
	</c:if>
</table>
<!-- 페이지번호 -->
<div style="width: 800px; text-align:center;">
	<ul class="pagination">
	<!-- 이전 -->
	<c:if test="${startPage>1}">
		<li><a href="list?pageNum=${startPage-1}">이전</a></li>
	</c:if>
	<!-- 페이지번호 -->
	<c:forEach var="pp" begin="${startPage}" end="${endPage}">
		<c:if test="${currentPage==pp}">
			<li class="active"><a href="list?pageNum=${pp}">${pp}</a>
		</c:if>
	</c:forEach>
	<!-- 다음 -->
	<c:if test="${endPage<totalPage}">
		<li><a href="list?pageNum=${endPage+1}">다음</a></li>
	</c:if>
	</ul>

</div>
</body>
</html>


