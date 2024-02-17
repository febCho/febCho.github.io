package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import kr.util.DBUtil;

public class InsertTestMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1, 2단계
			conn = DBUtil.getConnection(); //static한 메서드니까
			
			//SQL문 작성
			sql = "INSERT INTO test1 (id, age) VALUES (?,?)";
			//Statement와 달리 pstmt의 경우 데이터를 SQL문에 직접 입력하지 않는다.
			//?은 특수 문자이며, 자리만 잡아 놓는 것이다.
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//Statement와 달리 객체 생성과 동시에 sql문을 전달함
			
			//?에 데이터를 바인딩
			pstmt.setString(1, "h'ing"); //1번 ?에 데이터를 전달
			pstmt.setInt(2, 42); //2번 ?에 데이터를 전달
			
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 추가
			int count = pstmt.executeUpdate();
			//sql문은 위에서 전달했기 때문에 여기서는 생략
			System.out.println(count + "개 행을 추가했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
