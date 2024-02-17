<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h3>구매 상세</h3>
		<table>
			<tr>
				<th>상품명</th>
				<th>수량</th>
				<th>상품 가격</th>
				<th>합계</th>
			</tr>
			<c:forEach var="detail" items="${detailList}">
			<tr>
				<td>${detail.item_name}</td>
			<td class="align-center"><fmt:formatNumber value="${detail.order_quantity}"/></td>
			<td class="align-center"><fmt:formatNumber value="${detail.item_price}"/>원</td>
			<td class="align-center"><fmt:formatNumber value="${detail.item_total}"/>원</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="3" class="align-right"><b>총 구매 금액</b></td>
				<td class="align-center"><fmt:formatNumber value="${order.order_total}"/>원</td>
			</tr>
		</table>
		<ul>
			<li><span>받는 사람 : ${order.receive_name}</span></li>
			<li><span>우편번호 : ${order.receive_post}</span></li>
			<li><span>주소 : ${order.receive_address1} ${order.receive_address2}</span></li>
			<li><span>전화번호 : ${order.receive_phone}</span></li>
			<li><span>남기실 말씀 : ${order.notice}</span></li>
			<li>
				<span>결제수단 : 
				<c:if test="${order.payment == 1}">무통장 입금</c:if>
				<c:if test="${order.payment == 2}">카드 결제</c:if>
			</span>
			</li>
			<li>
				<span>배송 상태 : 
				<c:if test="${order.status == 1}">배송 대기</c:if>
				<c:if test="${order.status == 2}">배송 준비 중</c:if>
				<c:if test="${order.status == 3}">배송중</c:if>
				<c:if test="${order.status == 4}">배송 완료</c:if>
				<c:if test="${order.status == 5}">주문 취소</c:if>
			</span>
			</li>
			<li class="align-center">
				<c:if test="${order.status == 1}">
					<input type="button" value="배송정보 수정"
						onclick="location.href='orderModifyForm.do?order_num=${order.order_num}'">
					<input type="button" value="주문 취소" id="order_cancel">
					<script type="text/javascript">
						let order_cancel = document.getElementById('order_cancel');
						order_cancel.onclick = function(){
							let choice = confirm('주문을 취소하시겠습니까?');
							if(choice){
								location.href='orderCancel.do?order_num=${order.order_num}';
							}
						};
					</script>
				</c:if>
				<input type="button" value="MY페이지" 
					onclick="location.href='${pageContext.request.contextPath}/member/myPage.do'">
				<input type="button" value="구매 목록"
					onclick="location.href='orderList.do'">
			</li>
		</ul>
	</div>
</div>
</body>
</html>