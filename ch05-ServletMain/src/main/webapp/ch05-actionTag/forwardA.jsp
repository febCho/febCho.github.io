<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드 테스트</title>
</head>
<body>
forwardA.jsp 페이지. 보여지지 않습니다.
</body>
</html>
<%
	//전송된 데이터 인코딩
	request.setCharacterEncoding("utf-8");
%>
<jsp:forward page="forwardB.jsp">
	<jsp:param value="집 갈래" name="wish"/>
</jsp:forward>