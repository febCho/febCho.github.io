<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그아웃
	session.invalidate();
	//main.jsp로 리다이렉트
	response.sendRedirect("main.jsp");
%>