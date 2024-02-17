<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>    
<%@ include file="dbInfo.jspf"%>    
<%
	//전송된 데이터 인코딩
	request.setCharacterEncoding("utf-8");
	//전송된 데이터 반환
	int id = Integer.parseInt(request.getParameter("id"));
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	try{
		//JDBC 수행 1단계 : 드라이버 로드
		Class.forName(driverName);
		//JDBC 수행 2단계 : Connection 객체 생성
		conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
		//SQL문 작성
		sql = "DELETE FROM todo WHERE id=?";
		//JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//?에 데이터 바인딩
		pstmt.setInt(1, id);
		//JDBC 수행 4단계 : SQL문 실행
		pstmt.executeUpdate();
%>
		{"result":"success"}
<%		
	}catch(Exception e){
%>
		{"result":"failure"}
<%		
		e.printStackTrace();
	}finally{
		//자원 정리
		if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
		if(conn!=null)try{conn.close();}catch(SQLException e){}
	}
%>