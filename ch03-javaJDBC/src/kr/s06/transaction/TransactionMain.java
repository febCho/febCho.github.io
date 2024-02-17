package kr.s06.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.util.DBUtil;

public class TransactionMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//트랜잭션을 수동 처리하기 위해 auto commit 해제
			conn.setAutoCommit(false);
			
			//SQL문 작성
			//? 처리 해주어야 하는데 코드가 너무 길어져서 여기선 예외로 걍 씀
			sql = "INSERT INTO test1 VALUES('amy', 15)";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.executeUpdate();//이렇게만 하면 정상임
			
			sql = "INSERT INTO test1 VALUES('victoria', 18)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES('anna', 27";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.executeUpdate();
			
			//정상적으로 작업이 완료되면 commit
			conn.commit();
			
			System.out.println("작업 완료!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			//예외가 발생하였을 경우 ROLLBACK
			try {
				conn.rollback();
			}catch(SQLException se) {//e가 지역변수라 충돌나서 se로 변경
				se.printStackTrace();
			}
		}finally {
			//자원 정리
			DBUtil.executeClose(null, pstmt3, conn);
			DBUtil.executeClose(null, pstmt2, conn);
			DBUtil.executeClose(null, pstmt1, conn);
		}
	}
}
