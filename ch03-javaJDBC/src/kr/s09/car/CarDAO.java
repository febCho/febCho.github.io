package kr.s09.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class CarDAO {
	//자동차 정보 등록
	public void insertCar(String name, String cnumber,
			              String color, String maker, int price){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "INSERT INTO car (num, name, cnumber,"
					+ "color, maker, price, reg_date) VALUES"
					+ "(car_seq.nextval, ?,?,?,?,?,SYSDATE)";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			
			//?에 데이터 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, cnumber);
			pstmt.setString(3, color);
			pstmt.setString(4, maker);
			pstmt.setInt(5, price);
			
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 정보를 등록하였습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//목록 보기
	public void selectcar() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM car ORDER BY num DESC";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("==============================");
			//JDBC 수행 4단계 : SQL문을 실행해서 결과행들을 ResultSet에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("등록번호\t이름\t제조사\t등록일");
				do {
					System.out.print(rs.getInt("num") + "\t");
					System.out.print(rs.getString("name") + "\t");
					System.out.print(rs.getString("maker") + "\t");
					System.out.println(rs.getDate("reg_date"));
				}while(rs.next());
			}else {
				System.out.println("[등록된 정보가 없습니다.]");
			}
			System.out.println("==============================");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//상세 정보 보기
	public void selectDetailCar(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2 단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql="SELECT * FROM car WHERE num=?";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//JDBC 수행 4단계 : SQL문을 실행해서 한 건의 레코드를 ResultSet에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("등록번호: " + rs.getInt("num"));
				System.out.println("이름:" + rs.getString("name"));
				System.out.println("차량 번호: " + rs.getString("cnumber"));
				System.out.println("색상: " + rs.getString("color"));
				System.out.println("제조사: " + rs.getString("maker"));
				System.out.println("가격: " + rs.getInt("price"));
				System.out.println("등록일: " + rs.getDate("reg_date"));
				
			}else {
				System.out.println("[검색한 정보가 존재하지 않습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//정보 수정
	public void updateCar(int num, String name, String cnumber,
			              String color, String maker, int price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2 단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "UPDATE car SET name=?,cnumber=?,color=?,"
					         + "maker=?,price=? WHERE num=?";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, cnumber);
			pstmt.setString(3, color);
			pstmt.setString(4, maker);
			pstmt.setInt(5, price);
			pstmt.setInt(6, num);
			
			//JDBC 수행 4단계 : SQL문 실행
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 정보를 수정하였습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//정보 삭제
	public void deleteCar(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "DELETE FROM car WHERE num=?";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//JDBC 수행 4단계 : SQL문 실행
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 정보를 삭제하였습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
