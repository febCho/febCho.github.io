package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.DBUtil;

public class UpdateTestMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "UPDATE test1 SET age=? WHERE id=?";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, 19);//1번 ?에 데이터 저장
			pstmt.setString(2, "maltese");//2번 ?에 데이터 저장
			
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블의 데이터 수정
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행의 정보를 수정하였습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
