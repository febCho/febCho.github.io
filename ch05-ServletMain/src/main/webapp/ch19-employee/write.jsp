<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO" %>    
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum == null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인 된 경우

	//전송된 데이터 인코딩
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="story" class="kr.story.vo.StoryVO" />
<jsp:setProperty property="*" name="story" />
<%
	//클라이언트의 ip 주소 저장
	story.setIp(request.getRemoteAddr());
	//작성자의 snum 저장
	story.setSnum(user_snum);
	
	StoryDAO dao = StoryDAO.getInstance();
	dao.insert(story);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 완료</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h1>업로드 완료</h1>
	<div class="result-display">
		<div class="align-center">
			작성한 게시글이 업로드되었습니다.<br>
			<button onclick="location.href='list.jsp'">목록</button>
		</div>
	</div>
</div>
</body>
</html>
<%
	}
%>