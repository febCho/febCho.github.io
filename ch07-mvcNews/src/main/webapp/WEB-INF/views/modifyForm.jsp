<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript">
window.onload = function(){
	let myForm = document.getElementById('modify_form');
	myForm.onsubmit = function(){
		let items = document.querySelectorAll('.input-check');
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
	<h2>뉴스 수정</h2>
	<form id="modify_form" action="modify.do" method="post"
											enctype="multipart/form-data">
		<input type="hidden" name="num" value="${vo.num}">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title"
					size="30" maxlength="50" value="${vo.title}" class="input-check">
			</li>
			<li>
				<label for="writer">작성자</label>
				<input type="text" name="writer" id="writer"
					size="10" maxlength="10" value="${vo.writer}" class="input-check">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd"
					size="12" maxlength="12" class="input-check">	
				*등록 시 입력한 비밀번호 입력
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email" id="email"
					size="30" maxlength="50" value="${vo.email}" class="input-check">
			</li>
			<li>
				<label for="article">내용</label>
				<textarea rows="5" cols="40" name="article" 
					id="article" class="input-check">${vo.article}</textarea>
			</li>
			<li>
				<label for="filename">이미지</label>
				<input type="file" name="filename" id="filename"
											accept="image/gif,image/png,image/jpeg">
				<br>							
				<img src="${pageContext.request.contextPath}/upload/${vo.filename}"
											width="80px" style="margin-left:100px">							
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록"
						onclick="location.href='list.do'">
		</div>
	</form>
</div>
</body>
</html>