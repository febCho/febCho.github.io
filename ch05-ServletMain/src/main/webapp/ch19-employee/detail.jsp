<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO" %>
<%@ page import="kr.story.vo.StoryVO" %>    
<%
	//글 번호
	int num = Integer.parseInt(request.getParameter("num"));
	StoryDAO dao = StoryDAO.getInstance();
	StoryVO vo = dao.getStory(num);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h1><%=vo.getTitle() %></h1>
	<ul>
		<li>글 번호 : <%=vo.getNum() %></li>
		<li>작성자 : <%=vo.getId() %></li>
	</ul>
	<hr size="1" noshade="noshade" width="100%">
	<p>
		<%=vo.getContent() %>
	</p>
	<hr size="1" noshade="noshade" width="100%">
	<div class="align-right">
	작성일 : <%=vo.getReg_date() %>
	<input type="button" value="목록"
					onclick="location.href='list.jsp'">
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	//로그인한 ID의 사번과 글 작성자의 사번이 일치하는지 체크
	if(user_snum!=null && user_snum == vo.getSnum()){
%>
		<input type="button" value="수정"
					onclick="location.href='updateForm.jsp?num=<%=num%>'">
		<input type="button" value="삭제" id="delete_btn">
		<script type="text/javascript">
			let delete_btn = document.getElementById('delete_btn');
			//이벤트 연결
			delete_btn.onclick = function(){
				let choice = confirm('삭제하시겠습니까?');
				if(choice){
					location.replace('delete.jsp?num=<%=num%>');
				}
			};
		</script>
	</div>	
</div>
</body>
</html>
<%
		}		
%>