<?xml version="1.0" encoding="UTF-8"?>
<%@page import="restaurant.db.RestaurantDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//num,pass 를 읽는다
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	
	//dao 선언
	RestaurantDao dao=new RestaurantDao();
	//비번 체크
	boolean b=dao.isPassCheck(num, pass);
	if(b){
		dao.deleterestaurant(num);//비번이 맞을경우 글 삭제
	}	
%>

<result><%=b?"success":"fail"%></result>