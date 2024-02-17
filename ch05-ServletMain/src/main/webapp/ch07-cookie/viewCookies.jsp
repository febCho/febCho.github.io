<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 목록</title>
</head>
<body>
쿠키 목록<br>
<%
	//클라이언트로부터 전송된 쿠키 정보를 반환
	Cookie[] cookies = request.getCookies();
	if(cookies!=null && cookies.length>0){
		for(int i=0;i<cookies.length;i++){
%>
	<%=cookies[i].getName() %> = 
	<%=URLDecoder.decode(cookies[i].getValue(),"utf-8") %><br>
<%			
		}
	}else{
%>
쿠키가 존재하지 않습니다.
<%		
	}
%>
</body>
</html>