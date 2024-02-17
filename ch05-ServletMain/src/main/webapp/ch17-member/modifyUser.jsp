<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.member.dao.MemberDAO" %>
<%
	Integer user_num = (Integer)session.getAttribute("user_num");
	if(user_num==null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인이 된 경우
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
%>
<jsp:useBean id="member" class="kr.member.vo.MemberVO"/>
<jsp:setProperty name="member" property="*"/>
<%
	//num이 전송되지 않았기 때문에 session에 저장된 num을 사용
	member.setNum(user_num);
	
	MemberDAO dao = MemberDAO.getInstance();
	dao.updateMember(member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 완료</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h1>회원정보 수정 완료</h1>
	<div class="result-display">
		<div class="align-center">
			회원정보 수정 완료<br>
			<button onclick="location.href='myPage.jsp'">MyPage</button>
		</div>
	</div>
</div>
</body>
</html>
<%
	}
%>