<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.member.dao.MemberDAO" %>
<%@ page import="kr.member.vo.MemberVO" %>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");

	//자바빈(VO) 생성
	/*
	MemberVO member = new MemberVO();
	member.setId(request.getParameter("id"));
	member.setName(request.getParameter("name"));
	member.setPasswd(request.getParameter("passwd"));
	member.setEmail(request.getParameter("email"));
	member.setPhone(request.getParameter("phone"));
	*/
%>
<%-- 자바빈(VO) 생성 --%>
<jsp:useBean id="member" class="kr.member.vo.MemberVO"/>
<%--request로부터 전송된 데이터 읽어들여 자바빈에 저장 --%>
<jsp:setProperty property="*" name="member"/>

<%	
	//MemberDAO 객체 생성
	MemberDAO dao = MemberDAO.getInstance();
	dao.insertMember(member);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h1>회원가입 완료</h1>
	<div class="result-display">
		<div class="align-center">
			회원가입 성공!<br>
			<button onclick="location.href='main.jsp'">홈으로</button>
		</div>
	</div>
</div>
</body>
</html>