<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ include file="dbInfo.jspf" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보 수정</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<div class="page-main">
	<h2>상품정보 수정</h2>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		//JDBC 수행 1단계 : 드라이버 로드
		Class.forName(driverName);
		//JDBC 수행 2단계 : Connection 객체 생성
		conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
		
		//SQL문 작성
		sql = "SELECT * FROM product WHERE num=?";
		
		//JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//?에 데이터 바인딩
		pstmt.setInt(1,num);
		
		//JDBC 수행 4단계 : SQL문을 테이블에 반영하고 결과 행들을 ResultSet에 담음
		rs = pstmt.executeQuery();
		if(rs.next()){
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int stock = rs.getInt("stock");
			String origin = rs.getString("origin");
%>
	<form id="myForm" action="updateTest.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<ul>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name"
					value="<%=name %>" size="20" maxlength="50">
			</li>
			<li>
				<label for="price">판매가</label>
				<input type="number" name="price" id="price"
					value="<%=price %>" min="1" max="999999999">
			</li>
			<li>
				<label for="stock">재고수량</label>
				<input type="number" name="stock" id="stock"
					value="<%=stock %>" min="1" max="999999999">
			</li>
			<li>
				<label for="origin">생산지</label>
				<input type="text" name="origin" id="orgin"
					value="<%=origin %>" size="20" maxlength="50">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="상품 목록 보기"
				onclick="location.href='selectTest.jsp'">
		</div>
	</form>
<%			
		}else{
%>
	<div class="result-display">
		<div class="align-center">
			수정할 상품 정보가 존재하지 않습니다.<br>
			<input type="button" value="상품 목록 보기"
				onclick="location.href='selectTest.jsp'">
		</div>
	</div>
<%			
		}
	}catch(Exception e){
%>
	<div class="result-display">
		<div class="align-center">
			오류 발생으로 수정할 글 정보를 불러오지 못했습니다.<br>
			<input type="button" value="상품 목록 보기"
				onclick="location.href='selectTest.jsp'">
		</div>
	</div>
<%		
		e.printStackTrace();
	}finally{
		//자원정리
		if(rs!=null)try{rs.close();}catch(SQLException e){}
		if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
		if(conn!=null)try{conn.close();}catch(SQLException e){}
	}
%>	
</div>
</body>
</html>