<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO" %>
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum==null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인이 된 경우
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="kr.employee.vo.EmployeeVO" />
<jsp:setProperty property="*" name="vo" />
<%
	//num은 modifyUserForm.jsp에서 전송되지 않았기 때문에
	//세션에 저장된 num을 자바빈 객체에 넣어준 뒤 updateEmployee()에서 꺼내 쓰도록 함
	vo.setSnum(user_snum);
	
	EmployeeDAO dao = EmployeeDAO.getInstance();
	dao.updateEmployee(vo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정 완료</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h1>사원 정보 수정 완료</h1>
	<div class="result-display">
		<div class="align-center">
			사원 정보 수정을 마쳤습니다.<br>
			<button onclick="location.href='myPage.jsp'">MyPage</button>
		</div>
	</div>
</div>
</body>
</html>
<%
	}
%>