package kr.s11.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class BookDAO {
	//관리자 도서 등록
	public void insertBook(String bk_name, String bk_category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO book (bk_num, bk_name, bk_category)"
					+ "VALUES (book_seq.nextval, ?,?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, bk_name);
			pstmt.setString(2, bk_category);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "권의 도서를 등록하였습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//관리자 도서 목록
	public void selectBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM book ORDER BY bk_regdate ASC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			
			System.out.println("========================================");
			if(rs.next()) {
				System.out.println("번호\t도서명\t카테고리\t등록일");
				do {
					System.out.print(rs.getInt("bk_num") + "\t");
					System.out.print(rs.getString("bk_name") + "\t");
					System.out.print(rs.getString("bk_category") + "\t");
					System.out.println(rs.getDate("bk_regdate"));
				}while(rs.next());
			}else {
				System.out.println("[등록된 도서가 없습니다.]");
			}
			System.out.println("========================================");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//관리자 회원 목록
	public void selectMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM member ORDER BY me_regdate DESC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("========================================");
			if(rs.next()) {
				System.out.println("아이디\t이름\t전화번호\t가입일");
				do {
					System.out.print(rs.getString("me_id") + "\t");
					System.out.print(rs.getString("me_name") + "\t");
					System.out.print(rs.getString("me_phone") + "\t");
					System.out.println(rs.getDate("me_regdate"));
				}while(rs.next());
			}else {
				System.out.println("[등록된 회원 정보가 없습니다.]");
			}
			System.out.println("========================================");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//관리자 대출 목록 보기(대출 및 반납 - 모든 데이터 표시)
	public void selectReservation() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			sql = "SELECT bk_num, re_status, me_id, re_regdate, re_modifydate, "
					+ "bk_name, bk_category FROM reservation JOIN book "
					+ "USING(bk_num) ORDER BY re_num ASC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			System.out.println("========================================");
			if(rs.next()) {
				System.out.println("도서 번호\t대출 여부\t대출자 id\t대출일\t반납일\t도서명\t분류");
				do {
					System.out.print(rs.getInt("bk_num") + "\t");
					System.out.print(rs.getInt("re_status") + "\t");
					System.out.print(rs.getString("me_id") + "\t");
					System.out.print(rs.getDate("re_regdate") + "\t");
					System.out.print(rs.getDate("re_modifydate") + "\t");
					System.out.print(rs.getString("bk_name") + "\t");
					System.out.println(rs.getString("bk_category"));
				}while(rs.next());
			}else {
				System.out.println("[도서 예약 내역이 존재하지 않습니다.]");
			}
			System.out.println("========================================");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//관리자 도서 등록 취소
	public void deleteBook(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "DELETE FROM book WHERE bk_num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, bk_num);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println("[선택하신 도서 " + count + "권의 정보를 삭제하였습니다.]");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//사용자 아이디 중복 체크(ID 중복 시 1, 미중복 시 0 반환)
	public int checkId(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;//중복 여부를 넘겨줄 변수
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT me_id FROM member WHERE me_id=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = 1;
			}//count는 이미 초기화 시켰으니, 중복되지 않은 경우에는 그냥 return하고
			//중복될 경우에만 count = 1로 바꾸어 반환하기
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}
	
	//사용자 회원가입
	public void insertmember(String me_id, String me_name,
				             String me_passwd, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO member (me_id, me_name, me_passwd, me_phone)"
					+ "VALUES (?, ?, ?, ?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_name);
			pstmt.setString(3, me_passwd);
			pstmt.setString(4, me_phone);
			//JDBC 수행 4단계
			pstmt.executeUpdate();
			System.out.println("회원가입이 완료되었습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
		
	}
	//사용자 로그인 체크(로그인 성공 시 true, 실패 시 false 반환)
	public boolean loginCheck(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Boolean flag = false;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT me_id FROM member WHERE me_id=? AND me_passwd=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;//select로 하나의 행을 반환하는데 성공하면 true = 로그인 성공
			}
			return flag;//행이 없다면 기존에 대입된 false 반환
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return flag;
	}
	
	//사용자 도서 대출 여부 확인(대출 중이면 대출 불가, 도서번호(bk_num)로 검색해서 re_status의 값이 0
	//이면 대출 가능, 1이면 대출 불가능)
	public int checkStatus(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int re_status = 0;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT bk_num FROM reservation WHERE bk_num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, bk_num);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				re_status = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return re_status;
	}
	//사용자 도서 대출 등록
	public void checkOut(int re_status, int bk_num, String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO reservation (re_num, re_status, bk_num, me_id)"
					+ "VALUES (reservation_seq.nextval, ?,?,?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1,re_status);
			pstmt.setInt(2, bk_num);
			pstmt.setString(3, me_id);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println("[도서 " + count + "권이 대출되었습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//사용자 MY 대출 목록 보기(현재 대출한 목록만 표시)
	public void myCheckOut(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM reservation JOIN book "
					+ "USING(bk_num) WHERE me_id=? AND re_modifydate IS NULL "
					+ "ORDER BY re_regdate ASC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("========================================");
			if(rs.next()) {
				System.out.println("대출번호\t도서명\t대출일");
				do {
					System.out.print(rs.getInt("re_num") + "\t");
					System.out.print(rs.getString("bk_name") + "\t");
					System.out.println(rs.getDate("re_regdate"));
				}while(rs.next());
			}else {
				System.out.println("[현재 대출 중인 도서가 없습니다.]");
			}
			System.out.println("========================================");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//사용자 도서 반납 가능 여부(대출 번호(re_num)과 회원id(me_id)를 함께 조회해서
	//re_status의 값이 1인 것은 반납 가능, re_status가 0이면 반납 불가능)
	public int checkReturn(int re_num, String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int re_status = 0;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT re_num, me_id FROM reservation "
					+ "WHERE re_num=? AND me_id=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, re_num);
			pstmt.setString(2, me_id);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			if(rs.next()) {
				re_status = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return re_status;
	}
	//사용자 도서 반납 처리
	public void returnBook(String me_id, int re_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "UPDATE reservation SET re_status = 0, re_modifydate = SYSDATE "
					+ "WHERE me_id=? AND re_num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			pstmt.setInt(2, re_num);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println("[도서 " + count + "권이 반납되었습니다.]");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//탈퇴 가능 여부 체크 1. 대출 목록 확인
	public void checkList(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT bk_name, re_regdate FROM reservation JOIN book USING(bk_num)"
					+ "WHERE me_id=? AND re_modifydate IS NULL ORDER BY re_regdate ASC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("========================================");
			if(rs.next()) {
				System.out.println("도서명\t대출일");
				do {
					System.out.print(rs.getString("bk_name") + "\t");
					System.out.println(rs.getDate("re_regdate"));
				}while(rs.next());
				System.out.println("========================================");
				System.out.println("[대출 중인 도서가 존재하여 회원 탈퇴가 불가합니다.]");
			}else {
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//탈퇴 가능 여부 체크 2. 탈퇴 가능 여부 반환
	public int checkDelete(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int re_status = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT bk_num FROM reservation "
					+ "WHERE me_id=? AND re_modifydate IS NULL";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, me_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				re_status = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return re_status;
	}
	
	//회원 탈퇴 과정 1. 대출 내역 삭제
	public void deleteReservation(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "DELETE FROM reservation WHERE me_id=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			//JDBC 수행 4단계
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//회원 탈퇴 과정 2. 탈퇴
	public void deleteMember(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "DELETE FROM member WHERE me_id=? AND me_passwd=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			//JDBC 수행 4단계
			pstmt.executeUpdate();
			System.out.println("[회원 탈퇴가 완료되었습니다.]");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
}