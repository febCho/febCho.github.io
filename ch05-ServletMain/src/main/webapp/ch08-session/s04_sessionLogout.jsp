<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<%
	//세션 안의 모든 속성을 제거해서 세션을 갱신
	session.invalidate();
%>
로그아웃했습니다.<br>
<br>
	<input type="button" value="로그인 체크"
		onclick="location.href='s05_sessionLoginCheck.jsp'">
	<input type="button" value="로그인"
		onclick="location.href='s02_sessionLoginForm.jsp'">
</body>
</html>