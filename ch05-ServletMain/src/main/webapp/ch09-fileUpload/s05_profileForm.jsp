<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 업로드 폼</title>
<script type="text/javascript">
window.onload = function(){
	let image = document.getElementById('image');//face.png 이미지
	let submit_btn = document.getElementById('submit_btn');
	
	//파일을 선택할 때
	let file = document.getElementById('file');
	//이벤트 연결
	file.onchange = function(){
		if(!file.files[0]){//선택한 파일이 없을 경우
			image.src='/ch05-ServletMain/images/face.png';//원래 이미지 그대로
			submit_btn.style.display = 'none';//계속 submit 버튼은 안 보이게
			return;//함수를 빠져나가 if문 아래 코드들이 실행되지 않도록
		}
		
		//정상적으로 파일을 선택한 경우
		const reader = new FileReader();
		reader.readAsDataURL(file.files[0]);//file에서 컨텐츠를 읽어오는 역할
		reader.onload = function(){//다 읽어 오게 되면 load 이벤트 트리거
			image.src = reader.result;//문자열 데이터가 result 속성에 담겨 있음
			submit_btn.style.display = '';
		};
	};
};
</script>
</head>
<body>
<h2>프로필 사진 업로드하기</h2>
<img id="image" src="/ch05-ServletMain/images/face.png"
                width="200" height="200">
<form action="s06_profile.jsp" method="post"
              enctype="multipart/form-data">
	<input type="file" name="file" id="file"
	                   accept="image/png,image/jpeg,image/gif">
	<input type="submit" value="전송" style="display:none" 
										id="submit_btn">
</form>                
</body>
</html>