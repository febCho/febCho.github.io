<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>    
<%
	Cookie cookie = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
	
	//쿠키 유효 시간 지정(단위 : 초)
	//쿠키 유효시간을 지정하면 클라이언트 영역에 파일을 생성해서 쿠키 정보 보관
	//쿠키 유효시간을 지정하지 않으면 메모리에 쿠키 정보를 보관
	//cookie.setMaxAge(30*60);
	//cokie.setMaxAge(-1);//메모리에 쿠키 정보 보관
	
	//생성한 쿠키를 클라이언트로 전송
	response.addCookie(cookie);
%>    
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>
    <%--    쿠키명                        쿠키값 --%>
<%=cookie.getName() %> = <%= cookie.getValue() %>
</body>
</html>