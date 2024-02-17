package kr.s07.note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoteMain {
	private BufferedReader br;
	private NoteDAO note;
	
	//생성자
	public NoteMain() {
		try {
			note = new NoteDAO();//변수 선언할 때 생성해도 되는데 그냥 생성 코드 묶어둠
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			//자원 정리
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	
	//메뉴
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1. 글 쓰기, 2. 목록 보기, 3. 상세 글 보기,"
					+ "4. 글 수정, 5. 글 삭제, 6. 종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//글 쓰기
					note.insertInfo("홍길동", "1234", "가을",
							"서늘한 날씨", "test@test.com");
				}else if(no == 2) {//목록 보기
					note.selectInfo();
				}else if(no == 3) {//상세 글 보기
					note.selectDetailInfo(10);
				}else if(no == 4) {//글 수정
					note.updateInfo(10, "홍길동", "1234", "가을",
							"서늘한 날씨", "test@test.com");
				}else if(no == 5) {//글 삭제
					note.deleteInfo(10);
				}else if(no == 6) {// 종료
					System.out.println("[프로그램을 종료합니다.]");
					break;
				}else {
				System.out.println("[잘못 입력하였습니다.");
			}
		}catch(NumberFormatException e) {
			System.out.println("[숫자만 입력 가능합니다.]");
		}
	  }
	}
	public static void main(String[] args) {
		new NoteMain();
	}
}
