<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
이름은 <%=name%>이고 나이는 <%=age%>살입니다.