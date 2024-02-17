<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[실습]성적처리 - 스크립트릿과 표현식</title>
</head>
<body>
<!-- 
배열 생성(score) 국어, 영어, 수학
[출력 예시]
국어 : 88
영어 : 99
수학 : 86
총점 : 273
평균 : 91
 -->
<%
	String[] cours = {"국어", "영어", "수학"};
	int[] score = {88,99,86};
	int sum = 0;
	int avg = 0;
	
	for(int i=0;i<score.length;i++){
%>
	<%=cours[i] %> : <%=score[i] %><br>
<%		
	sum += score[i];
	}
	avg = sum / score.length;
%>
<%-- 
국어 : <%= score[0] %><br>
영어 : <%= score[1] %><br>
수학 : <%= score[2] %><br>
--%>
총점 : <%= sum %><br>
평균 : <%= avg %>
</body>
</html>