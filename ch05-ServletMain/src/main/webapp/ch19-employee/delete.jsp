<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO" %>
<%@ page import="kr.story.vo.StoryVO" %>    
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum == null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인 된 경우
	
	StoryDAO dao = StoryDAO.getInstance();
	
	int num = Integer.parseInt(request.getParameter("num"));
	StoryVO vo = dao.getStory(num);
	
	//로그인한 ID의 사번과 글 작성자의 사번이 일치하는지 체크
	if(user_snum != vo.getSnum()){//일치하지 않으면
		response.sendRedirect("notice.jsp");
	}else{//일치하면
		dao.delete(num);
	}
%>
	<script>
		alert('게시글이 삭제되었습니다.');
		location.replace('list.jsp');
	</script>
<%	
	}
%>