<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<a href="${root}/home">Home</a>&nbsp;&nbsp;
<a href="${root}/login">Login</a>&nbsp;&nbsp;
<a href="${root}/member/list">Member</a>&nbsp;&nbsp;
<a href="${root}/board/list">Board</a>&nbsp;&nbsp;

</body>
</html>