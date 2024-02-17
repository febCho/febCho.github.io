<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO" %>
<%@ page import="kr.story.vo.StoryVO" %>  
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum == null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인 된 경우
	
	int num = Integer.parseInt(request.getParameter("num"));
	StoryDAO dao = StoryDAO.getInstance();
	StoryVO vo = dao.getStory(num);
	
	//로그인한 ID의 사번과 글 작성자의 사번이 일치하는지 체크
	if(user_snum != vo.getSnum()){//일치하지 않으면
		response.sendRedirect("notice.jsp");
	}else{//일치하면
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
window.onload = function(){
	let myForm = document.getElementById('update_form');
	//이벤트 연결
	myForm.onsubmit = function(){
		let items = document.querySelectorAll('input[type="text"],textarea');
			for(let i=0;i<items.length;i++){
				if(items[i].value.trim()==''){
					let label = document.querySelector('label[for="' + items[i].id + '"]');
					alert(label.textContent + ' 항목은 필수 입력');
					items[i].value = '';
					items[i].focus();
					return false;
				}
			}
	};
};
</script>
</head>
<body>
<div class="page-main">
	<h1>게시글 수정</h1>
	<form id="update_form" action="update.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" size="30"
					value="<%=vo.getTitle() %>" maxlength="50">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" 
					id="content"><%=vo.getContent() %></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록"
				onclick="location.href='list.jsp'">
		</div>
	</form>
</div>
</body>
</html>
<%
	}
	}	
%>