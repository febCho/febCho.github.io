<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어(EL) 예제</title>
</head>
<body>
<table border="1" style="width:40%;">
	<tr>
		<th>표현식</th>
		<th>값</th>
	</tr>
	<tr>
		<td>\${2+5}</td>
		<td>${2+5}</td>
	</tr>
	<tr>
		<td>\${"10" + 5}</td>
		<td>${"10" + 5}</td>
	</tr>
	<tr>
		<td>\${"10" + "5"}</td>
		<td>${"10" + "5"}</td>
	</tr>
	<tr>
		<td>\${"십" + 5}</td>
		<td>에러발생(EL에서의 + 는 연산만)</td>
	</tr>
	<tr>
		<td>\${4/5}</td>
		<td>${4/5}</td>
	</tr>
	<tr>
		<td>\${5/0}</td>
		<td>${5/0}</td>
	</tr>
	<tr>
		<td>\${2+=5}</td>
		<td>${2+=5}(문자열로 연결)</td>
	</tr>
	<tr>
		<td>\${"한국"+="서울"}</td>
		<td>${"한국"+="서울"}(문자열로 연결)</td>
	</tr>
</table>
</body>
</html>