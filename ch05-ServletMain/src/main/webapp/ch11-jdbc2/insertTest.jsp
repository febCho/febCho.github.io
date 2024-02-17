<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ include file="dbInfo.jspf" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 처리</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
	//전송된 데이터 반환
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	String origin = request.getParameter("origin");
	
	//DB 연동
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	try{
		//JDBC 수행 1단계 : 드라이버 로드
		Class.forName(driverName);
		//JDBC 수행 2단계 : Connection 객체 생성
		conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
		
		//SQL문 작성
		sql = "INSERT INTO product (num,name,price,stock,origin,reg_date) VALUES (product_seq.nextval,?,?,?,?,SYSDATE)";
		
		//JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//?에 데이터 바인딩
		pstmt.setString(1,name);
		pstmt.setInt(2,price);
		pstmt.setInt(3,stock);
		pstmt.setString(4,origin);
		
		//JDBC 수행 4단계 : SQL문 실행
		pstmt.executeUpdate();
%>
	<div class="result-display">
		<div class="align-center">
			상품이 등록되었습니다.<br>
			<input type="button" value="상품 목록 보기"
				onclick="location.href='selectTest.jsp'">
		</div>
	</div>
<%		
	}catch(Exception e){
%>
	<div class="result-display">
		<div class="align-center">
			오류 발생으로 상품 등록에 실패하였습니다.<br>
			<input type="button" value="상품 등록하기"
				onclick="location.href='insertTestForm.jsp'">
		</div>
	</div>
<%		
		e.printStackTrace();
	}finally{
		//자원 정리
		if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
		if(conn!=null)try{conn.close();}catch(SQLException e){}
	}
%>
</body>
</html>