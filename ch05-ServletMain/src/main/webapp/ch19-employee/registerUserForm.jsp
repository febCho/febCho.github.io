<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 등록</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//아이디 중복 체크 결과 -> 0 : 아이디 중복 체크 미실시, 아이디 중복, 1 : 아이디 미중복
	let count = 0;
	
	//이벤트 연결
	$('#confirm_id').click(function(){
		if($('#id').val().trim()==''){
			alert('ID를 입력하세요.');
			$('#id').val('').focus();
			return;
		}
		
		//서버와 통신
		$.ajax({
			url:'confirmId.jsp',
			type:'post',
			data:{id:$('#id').val()},
			dataType:'json',
			success:function(param){
				if(param.result == 'idDuplicated'){
					count = 0;
					$('#id_signed').text('ID 중복').css('color','red');
					$('#id').val('').focus();
				}else if(param.result == 'idNotFound'){
					count = 1;
					$('#id_signed').text('사용 가능한 ID').css('color','black');
				}else{
					count = 0;
					alert('ID 중복 체크 오류 발생');
				}
			},
			error:function(){
				count = 0;
				alert('네트워크 오류 발생');
			}
		});
	});//end of click
	
	$('#register_form').submit(function(){
		if($('#id').val().trim()==''){
			alert('ID를 입력하세요.');
			$('#id').val('').focus();
			return false;
		}
		if(count==0){
			alert('ID 중복 체크는 필수입니다.');
			return false;
		}
		if($('#name').val().trim()==''){
			alert('사원 이름을 입력하세요.');
			$('#name').val('').focus();
			return false;
		}
		if($('#passwd').val().trim()==''){
			alert('비밀번호를 입력하세요.');
			$('#passwd').val('').focus();
			return false;
		}
		if($('#salary').val().trim()==''){
			alert('급여 정보를 입력하세요.');
			$('#salary').val('').focus();
			return false;
		}
		if($('#job').val().trim()==''){
			alert('직무 또는 직책을 입력하세요.');
			$('#job').val('').focus();
			return false;
		}
	});//end of submit
	
	//아이디 입력창에 데이터를 입력하면 중복체크 관련 정보 초기화
	$('#register_form #id').keydown(function(){
		count = 0;
		$('#id_signed').text('');
	});//end of keydown
	
});
</script>
</head>
<body>
<div class="page-main">
	<h1>사원 등록</h1>
	<form action="registerUser.jsp" method="post" id="register_form">
		<ul>
			<li>
				<label for="id">ID</label>
				<input type="text" name="id" id="id"
					size="7" maxlength="15" autocomplete="off">
				<input type="button" id="confirm_id" value="ID 중복 체크">
				<span id="id_signed"></span>	
			</li>
			<li>
				<label for="name">사원 이름</label>
				<input type="text" name="name" id="name"
					maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd"
					maxlength="15">
			</li>
			<li>
				<label for="salary">급여</label>
				<input type="number" name="salary" id="salary"
					min="1" max="99999999">
			</li>
			<li>
				<label for="job">직무 및 직책</label>
				<input type="text" name="job" id="job"
					maxlength="15">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="메인으로"
				onclick="location.href='main.jsp'">
		</div>
	</form>
</div>
</body>
</html>