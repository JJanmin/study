<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<div class="title">
	<tiles:insertAttribute name="title"/>
</div>
<div class="menu">
	<tiles:insertAttribute name="menu"/>
</div>
<div class="info">
	<tiles:insertAttribute name="info"/>
</div>
<div class="main">
	<tiles:insertAttribute name="main"/>
</div>
</body>
</html>
