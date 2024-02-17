package kr.s08.memo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MemoMain {
	private BufferedReader br;
	private MemoDAO dao; //같은 패키지라 import 할 필요 없음
	
	public MemoMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new MemoDAO();
			//메뉴 호출
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	
	//메뉴
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1. 글쓰기, 2. 목록 보기, 3. 상세글 보기, 4. 글 수정, 5. 글 삭제, 6. 종료>");
			
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//글쓰기
					System.out.print("이름:");
					String name = br.readLine();
					System.out.print("비밀번호:");
					String passwd = br.readLine();
					System.out.print("제목:");
					String subject = br.readLine();
					System.out.print("내용:");
					String content = br.readLine();
					System.out.print("이메일:");
					String email = br.readLine();
					
					/*
					 * MemoDAO의 insertMemo 메서드를 호출해서 입력받은 데이터 전달
					 * 1개의 행을 테이블에 추가
					 */
					dao.insertMemo(name, passwd, subject, content, email);
				}else if(no == 2) {//목록 보기
					dao.selectMemo();
				}else if(no == 3) {//상세글 보기
					//목록 보기
					dao.selectMemo();
					
					System.out.print("글번호:");
					int num = Integer.parseInt(br.readLine());
					System.out.println("===============================");
					//상세글 보기
					dao.selectDetailMemo(num);
					System.out.println("===============================");
					
				}else if(no == 4) {//글 수정
					//목록 보기
					dao.selectMemo();
					
					System.out.print("수정할 글 번호:");
					int num = Integer.parseInt(br.readLine());
					//상세글 보기
					dao.selectDetailMemo(num);
					System.out.println("===============================");
					
					System.out.print("이름:");
					String name = br.readLine();
					System.out.print("비밀번호:");
					String passwd = br.readLine();
					System.out.print("제목:");
					String subject = br.readLine();
					System.out.print("내용:");
					String content = br.readLine();
					System.out.print("이메일:");
					String email = br.readLine();
					
					//글 수정하기
					dao.updateMemo(num, name, passwd, subject, content, email);
					
				}else if(no == 5) {//글 삭제
					//목록 보기
					dao.selectMemo();
					
					System.out.print("삭제할 글 번호:");
					int num = Integer.parseInt(br.readLine());
					
					//글 삭제하기
					dao.deleteMemo(num);
					
				}else if(no == 6) {//종료
					System.out.println("[프로그램을 종료합니다.]");
					break;
				}else {
					System.out.println("[잘못 입력하였습니다.]");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능합니다.]");
			}
		}
	}
	
	public static void main(String[] args) {
		new MemoMain();
	}
}
