<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#photo_btn').click(function(){
		$('#photo_choice').show();
		$(this).hide();//수정 버튼 감추기
	});
	
	//이미지 미리 보기
	//처음 화면에 보여지는 이미지 읽기
	let photo_path = $('.my-photo').attr('src');
	$('#photo').change(function(){
		let my_photo = this.files[0];
		if(!my_photo){
			//선택을 취소하면 원래 이미지로 되돌림
			$('.my-photo').attr('src',photo_path);
			return;
		}
		if(my_photo.size > 1024*1024){
			alert(Math.round(my_photo.size/1024)
						+ 'kbytes(1024kbytes까지만 업로드 가능)');
			//용량 제한에 걸리면 원래 이미지로 되돌림
			$('.my-photo').attr('src',photo_path);
			$(this).val('');//선택한 파일 정보 지우기
			return;
		}
		//화면에서 이미지 미리 보기
		const reader = new FileReader();
		reader.readAsDataURL(my_photo);
		
		reader.onload = function(){
			$('.my-photo').attr('src',reader.result);
		};
	});//end of change
	
	//이미지 전송
	$('#photo_submit').click(function(){
		if($('#photo').val()==''){
			alert('파일을 선택하세요!');
			$('#photo').focus();
			return;
		}
		//파일 전송
		const form_data = new FormData();
		/*
		자바스크립트로 호출 document.getElementById('photo').files[0]
		-> 그 태그가 가지고 있는 배열 객체에서 하나만 보내니까 인덱스 0
		jquery로 호출 $('#photo')[0].files[0]
		jquery는 모든 태그를 다 배열로 인식하기 때문에 태그가 하나라고 하더라도 [0] 붙여 접근
		그 다음 파일을 배열로 처리하니까 한 번 더 [0]
		*/
		form_data.append('photo',$('#photo')[0].files[0]);
		$.ajax({
			url:'updateMyPhoto.do',
			type:'post',
			data:form_data,
			dataType:'json',
			contentType:false,//데이터 객체를 문자열로 바꿀지에 대한 값 : true 일반문자
			processData:false,//해당 타입을 true로 하면 일반 text로 구분
			success:function(param){
				if(param.result == 'logout'){
					alert('로그인 후 사용하세요!');
				}else if(param.result == 'success'){
					alert('프로필 사진이 수정되었습니다.');
					//수정된 이미지 정보 저장
					photo_path = $('.my-photo').attr('src');
					$('#photo').val('');
					$('#photo_choice').hide();
					$('#photo_btn').show();//수정 버튼 표시
				}else{
					alert('파일 전송 오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});//end of ajax
	});//end of click
	
	//이미지 미리보기 취소
	$('#photo_reset').click(function(){
		//초기 이미지 표시
		$('.my-photo').attr('src',photo_path);//이미지 미리 보기 전 이미지로 되돌리기
		$('#photo').val('');
		$('#photo_choice').hide();
		$('#photo_btn').show();//수정 버튼 표시
	});
});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h2>회원정보</h2>
		<div class="mypage-div">
			<h3>프로필 사진</h3>
			<ul>
				<li>
					<c:if test="${empty member.photo}">
					<img src="${pageContext.request.contextPath}/images/face.png" width="200" height="200" class="my-photo">
					</c:if>
					<c:if test="${!empty member.photo}">
					<img src="${pageContext.request.contextPath}/upload/${member.photo}" width="200" height="200" class="my-photo">
					</c:if>
				</li>
				<li>
					<div class="align-center">
						<input type="button" value="수정" id="photo_btn">
					</div>
					<div id="photo_choice" style="display:none;">
						<input type="file" id="photo" accept="image/gif,image/png,image/jpeg"><br>
						<input type="button" value="전송" id="photo_submit">
						<input type="button" value="취소" id="photo_reset">
					</div>
				</li>
			</ul>
			<h3>
				연락처
				<input type="button" value="연락처 수정"
					onclick="location.href='modifyUserForm.do'">
			</h3>
			<ul>
				<li>이름 : ${member.name}</li>
				<li>전화번호 : ${member.phone}</li>
				<li>이메일 : ${member.email}</li>
				<li>우편번호 : ${member.zipcode}</li>
				<li>주소 : ${member.address1} ${member.address2}</li>
				<li>가입일 : ${member.reg_date}</li>
				<c:if test="${!empty member.modify_date}">
				<li>최근 정보 수정일 : ${member.modify_date}</li>
				</c:if>
			</ul>
			<h3>
				비밀번호 수정
				<input type="button" value="비밀번호 수정"
					onclick="location.href='modifyPasswordForm.do'">
			</h3>
			<h3>
				회원탈퇴
				<input type="button" value="회원 탈퇴"
					onclick="location.href='deleteUserForm.do'">
			</h3>
		</div>
		<div class="mypage-div">
			<h3>관심 게시물 목록</h3>
			<table>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="board" items="${boardList}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/board/detail.do?board_num=${board.board_num}" target="_blank">${fn:substring(board.title,0,12)}</a></td>
					<td>${board.id}</td>
					<td>${board.reg_date}</td>
				</tr>
				</c:forEach>
			</table>
			<h3>상품 구매 목록 <input type="button" value="구매 목록 보기"
				onclick="location.href='${pageContext.request.contextPath}/order/orderList.do'">
			</h3>
			<ul>
				<c:forEach var="order" items="${orderList}">
				<li>
					<div>
						<a href="${pageContext.request.contextPath}/order/orderDetail.do?order_num=${order.order_num}">
							${order.order_num} ${order.item_name} (${order.reg_date})
							<c:if test="${order.status == 1}">배송 대기</c:if>
							<c:if test="${order.status == 2}">배송 준비중</c:if>
							<c:if test="${order.status == 3}">배송중</c:if>
							<c:if test="${order.status == 4}">배송 완료</c:if>
							<c:if test="${order.status == 5}">주문 취소</c:if>
						</a>
					</div>
				</li>
				</c:forEach>
			</ul>
			
		</div>
		<div class="mypage-end"></div>
	</div>
</div>
</body>
</html>