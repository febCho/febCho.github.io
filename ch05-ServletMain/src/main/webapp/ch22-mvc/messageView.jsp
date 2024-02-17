<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뷰</title>
</head>
<body>
결과 : <%= request.getAttribute("result")%><br>
결과 : ${requestScope.result}<br>
결과 : ${result}
</body>
</html>