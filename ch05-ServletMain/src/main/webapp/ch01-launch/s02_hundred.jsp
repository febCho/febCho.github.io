<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 100까지의 합</title>
</head>
<body>
<%
	int total = 0;
	for(int i=1;i<=100;i++){
		total += i;
	}
	//출력
	out.println("1부터 100까지의 합 : " + total);
%>
</body>
</html>