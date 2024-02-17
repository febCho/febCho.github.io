<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
window.onload = function(){
	let myForm = document.getElementById('delete_form');
	//이벤트 연결
	myForm.onsubmit = function(){
		let passwd = document.getElementById('passwd');
		if(passwd.value.trim()==''){
			alert('비밀번호를 입력하세요');
			passwd.value = '';
			passwd.focus();
			return false;
		}
	};
};
</script>
</head>
<body>
<div class="page-main">
	<h1>글 삭제</h1>
	<form id="delete_form" action="delete.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<ul>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="12"
													maxlength="12">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글 삭제">
			<input type="button" value="목록"
					onclick="location.href='list.jsp'">
		</div>
	</form>
</div>
</body>
</html>