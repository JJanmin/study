<?xml version="1.0" encoding="UTF-8"?>
<%@page import="restaurant.db.RestaurantDto"%>
<%@page import="restaurant.db.RestaurantDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<%
	//dao선언
	RestaurantDao dao = new RestaurantDao();
	//num 읽기
	String num=request.getParameter("num");
	//getData 호출 dto 받기
	RestaurantDto dto=dao.getData(num);

%>
<num><%=dto.getNum()%></num>
<name><%=dto.getName()%></name>
<addr><%=dto.getAddr()%></addr>
<star><%=dto.getStar()%></star>
<content><%=dto.getContent()%></content>
<writer><%=dto.getWriter()%></writer>
<pass><%=dto.getPass()%></pass>

</data>