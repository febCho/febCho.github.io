<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");

	//가격 정보
	int[] orderArray = {200000,100000,50000,150000};
	//배송비
	int delivery_fee = 5000;
	//합계
	int sum = 0;

%>
이름 : <%=request.getParameter("name") %><br>
배송희망일 : <%=request.getParameter("order_date") %><br>
구매 상품 :
<%
	//구매 상품
	String[] items = request.getParameterValues("item");
	if(items!=null){
		for(int i=0;i<items.length;i++){
			if(i>0) out.print(", ");
%>
		<%=items[i] %>
<%			
			//합계 구하기
			if(items[i].equals("가방")){
				sum += orderArray[0];
			}
			if(items[i].equals("신발")){
				sum += orderArray[1];
			}
			if(items[i].equals("옷")){
				sum += orderArray[2];
			}
			if(items[i].equals("식사권")){
				sum += orderArray[3];
			}
			
		}//end of for
		
		//배송비 처리
		if(sum < 300000) sum += delivery_fee;
		else delivery_fee = 0;
%>
	<br>
	배송비 : <%=String.format("%,d원", delivery_fee) %><br>
	총 구매 비용(배송비 포함) : <%=String.format("%,d원", sum) %>
<%	
	}

%>
</body>
</html>