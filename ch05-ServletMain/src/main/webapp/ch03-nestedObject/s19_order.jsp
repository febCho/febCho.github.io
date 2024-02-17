<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 확인서</title>
</head>
<body>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
	
	//가격 정보
	int[] orderArray = {4000,5000,6000};
	//합계
	int sum = 0;
	//주문 내역
	String orderName = "";
	
	//전송된 데이터 반환
	//짜장면 개수
	int food_c0 = Integer.parseInt(request.getParameter("food_c0"));
	//짬뽕 개수
	int food_c1 = Integer.parseInt(request.getParameter("food_c1"));
	//볶음밥 개수
	int food_c2 = Integer.parseInt(request.getParameter("food_c2"));
	
	if(food_c0 > 0){
		sum += orderArray[0] * food_c0;
		orderName += "짜장면" + food_c0 + "개<br>";
	}
	if(food_c1 > 0){
		sum += orderArray[1] * food_c1;
		orderName += "짬뽕" + food_c1 + "개<br>";
	}
	if(food_c2 > 0){
		sum += orderArray[2] * food_c2;
		orderName += "볶음밥" + food_c2 + "개<br>";
	}
%>
<%=orderName %>
총 지불금액 : <%=String.format("%,d원", sum) %>
</body>
</html>