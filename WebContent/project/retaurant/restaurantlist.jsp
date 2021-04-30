<?xml version="1.0" encoding="UTF-8"?>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="restaurant.db.RestaurantDto"%>
<%@page import="java.util.List"%>
<%@page import="restaurant.db.RestaurantDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<list>
<%
	/*//start를 읽는다
	int start=0;
	try{
		start=Integer.parseInt(request.getParameter("start"));
	}catch(NumberFormatException e){
		start=1;
		System.out.println("페이지 start 정수로 변환시 오류: "+e.getMessage());
	}*/
	//dao 선언
	RestaurantDao dao=new RestaurantDao();
	//목록 가져오기
	List<RestaurantDto> list=dao.getAllDatas();
	//전체 갯수 구하기
	int total=dao.getTotalCount();
	%>
	<total><%=total%></total>
	<%
	for(RestaurantDto dto:list)
	{%>
		<restaurant num="<%=dto.getNum()%>">
			<name><%=dto.getName()%></name>
			<addr><%=dto.getAddr()%></addr>
			<star><%=dto.getStar()%></star>
			<image><%=dto.getImage()%></image>
			<writer><%=dto.getWriter()%></writer>
		</restaurant>
	<%}
%>
</list>