<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include.jspf" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브</title>
</head>
<body>
<%--
include 디렉티브를 이용하면 JSP 페이지에 또 다른 JSP를 삽입할 수 있음
변수 공유를 목적으로 사용함
 --%>
이미지 경로 : <%= img_path %><br>
파일 경로 : <%=file_path %><br>
</body>
</html>