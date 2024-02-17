<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO" %>
<%@ page import="kr.employee.vo.EmployeeVO" %>
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum == null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인이 된 경우
%>             
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 수정</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	//이벤트 연결
	$('#modify_form').submit(function(){
		if($('#name').val().trim()==''){
			alert('이름을 입력하세요.');
			$('#name').val('').focus();
			return false;
		}
		if($('#passwd').val().trim()==''){
			alert('비밀번호를 입력하세요.');
			$('#password').val('').focus();
			return false;
		}
		if($('#salary').val().trim()==''){
			alert('급여 정보를 입력하세요.');
			$('#salary').val('').focus();
			return false;
		}
		if($('#job').val().trim()==''){
			alert('직무 및 직책을 입력하세요.');
			$('#job').val('').focus();
			return false;
		}
	});
});
</script>
</head>
<body>
<%
	EmployeeDAO dao = EmployeeDAO.getInstance();
	EmployeeVO vo = dao.getEmployee(user_snum);
%>
<div class="page-main">
	<h1>사원 정보 수정</h1>
	<form action="modifyUser.jsp" method="post" id="modify_form">
		<ul>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name"
					value="<%=vo.getName()%>" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd"
												maxlength="15">
			</li>
			<li>
				<label for="salary">급여</label>
				<input type="number" name="salary" id="salary"
					value="<%=vo.getSalary()%>" min="1" max="99999999">
			</li>
			<li>
				<label for="job">직무 및 직책</label>
				<input type="text" name="job" id="job"
					value="<%=vo.getJob()%>" maxlength="15">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="메인으로"
				onclick="location.href='main.jsp'">
		</div>
	</form>
</div>
</body>
</html>
<%
	}
%>