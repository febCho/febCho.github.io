package kr.s02.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableMain {
	public static void main(String[] args) {
		//자바에서 create, alter, drop문장 모두 사용 가능
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "c##user001";
		String db_password = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1단계 : 드라이버 로드
			Class.forName(db_driver);
			//JDBC 수행 2단계 : Connection 객체 생성
			conn = DriverManager.getConnection(db_url, db_id, db_password);
			System.out.println("test1 테이블을 생성합니다.");
			/*
			 * 테이블을 생성하는 SQL문
			 * 접속한 계정(c##user001)에 테이블명이 중복되면 에러가 발생하기 때문에
			 * 동일 계정에서는 한 번만 수행함
			 */
			//대소문자 구분 없기 때문에 다 대문자, 다 소문자도 가능(구분 편리 위함)
			sql = "CREATE TABLE test1 (id VARCHAR2(10), age NUMBER)";
			
			//JDBC 수행 3단계 : Statement 객체 생성
			//oracle에 정보를 전달하는 메서드가 존재
			stmt = conn.createStatement();
			
			//JDBC 수행 4단계 : SQL문을 실행해서 DB에 테이블을 생성
			stmt.executeUpdate(sql);
			
			System.out.println("테이블이 정상적으로 생성되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			if(stmt!=null)try {stmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	}
}
