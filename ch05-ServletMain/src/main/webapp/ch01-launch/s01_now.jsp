<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.Date" %> 
<%@page import = "java.text.SimpleDateFormat" %>
<%
	//객체 생성
	Date now = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년MM월dd일 a hh:mm:ss");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 날짜와 시간</title>
</head>
<body>
현재 날짜와 시간 : <%= now %> 입니다.
<br>
-----------------------------------
<br>
현재 날짜와 시간 : <%= sf.format(now) %> 입니다.
</body>
</html>