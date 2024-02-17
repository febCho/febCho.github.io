<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>    
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
	HashMap<String, Integer> price = new HashMap<String, Integer>();
	price.put("짜장면",4000);
	price.put("짬뽕",5000);
	price.put("볶음밥",6000);
	
	//합계
	int sum = 0;
	//주문 내역
	String orderName = "";
	
	//전송된 데이터 반환
	//짜장면 개수
	int c0 = Integer.parseInt(request.getParameter("food_c0"));
	//짬뽕 개수
	int c1 = Integer.parseInt(request.getParameter("food_c1"));
	//볶음밥 개수
	int c2 = Integer.parseInt(request.getParameter("food_c2"));
	
	if(c0 > 0){
		sum += c0 * price.get("짜장면");
		orderName += "짜장면 " + c0 + "개<br>";
	}
	if(c1 > 0){
		sum += c1 * price.get("짬뽕");
		orderName += "짬뽕 " + c1 + "개<br>";
	}
	if(c2 > 0){
		sum += c2 * price.get("볶음밥");
		orderName += "볶음밥 " + c2 + "개<br>";
	}
%>
<%= orderName %>
총 지불금액 : <%=String.format("%,d원", sum) %>

</body>
</html>