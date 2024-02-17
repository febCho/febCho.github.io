<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 기사</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="page-main">
	<h1>${vo.title}</h1>
	<ul>
		<li>등록 번호 : ${vo.num}</li>
		<li>작성자 : ${vo.writer}</li>
	</ul>
	<hr size="1" noshade="noshade" width="100%">
	<br>
	<div class="align-center">
		<img src="${pageContext.request.contextPath}/upload/${vo.filename}"
				style="max-width:500px">
	</div>
	<p>
		${vo.article}
	</p>
	이메일 : ${vo.email}
	<hr size="1" noshade="noshade" width="100%">
	<div class="align-right">
		작성일 : ${vo.reg_date}
		<input type="button" value="수정"
				onclick="location.href='modifyForm.do?num=${vo.num}'">
		<input type="button" value="삭제"
				onclick="location.href='deleteForm.do?num=${vo.num}'">
		<input type="button" value="목록"
					onclick="location.href='list.do'">		
	</div>
	<br><br>
</div>
</body>
</html>