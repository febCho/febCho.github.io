<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ include file="dbInfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<div class="page-main">
	<h2>게시판 목록</h2>
	<div class="align-right">
		<input type="button" value="글쓰기"
			onclick="location.href='insertTestForm.jsp'">
	</div>
<%
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
		sql = "SELECT * FROM tboard ORDER BY num DESC";
		
		//JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		
		//JDBC 수행 4단계 : SQL문을 테이블에 반영하고 결과행들을 ResultSet에 담음
		rs = pstmt.executeQuery();
%>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
<%
	while(rs.next()){
		int num = rs.getInt("num");
		String name = rs.getString("name");
		String title = rs.getString("title");
		Date reg_date = rs.getDate("reg_date");
%>
	<tr>
		<td><%=num %></td>
		<td><a href="detailTest.jsp?num=<%=num%>"><%=title %></a></td>
		<td><%=name %></td>
		<td><%=reg_date %></td>
	</tr>
<%		
	}
%>
		</table>
<%		
	}catch(Exception e){
%>
	<div class="result-display">
		<span>오류 발생</span>
	</div>
<%
		e.printStackTrace();
	}finally{
		//자원 정리
		if(rs!=null)try{rs.close();}catch(SQLException e){}
		if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
		if(conn!=null)try{conn.close();}catch(SQLException e){}
	}
%>	
</div>
</body>
</html>