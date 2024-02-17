package kr.s08.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

/*
 * DAO : Data Access Object
 *       데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체
 */

public class MemoDAO {
	//글쓰기
	public void insertMemo(String name, String passwd,
			               String subject, String content,
			               String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "INSERT INTO memo (num, name, passwd, subject,"
					                 + "content, email, reg_date) VALUES"
					+ "(memo_seq.nextval, ?,?,?,?,?, SYSDATE)";
			
			//JDBC 수행 3단계 : PreparedStement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			
			//JDBC 수행 4단계 : SQL문 실행
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 글을 작성하였습니다.]");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//목록 보기
	public void selectMemo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM memo ORDER BY num DESC";
			
			//JDBC 수행 3단계 : PreparedStement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//JDBC 수행 4딘계 : SQL문을 실행해서 결과행들을 ResultSet에 담음
			rs = pstmt.executeQuery();
			System.out.println("===============================");
			if(rs.next()) {
				System.out.println("글번호\t이름\t작성일\t제목");
				do {
					System.out.print(rs.getInt("num") + "\t");
					System.out.print(rs.getString("name") + "\t");
					System.out.print(rs.getDate("reg_date") + "\t");
					System.out.println(rs.getString("subject"));
				}while(rs.next());
			}else {
				System.out.println("[등록된 데이터가 없습니다.]");
			}
			System.out.println("===============================");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//상세글 보기
	public void selectDetailMemo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM memo WHERE num=?";
			
			//JDBC 수행 3단계: PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//JDBC 수행 4단계 : SQL문을 실행해서 한 건의 레코드를 ResultSet에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("글번호: " + rs.getInt("num"));
				System.out.println("이름:" + rs.getString("name"));
				System.out.println("비밀번호:" + rs.getString("passwd"));
				System.out.println("제목:" + rs.getString("subject"));
				System.out.println("내용:" + rs.getString("content"));
				
				String email = rs.getString("email");
				if(email == null) email="";
				System.out.println("이메일:" + email);
				
				System.out.println("작성일:" + rs.getDate("reg_date"));
			}else {
				System.out.println("[검색한 정보가 없습니다.]");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//글 수정
	public void updateMemo(int num, String name, String passwd,
			               String subject, String content,
			               String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "UPDATE memo SET name=?, passwd=?, subject=?,"
					+ "content=?, email=? WHERE num=?";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//?에 데이터 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			pstmt.setInt(6, num);
			
			//JDBC 수행 4단계 : SQL문 실행
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 글을 수정하였습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//글 삭제
	public void deleteMemo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "DELETE FROM memo WHERE num=?";
			
			//JDBC 수행 3단계: PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//JDBC 수행 4단계 : SQL문 실행
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 글이 삭제되었습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
