<%@page import="restaurant.db.RestaurantDto"%>
<%@page import="restaurant.db.RestaurantDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	request.setCharacterEncoding("utf-8");
	
	String num=request.getParameter("unum");
	String name=request.getParameter("uname");
	String addr=request.getParameter("uaddr");
	String star=request.getParameter("ustar");
	String content=request.getParameter("ucontent");
	String image=request.getParameter("uimage");
	String writer=request.getParameter("uwriter");
	String pass=request.getParameter("upass");
	
	RestaurantDto dto=new RestaurantDto();
	dto.setNum(num);
	dto.setName(name);
	dto.setAddr(addr);
	dto.setStar(star);
	dto.setContent(content);
	dto.setImage(image);
	dto.setWriter(writer);
	dto.setPass(pass);
	
	RestaurantDao dao = new RestaurantDao();
	dao.updateRestaurant(dto);
%>
