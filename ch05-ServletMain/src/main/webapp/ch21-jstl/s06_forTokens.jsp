<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forTokens 태그</title>
</head>
<body>
	<h4>쉼표와 점을 구분자로 사용</h4>
	<c:forTokens var="token"
		items="빨강색,주황색,노란색.초록색.파랑색,남색.보라색" 
			delims=",.">
		${token}<br>
	</c:forTokens>
	<h4>날짜를 연월일시분초로 구분해서 출력</h4>
	<c:forTokens var="now"
				items="2023-05-23 11:12:59" 
				delims="- :">
		${now}<br>
	</c:forTokens>
</body>
</html>