<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 생성</title>
</head>
<body>
계정이 생성되었습니다.<br>
<ul>
	<li>아이디 : ${vo.id}</li>
	<li>이름 : ${vo.name}</li>
	<li>우편번호 : ${vo.zipcode}</li>
	<li>주소 : ${vo.address1} ${vo.address2}</li>
</ul>
</body>
</html>