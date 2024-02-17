<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL의 내장객체</title>
</head>
<body>
<%
	pageContext.setAttribute("msg", "봄");
	request.setAttribute("msg2", "여름");
	session.setAttribute("msg3", "가을");
	application.setAttribute("msg4", "겨울");
	
	String str = "겨울왕국";
%>
page 영역 : <%=pageContext.getAttribute("msg") %>, ${pageScope.msg}, ${msg}<br>
request 영역 : <%=request.getAttribute("msg2") %>, ${requestScope.msg2}, ${msg2}<br>
session 영역 : <%=session.getAttribute("msg3") %>, ${sessionScope.msg3}, ${msg3}<br>
application 영역 : <%=application.getAttribute("msg4") %>, ${applicationScope.msg4}, ${msg4}<br>
str의 값 : <%=str %>, ${str}
</body>
</html>