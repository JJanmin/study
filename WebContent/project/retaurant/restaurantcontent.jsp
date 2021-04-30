<%@page import="org.json.simple.JSONObject"%>
<%@page import="restaurant.db.RestaurantDto"%>
<%@page import="restaurant.db.RestaurantDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String num=request.getParameter("num");
	RestaurantDao dao=new RestaurantDao();
	RestaurantDto dto=dao.getData(num);
	
	JSONObject ob=new JSONObject();
	ob.put("num",dto.getNum());
	ob.put("name",dto.getName());
	ob.put("addr",dto.getAddr());
	ob.put("writer",dto.getWriter());
	ob.put("star",dto.getStar());
	ob.put("content",dto.getContent());
	ob.put("image",dto.getImage());
	
	
%>
<%=ob.toString()%>