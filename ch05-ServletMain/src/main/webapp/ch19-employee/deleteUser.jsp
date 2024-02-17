<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO" %>
<%@ page import="kr.employee.vo.EmployeeVO" %>
<%
	String user_id = (String)session.getAttribute("user_id");
	if(user_id==null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인이 된 경우
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//전송된 데이터 반환
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//id, 비밀번호 일치 여부 체크
		EmployeeDAO dao = EmployeeDAO.getInstance();
		EmployeeVO vo = dao.checkEmployee(id);
		boolean check = false;
		
		//아이디가 등록되어 있고 로그인한 아이디와 일치할 경우에만
		if(vo!=null && user_id.equals(id)){//user_id: 로그인한 아이디, id: 탈퇴 위해 입력한 아이디
			//비밀번호 일치 여부 체크
			check = vo.isCheckedPassword(passwd);//db의 비번과 탈퇴 위해 입력한 비번을 대조
		}
		if(check){//인증 성공
			//회원 정보 삭제
			dao.deleteEmployee(vo.getSnum());
			//로그아웃
			session.invalidate();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 삭제 완료</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h1>사원 정보 삭제 완료</h1>
	<div class="result-display">
		<div class="align-center">
			사원 정보 삭제를 마쳤습니다.<br>
			<button onclick="location.href='main.jsp'">메인으로</button>
		</div>
	</div>
</div>
</body>
</html>
<%
		}else{//인증 실패
%>
	<script>
		alert('ID 또는 비밀번호가 불일치합니다.');
		history.go(-1);
	</script>
<%
		}
	}
%>