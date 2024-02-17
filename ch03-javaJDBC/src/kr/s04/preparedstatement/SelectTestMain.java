package kr.s04.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class SelectTestMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성 (num 내림차순)
			sql = "SELECT * FROM test2 ORDER BY num DESC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("번호\t제목\t작성자\t등록일");
			
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("num") + "\t");
				System.out.print(rs.getString("title") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.println(rs.getDate("reg_date"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}
