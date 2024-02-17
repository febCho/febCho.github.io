<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Date" %>
<%@ include file="dbInfo.jspf" %>    
[<%
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
		sql = "SELECT * FROM todo ORDER BY id DESC";
		//JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//JDBC 수행 4단계 : SQL문 실행
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			int id = rs.getInt("id");
			String todo = rs.getString("todo");
			Date created = rs.getDate("created");
			int completed = rs.getInt("completed");
			
			if(rs.getRow()>1){
				out.print(",");
			}
%>
			{
				"id":<%=id %>,
				"todo":"<%=todo %>",
				"created":"<%=created %>",
				"completed":<%=completed %>
			}
<%			
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//자원정리
		if(rs!=null)try{rs.close();}catch(SQLException e){}
		if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
		if(conn!=null)try{conn.close();}catch(SQLException e){}
	}
 %>]
