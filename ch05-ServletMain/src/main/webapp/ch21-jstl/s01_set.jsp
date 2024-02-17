<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.web.member.Member" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set 태그</title>
</head>
<body>
<%--       속성명        속성값      저장 영역 --%>
<c:set var="msg" value="봄" scope="page"/>
${pageScope.msg}, ${msg}<br>

<%
	Member member = new Member();
%>
<%--자바빈에는 EL이 접근을 못하니까 표현식 사용 --%>
<c:set var="member" value="<%=member %>" />

<c:set target="${member}" property="name" value="홍길동"/>
회원 이름 : ${member.name}, ${member.getName()}<br>
</body>
</html>