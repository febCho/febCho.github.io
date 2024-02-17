<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="kr.member.dao.MemberDAO" %>
 <%@ page import="kr.member.vo.MemberVO" %>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
	//전송된 데이터 반환
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	MemberDAO dao = MemberDAO.getInstance();
	//id 존재 여부 확인
	MemberVO member = dao.checkMember(id);
	boolean check = false;
	
	if(member!=null){//id 존재
		//사용자가 입력한 비밀번호와 DB에 저장된 비밀번호 일치 여부 확인
		check = member.isCheckedPassword(passwd);
	}
	
	if(check){//id와 비밀번호 인증 성공
		//로그인 처리
		session.setAttribute("user_num", member.getNum());
		session.setAttribute("user_id", id);
		//main.jsp로 리다이렉트
		response.sendRedirect("main.jsp");
	}else{//id 또는 비밀번호 인증 실패
%>
	<script>
		alert('아이디 또는 비밀번호가 불일치합니다.');
		history.go(-1);
	</script>
<%		
	}
%>