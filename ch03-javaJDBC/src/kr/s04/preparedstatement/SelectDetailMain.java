package kr.s04.preparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class SelectDetailMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("번호:");
			int num = Integer.parseInt(br.readLine());
			
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM test2 WHERE num = ?";//where절을 통해 행 제한을 하고
            	                                     //num이 pk라 하나의 행만 나옴
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//하나의 행만 나올 거기 때문에 while 대신, 잘못 입력한 경우를 위해 if문 필요
			//JDBC 수행 4단계: SQL문을 실행해서 결과문 하나를 ResultSet에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {//next 메서드가 행 바깥에 있는 커서를 움직이기 때문에
				System.out.println("번호 : " + rs.getInt("num"));
				System.out.println("제목 : " + rs.getString("title"));
				System.out.println("작성자 : " + rs.getString("name"));
				System.out.println("메모 : " + rs.getString("memo"));
				
				String email = rs.getString("email");
				if(email == null) email = "";//null일 경우에는 빈 문자열 대체
				System.out.println("이메일 : " + email);
				
				System.out.println("작성일 : " + rs.getDate("reg_date"));
			}else {//없는 번호를 입력할 경우
				System.out.println("검색된 데이터가 없습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
}
