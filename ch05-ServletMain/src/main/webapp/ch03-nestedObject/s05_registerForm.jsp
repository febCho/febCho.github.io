<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[실습]회원가입</title>
</head>
<body>
<%--
[실습]회원가입 폼
input type="text" - 이름(name), ID(id), 전화번호(phone),
input type="password" - 비밀번호(password),
input type="checkbox" - 취미(hobby - 영화보기, 음악감상, 등산, 낚시, 춤), 
textarea - 자기소개
[출력 예시]
이름 : 홍길동
ID : dragon
비밀번호 : 1234
전화번호 : 010-1234-5678
취미 : 영화보기,춤
자기소개 : 서울에서 태어나서 서울에서 거주
 --%>
<form action="s06_register.jsp" method="post">
	<h2>회원가입 폼</h2>
	이름 <input type="text" name="name" size="10"><br>
	ID <input type="text" name="id" size="30"><br>
	비밀번호 <input type="password" name="password" size="30"><br>
	전화번호 <input type="text" name="phone" size="30"><br>
	취미
	<input type="checkbox" name="hobby" value="영화 보기">영화 보기
	<input type="checkbox" name="hobby" value="음악 감상">음악 감상
	<input type="checkbox" name="hobby" value="등산하기">등산
	<input type="checkbox" name="hobby" value="낚시">낚시
	<input type="checkbox" name="hobby" value="춤 추기">춤
	<br>
	자기소개<br>
	<textarea name="introduce" rows="5" cols="60" maxlength="1000"></textarea><br>
<input type="submit" value="전송">
</form>
</body>
</html>