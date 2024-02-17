package kr.s10.shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class ShopDAO {
	//관리자 상품 등록
	public void insertItem(String item_name, int item_price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성 (item_date는 입력 X -> 디폴트 값)
			sql = "INSERT INTO sitem (item_num, item_name, item_price)"
					+ "VALUES (sitem_seq.nextval,?,?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, item_name);
			pstmt.setInt(2, item_price);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 상품이 등록되었습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//관리자 상품 목록
	public void selectItem() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM sitem ORDER BY item_num DESC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			
			System.out.println("==============================");
			if(rs.next()) {
				System.out.println("번호\t이름\t가격\t등록일");
				do {
					System.out.print(rs.getInt("item_num") + "\t");
					System.out.print(rs.getString("item_name") + "\t");
					System.out.printf("%,d\t", rs.getInt("item_price"));
					System.out.println(rs.getDate("item_date"));
				}while(rs.next());
			}else {
				System.out.println("[등록된 상품이 없습니다.]");
			}
			System.out.println("==============================");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//관리자 회원 목록
	public void selectCustomer() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM customer ORDER BY cust_id DESC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("==============================");
			if(rs.next()) {
				System.out.println("아이디\t이름\t가입일\t전화번호\t주소");
				do {
					System.out.print(rs.getString("cust_id") + "\t");
					System.out.print(rs.getString("cust_name") + "\t");
					System.out.print(rs.getDate("cust_date") + "\t");
					System.out.print(rs.getString("cust_tel") + "\t");
					System.out.println(rs.getString("cust_address"));
				}while(rs.next());
			}else {
				System.out.println("[등록된 회원 정보가 없습니다.]");
			}
			System.out.println("==============================");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//관리자 구매 목록
	public void selectOrder() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT order_num, cust_id, order_date, item_name, item_price "
					+ "FROM sorder JOIN sitem USING(item_num) "
					+ "ORDER BY order_num DESC";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("==============================");
			if(rs.next()) {
				System.out.println("번호\t주문자 ID\t상품명\t상품 가격\t주문일");
				do {
					System.out.print(rs.getInt("order_num") + "\t");
					System.out.print(rs.getString("cust_id") + "\t");
					System.out.print(rs.getString("item_name") + "\t");
					System.out.printf("%,d\t", rs.getInt("item_price"));
					System.out.println(rs.getDate("order_date"));
				}while(rs.next());
			}else {
				System.out.println("[등록된 주문 정보가 없습니다.]");
			}
			System.out.println("==============================");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//사용자 회원 등록
	public void insertCustmor(String cust_id, String cust_name,
			                  String cust_address, String cust_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO customer (cust_id, cust_name,"
					+ "cust_address, cust_tel) VALUES"
					+ "(?,?,?,?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, cust_id);
			pstmt.setString(2, cust_name);
			pstmt.setString(3, cust_address);
			pstmt.setString(4, cust_tel);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 회원 정보를 저장하였습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//사용자 회원 상세
	public void selectDetailCustomer(String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM customer WHERE cust_id=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, cust_id);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("==============================");
			if(rs.next()) {
				System.out.println("아이디 : " + rs.getString("cust_id"));
				System.out.println("이름: " + rs.getString("cust_name"));
				System.out.println("주소: " + rs.getString("cust_address"));
				System.out.println("전화번호: " + rs.getString("cust_tel"));
				System.out.println("가입일: " + rs.getDate("cust_date"));
			}else {
				System.out.println("[검색한 회원 정보가 존재하지 않습니다.]");
			}
			System.out.println("==============================");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//사용자 상품 구매
	public void insertOrder(int item_num, String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO sorder (order_num, cust_id, item_num)"
					+ "VALUES (sorder_seq.nextval, ?,?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, cust_id);
			pstmt.setInt(2,  item_num);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println("[" + count + "개의 상품을 구매했습니다.]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//사용자 구매 내역
	public void seletOrderByID(String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT order_num, order_date, item_name, "
					+ "item_price FROM sorder JOIN sitem USING(item_num) "
					+ "WHERE cust_id = ? ORDER BY order_num DESC";
					//주문한 상품이 하나 이상일 수 있으니 정렬
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, cust_id);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("===================================");
			if(rs.next()) {
				System.out.println("번호\t상품명\t상품가격\t주문일");
				do {
					System.out.print(rs.getInt("order_num") + "\t");
					System.out.print(rs.getString("item_name") + "\t");
					System.out.print(rs.getInt("item_price") + "\t");
					System.out.println(rs.getDate("order_date"));
				}while(rs.next());
			}else {
				System.out.println("[등록된 주문 정보가 없습니다.]");
			}
			System.out.println("===================================");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}
