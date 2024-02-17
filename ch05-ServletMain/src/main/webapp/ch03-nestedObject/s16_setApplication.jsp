<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application에 데이터 저장</title>
</head>
<body>
<%
	String name = "userId";
	String value = "remain";
	//application에 데이터 저장
	                        //속성명, 속성값
	application.setAttribute(name, value);                        
	//application.setAttribute("userId", "remain");
%>
application 기본 객체의 속성 설정 :
<%=name %> = <%=value %>
<%-- <%=application.getAttribute("userId") --%>
</body>
</html>