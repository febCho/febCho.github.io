<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 구매 확인</title>
</head>
<body>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");

	//가격 정보
	HashMap<String,Integer> map = new HashMap<String, Integer>();
	map.put("가방",200000);
	map.put("신발",100000);
	map.put("옷",50000);
	map.put("식사권",150000);
	
	//배송비
	int delivery_fee = 5000;//기본값
	//합계
	int sum = 0;
%>
이름 : <%=request.getParameter("name") %><br>
배송희망일 : <%=request.getParameter("order_date") %><br>
구매 상품 : 
<%
	String[] items = request.getParameterValues("item");
	if(items!=null){
		for(int i=0;i<items.length;i++){
			sum += map.get(items[i]);//전달받은 체크박스 밸류를 key로 map의 밸류를 get
			if(i>0) out.print(", ");//맨 앞의 , 제외
%>
			<%= items[i] %><%-- loop 영역 안에서 루프 돌며 구매 상품 출력 --%>
<%			
		}//end of for
		
		//배송비 처리 - 구매 상품을 하나라도 체크한 경우에만 명시됨
		if(sum < 300000) sum += delivery_fee;
		else delivery_fee = 0;
%>
	<br><%-- 출력은 역시나 표현식 사용을 위해 스크립트릿이 아닌 html 영역에서 --%>
	배송비 : <%=String.format("%,d원", delivery_fee) %><br>
	총 구매 비용(배송비 포함) : <%=String.format("%,d원", sum) %>
<%				
	}//end of (items!=null) if
%>
</body>
</html>