<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO" %>
<%@ page import="kr.employee.vo.EmployeeVO" %>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
	//전송된 데이터 반환
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	EmployeeDAO dao = EmployeeDAO.getInstance();
	//id 존재 여부 확인 - id를 조건으로 DB에 저장된 레코드가 있으면 자바빈 객체 생성하는 작업 동일
	EmployeeVO vo = dao.checkEmployee(id);
	boolean check = false;
	
	if(vo!=null){//id 존재
		//사용자가 입력한 비밀번호와 DB에 저장된 비밀번호 일치 여부 확인
		check = vo.isCheckedPassword(passwd);
	}
	if(check){//id와 비밀번호 인증 성공(DB에 모두 존재)
		//로그인 처리
		session.setAttribute("user_snum", vo.getSnum());
		session.setAttribute("user_id", id);//로그인 시 main.jsp에서 이를 활용
		//main.jsp로 리다이렉트
		response.sendRedirect("main.jsp");
	}else{//id 또는 비밀번호 인증 실패
%>
	<script>
		alert('ID 또는 비밀번호가 불일치합니다.');
		history.go(-1);
	</script>
<%		
	}
%>