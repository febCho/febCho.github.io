<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<div class="page-main">
	<h2>글 삭제</h2>
	<p class="align-center">
		<span>정말 삭제하시겠습니까?</span>
	</p>
	<form action="deleteTest.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<div class="align-center">
			<input type="submit" value="삭제">
			<input type="button" value="목록 보기"
				onclick="location.href='selectTest.jsp'">
		</div>
	</form>
</div>
</body>
</html>