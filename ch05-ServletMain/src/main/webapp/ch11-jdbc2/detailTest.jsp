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
<title>상품 상세 정보 보기</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<div class="page-main">
	<h2>상품 상세 정보</h2>
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
		
		//JDBC 수행 4단계 : SQL문 실행
		rs = pstmt.executeQuery();
		if(rs.next()){
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int stock = rs.getInt("stock");
			String origin = rs.getString("origin");
			String reg_date = rs.getString("reg_date");
%>
		<ul>
			<li>상품번호 : <%=num %></li>
			<li>상품명 : <%=name %></li>
			<li>판매가 : <%=String.format("%,d원",price) %></li>
			<li>재고수량 : <%=String.format("%,d개",stock) %></li>
			<li>생산지 : <%=origin %></li>
			<li>상품 등록일 : <%=reg_date %></li>
		</ul>
		<hr width="100%" size="1" noshade="noshade">
		<div class="align-right">
			<input type="button" value="상품정보 수정"
				onclick="location.href='updateTestForm.jsp?num=<%=num%>'">
			<input type="button" value="상품정보 삭제"
				onclick="location.href='deleteTestForm.jsp?num=<%=num%>'">
			<input type="button" value="상품 목록 보기"
				onclick="location.href='selectTest.jsp'">		
		</div>
<%			
		}else{
%>
	<div class="result-display">
		<div class="align-center">
			상품 정보가 존재하지 않습니다.<br>
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
			오류 발생으로 상품 정보를 불러오지 못했습니다.<br>
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