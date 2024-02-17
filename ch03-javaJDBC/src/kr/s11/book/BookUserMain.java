package kr.s11.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookUserMain {
	private BufferedReader br;
	private BookDAO dao;
	private String me_id;//로그인한 아이디 저장
	private boolean flag;//로그인 여부
	private String me_passwd;
	
	public BookUserMain() {
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
			System.out.print("1. 로그인, 2. 회원가입, 3. 종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//로그인
					System.out.print("아이디:");
					me_id = br.readLine();//멤버 변수 호출
					System.out.print("비밀번호:");
					me_passwd = br.readLine();
					
					flag = dao.loginCheck(me_id, me_passwd);
					if(flag) {
						System.out.println("[" + me_id + "님 로그인 되었습니다.]");
						break;//첫 번째 while문 빠져나와 다음 while문에 걸림
					}
					System.out.println("[아이디 또는 비밀번호를 다시 확인하세요.]");
					
				}else if(no == 2) {//회원가입
					System.out.print("아이디:");
					String me_id = br.readLine();
					//아이디 중복 체크
					int check = dao.checkId(me_id);
					if(check == 1) {
						System.out.println("[아이디가 중복되었습니다.]");
					}else {
						System.out.print("이름:");
						String me_name = br.readLine();
						System.out.print("비밀번호:");
						String me_passwd = br.readLine();
						System.out.print("연락처:");
						String me_phone = br.readLine();
						
						dao.insertmember(me_id, me_name, me_passwd, me_phone);
					}
				}else if(no == 3){//종료
					System.out.println("[프로그램을 종료합니다.]");
					break;
				}else {
					System.out.println("[잘못 입력했습니다.]");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능합니다.]");
			}
		}
		while(flag) {
			System.out.print("1. 도서 대출, 2. MY 대출목록, 3. 대출도서 반납, 4. 회원 탈퇴, 5. 종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//도서 대출
					dao.selectBook();
					
					System.out.print("도서 번호: ");
					int bk_num = Integer.parseInt(br.readLine());
					//대출 여부 체크
					int check = dao.checkStatus(bk_num);
					if(check == 1) {
						System.out.println("[선택하신 도서는 이미 대출 중입니다.]");
					}else {
						System.out.print("대출 하기(0: 반납, 1: 대출): ");
						int re_status = Integer.parseInt(br.readLine());
						if(re_status == 1) {
							dao.checkOut(re_status, bk_num, me_id);
						}else if(re_status == 0) {
							System.out.println("[대출을 원하시면 1번을 눌러 주세요.]");
							continue;
						}else{
							System.out.println("[잘못 입력했습니다.]");
						}
						
					}
				}else if(no == 2) {//MY 대출목록
					dao.myCheckOut(me_id);
					
				}else if(no == 3) {//대출도서 반납
					//MY 대출목록 체크
					dao.myCheckOut(me_id);
					
					System.out.print("대출 번호: ");
					int re_num = Integer.parseInt(br.readLine());
					//반납 가능 여부 체크
					int check = dao.checkReturn(re_num, me_id);
					if(check == 0) {
						System.out.println("[현재 대출 중인 도서가 아닙니다.]");
					}else {
						dao.returnBook(me_id, re_num);
					}
				}else if(no == 4) {//회원 탈퇴
					System.out.print("비밀번호:");
					me_passwd = br.readLine();
					//탈퇴 가능 여부 체크
						dao.checkList(me_id, me_passwd);
						int check = dao.checkDelete(me_id);
						
						if(check == 0) {
							System.out.println("[회원 탈퇴가 가능합니다.]");
							System.out.println("[회원 탈퇴 시 그동안의 대출 내역은 전부 사라집니다.]");
							System.out.println("[회원 탈퇴를 진행하시겠습니까?]");
							System.out.println("========================================");
							System.out.print("회원 탈퇴 여부(0: 네, 1: 아니오): ");
							int answer = Integer.parseInt(br.readLine());
							
							if(answer == 0) {
								dao.deleteReservation(me_id);
								dao.deleteMember(me_id, me_passwd);
								break;
							}else if(answer == 1) {
								continue;
							}else {
								System.out.println("[잘못 입력했습니다.]");
								continue;
							}
						}
				}else if(no == 5){//종료
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
		new BookUserMain();
	}
}