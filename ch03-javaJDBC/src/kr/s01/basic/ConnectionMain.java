package kr.s01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		//ip 혹은 로컬 호스트 주소를 넣는데 형식 존재
		String db_id = "c##user001";
		String db_password = "1234";
		
		try {
			//JDBC 수행 1단계 : 드라이버를 메모리에 로드
			Class.forName(db_driver);
			//JDBC 수행 2단계 : Connection 객체 생성(오라클 연동)
			Connection conn =
					DriverManager.getConnection(db_url, db_id, db_password);
			System.out.println("Connection 객체가 생성되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
