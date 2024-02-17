<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="page-main">
	<h2>뉴스 목록</h2>
	<div class="align-right">
		<input type="button" value="등록"
				onclick="location.href='registerForm.do'">
	</div>
	<c:if test="${count == 0}">
	<div class="result-display">
		등록된 기사가 없습니다.
	</div>	
	</c:if>
	<c:if test="${count > 0}">
	<table>
		<tr>
			<th>등록번호</th>
			<th>기사 제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>	
		<c:forEach var="news" items="${list}">
		<tr>
			<td>${news.num}</td>
			<td><a href="detail.do?num=${news.num}">${news.title}</a></td>
			<td>${news.writer}</td>
			<td>${news.reg_date}</td>
		</tr>	
		</c:forEach>
	</table>
	<div class="align-center">
		${page}
	</div>
	</c:if>
</div>
</body>
</html>