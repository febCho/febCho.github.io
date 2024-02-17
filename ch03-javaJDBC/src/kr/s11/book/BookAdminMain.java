package kr.s11.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookAdminMain {
	private BufferedReader br;
	private BookDAO dao;
	
	public BookAdminMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new BookDAO();
			//메뉴 호출
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	
	//메뉴
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1. 도서 등록, 2. 도서 등록 취소, 3. 도서 목록, 4. 대출 목록, 5. 회원 목록, 6. 종료>");
			try{
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//도서 등록
					System.out.print("도서명:");
					String bk_name = br.readLine();
					System.out.print("카테고리:");
					String bk_category = br.readLine();
					
					dao.insertBook(bk_name, bk_category);
					
				}else if(no == 2) {//도서 등록 취소
					//목록 보기
					dao.selectBook();
					
					System.out.print("도서 번호: ");
					int bk_num = Integer.parseInt(br.readLine());
					
					dao.deleteBook(bk_num);
					
				}else if(no == 3) {//도서 목록
					dao.selectBook();
				}else if(no == 4) {//대출 목록
					dao.selectReservation();
				}else if(no == 5) {//회원 목록
					dao.selectMember();
				}else if(no == 6){
					System.out.println("[프로그램을 종료합니다.]");
					break;
				}else {
					System.out.println("[잘못 입력했습니다.]");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능합니다.]");
			}
		}
	}
	public static void main(String[] args) {
		new BookAdminMain();
	}
}
