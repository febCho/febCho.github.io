<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum==null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인이 된 경우
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 삭제 폼</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
window.onload = function(){
	let myForm = document.getElementById('delete_form');
	//이벤트 연결
	myForm.onsubmit = function(){
		let id = document.getElementById('id');
		if(id.value.trim()==''){
			alert('ID를 입력하세요.');
			id.value = '';
			id.focus();
			return false;
		}
		let passwd = document.getElementById('passwd');
		if(passwd.value.trim()==''){
			alert('비밀번호를 입력하세요.');
			passwd.value = '';
			passwd.focus();
			return false;
		}
		let cpasswd = document.getElementById('cpasswd');
		if(cpasswd.value.trim()==''){
			alert('확인용 비밀번호를 입력하세요.');
			cpasswd.value = '';
			cpasswd.focus();
			return false;
		}
		//비밀번호와 비밀번호 확인 일치여부 체크
		if(passwd.value != cpasswd.value){
			alert('비밀번호와 확인용 비밀번호가 불일치합니다.');
			cpasswd.value = '';
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
	<h1>사원 정보 삭제</h1>
	<form id="delete_form" action="deleteUser.jsp" method="post">
		<ul>
			<li>
				<label for="id">ID</label>
				<input type="text" name="id" id="id" maxlength="15">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd"
												maxlength="15">
			</li>
			<li>
				<label for="cpasswd">비밀번호 확인</label>
				<input type="password" name="cpasswd" id="cpasswd"
												maxlength="15">
			</li>
		</ul>
		<div class="align-center">
		*사원 정보 삭제 시, 작성한 게시글도 모두 삭제됩니다.<br><br>
			<input type="submit" value="확인">
			<input type="button" value="메인으로"
				onclick="location.href='main.jsp'">
		</div>
	</form>
</div>
</body>
</html>
<%
	}
%>