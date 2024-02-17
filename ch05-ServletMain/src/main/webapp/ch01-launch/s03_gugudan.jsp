<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[실습]구구단 - 5단</title>
</head>
<body>
<!-- 
[출력 예시]
5단
-----------------
5 * 1 = 5
5 * 2 = 10
5 * 3 = 15
 -->
5단<br>
--------------------<br>
<%
	for(int i=1;i<=9;i++){
		out.println(5 + " * " + i + " = " + 5*i + "<br>");
	}
%>
</body>
</html>