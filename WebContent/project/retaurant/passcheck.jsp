<%@page import="restaurant.db.RestaurantDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
	//num,pass 를 읽는다
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	
	//dao 선언
	RestaurantDao dao=new RestaurantDao();
	//비번 체크
	boolean b=dao.isPassCheck(num, pass);
		
%>

<result><%=b?"success":"fail"%></result>