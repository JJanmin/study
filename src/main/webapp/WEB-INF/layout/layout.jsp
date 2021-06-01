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
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding:400" rel="stylesheet">
<style type="text/css">
	div.layout{
		border: 0px solid gray;
		font-family: 'Nanum Gothic Coding';
	}
	
	div.title{
		font-size: 33pt;
		text-align: center;
		font-weight: bold;
	}
	
	div.menu{
		font-size: 25pt;
		text-align: center;
		font-weight: bold;
	}
	
	div.layout a{
		color: black;
		text-decoration: none;
	}
	
	div.info{
		position: absolute;
		left: 30px;
		top: 200px;
		width: 140px;
		height: 230px;
		border: 2px solid gray;
		text-align: center;
		font-size: 14pt;
		padding: 20px 20px;
	}
	
	div.main{
		position: absolute;
		left: 300px;
		top: 160px;
		width: 1200px;
		height: 700px;
		font-size: 15pt;
	}
</style>
</head>
<body>
<div class="layout title">
	<tiles:insertAttribute name="title"/>
</div>
<div class="layout menu">
	<tiles:insertAttribute name="menu"/>
</div>
<div class="layout info">
	<tiles:insertAttribute name="info"/>
</div>
<div class="layout main">
	<tiles:insertAttribute name="main"/>
</div>
</body>
</html>
