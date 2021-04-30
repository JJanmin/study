<%@page import="restaurant.db.RestaurantDto"%>
<%@page import="restaurant.db.RestaurantDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	RestaurantDao dao = new RestaurantDao();
	request.setCharacterEncoding("utf-8");
	
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	String star=request.getParameter("star");
	String content=request.getParameter("content");
	String image=request.getParameter("image");
	String writer=request.getParameter("writer");
	String pass=request.getParameter("pass");
	
	RestaurantDto dto=new RestaurantDto();
	dto.setName(name);
	dto.setAddr(addr);
	dto.setStar(star);
	dto.setContent(content);
	dto.setImage(image);
	dto.setWriter(writer);
	dto.setPass(pass);
	
	dao.insertRestaurant(dto);
%>
