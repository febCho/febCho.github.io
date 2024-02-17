<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO" %>
<%@ page import="kr.employee.vo.EmployeeVO" %>    
<%
	//login.jsp에서 로그인 처리 시 세션에 setAttreibute() 했던
	//num을 getAttribute() 하여 레코드 정보를 SELECT 한 뒤 저장한 자바빈에서 정보 꺼낼 예정
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum == null){//로그인이 되어 있지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인 된 경우
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
	EmployeeDAO dao = EmployeeDAO.getInstance();
	EmployeeVO vo = dao.getEmployee(user_snum);
%>
<div class="page-main">
	<h1>사원 정보</h1>
	<ul>
		<li>ID : <%=vo.getId() %></li>
		<li>이름 : <%=vo.getName() %></li>
		<li>비밀번호 : <%=vo.getPasswd() %></li>
		<li>급여 : <%=String.format("%,d원", vo.getSalary())%></li>
		<li>직무 및 직책 : <%=vo.getJob() %></li>
		<li>가입일 : <%=vo.getReg_date() %></li>
	</ul>
	<hr size="1" width="100%" noshade="noshade">
	<div class="align-right">
		<input type="button" value="사원 정보 수정"
			onclick="location.href='modifyUserForm.jsp'">
		<input type="button" value="사원 정보 삭제"
			onclick="location.href='deleteUserForm.jsp'">
		<input type="button" value="메인으로"
			onclick="location.href='main.jsp'">		
	</div>
</div>
</body>
</html>
<%
	}
%>