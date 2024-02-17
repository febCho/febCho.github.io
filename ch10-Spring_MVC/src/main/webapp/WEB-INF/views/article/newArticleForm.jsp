<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
</head>
<body>
게시글 쓰기 입력 폼
<form action="newArticle.do" method="post">
	<input type="hidden" name="parentId" value="1">
	제목 : <input type="text" name="title"><br>
	내용 : <textarea rows="5" cols="30" name="content"></textarea>
	<input type="submit" value="전송">
</form>
</body>
</html>