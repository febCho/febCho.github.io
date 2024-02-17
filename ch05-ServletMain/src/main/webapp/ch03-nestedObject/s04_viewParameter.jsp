<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
 %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>
<body>
<h2>request.getParameter()</h2>
name 파라미터 = <%= request.getParameter("name") %><br>
address 파라미터 = <%= request.getParameter("address") %><br>

<h2>request.getParameterValues()</h2>
<% 
	String[] values = request.getParameterValues("pet");
	if(values!=null){
		for(int i=0;i<values.length;i++){
%>
	<%=values[i] /*루프 내 영역에 위치*/%><br>
<%		
		}
	}
%>

</body>
</html>