<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum == null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인 된 경우
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
window.onload = function(){
	let myForm = document.getElementById('write_form');
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
	<h1>게시글 작성하기</h1>
	<form id="write_form" action="write.jsp" method="post">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" size="30"
												maxlength="50">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" 
												id="content"></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="작성">
			<input type="button" value="목록"
							onclick="location.href='list.jsp'">		
		</div>
	</form>

</div>
</body>
</html>
<%
	}
%>