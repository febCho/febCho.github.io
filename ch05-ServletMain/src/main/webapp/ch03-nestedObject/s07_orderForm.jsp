<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[실습] 상품 구매하기</title>
</head>
<body>
<!-- 
[출력 예시]
이름 : 홍길동
배송희망일 : 2023-11-07
구매 상품 : 가방, 옷
배송비 : 5,000원
총 구매 비용(배송비 포함) : 255,000원
 -->
<form action="s08_order.jsp" method="post">
	이름 <input type="text" name="name"><br>
	배송 희망일 <input type="date" name="order_date"><br>
	상품 (30만원 미만 배송비 5천원 추가)
	<input type="checkbox" name="item" value="가방">가방(20만원)
	<input type="checkbox" name="item" value="신발">신발(10만원)
	<input type="checkbox" name="item" value="옷">옷(5만원)
	<input type="checkbox" name="item" value="식사권">식사권(15만원)
	<br>
	<input type="submit" value="전송">
</form>
</body>
</html>