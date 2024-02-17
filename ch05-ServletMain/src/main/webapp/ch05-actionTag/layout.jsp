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
<title>페이지 모듈화</title>
<style type="text/css">
table{
	border-collapse:collapse;
	border:1px solid #000000;
	width:500px;
	margin:0 auto;
}
td{
	border:1px solid #000000;
	text-align:center;
	vertical-align:middle;
	height:40px;
}
td.td-middle{
	text-align:left;
	vertical-align:top;
	height:200px;
}
td.td-width{
	width:100px;
}
</style>
</head>
<body>
<table>
	<tr>
		<td colspan="2">
			<%--include 태그의 내용으로 html 주석 또는 JSP 주석 전부 사용 불가 --%>
			<jsp:include page="/ch05-actionTag/module/top.jsp">
				<jsp:param value="코리아 홈쇼핑" name="company"/>
			</jsp:include>
		</td>
	</tr>
	<tr>
		<td class="td-middle td-width">
			<jsp:include page="/ch05-actionTag/module/left.jsp"/>
		</td>
		<td class="td-middle">
			<!-- 내용 시작 -->
			레이아웃1
			<!-- 내용 시작 -->
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<jsp:include page="/ch05-actionTag/module/bottom.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>