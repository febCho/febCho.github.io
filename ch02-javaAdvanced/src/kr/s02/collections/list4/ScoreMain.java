package kr.s02.collections.list4;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class ScoreMain {
	/*
	 * [실습]
	 * 1. 멤버 변수: ArrayList, BufferedReader 객체를 저장할 수 있는 변수
	 * 2. 생성자: ArrayList, BufferedReader 객체 생성, callMenu 호출
	 * 3. 메서드: 메뉴(callMenu), 성적 입력(inputScore), 성적 출력(printScore)
	 *          성적 입력 조건 체크(int parseInputData(String course))
	 */
	
	//멤버 변수
	ArrayList<Score> list;
	BufferedReader br;
	
	//생성자
	public ScoreMain() {
		list = new ArrayList<Score>();
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	
	//메뉴 호출
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1. 성적 입력, 2. 성적 출력, 3. 종료> ");
			try {
				int num = Integer.parseInt(br.readLine());
				if(num == 1) {
					inputScore();
				}else if(num == 2) {
					printScore();
				}else if(num == 3) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("[잘못 입력했습니다.]");
				}

			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력할 수 있습니다.]");
			}
		}
	}
	
	//성적 입력
	public void inputScore() throws IOException{
		Score s = new Score();
		System.out.print("이름: ");
		s.setName(br.readLine());
		
		s.setKorean(parseInputData("국어: "));
		s.setEnglish(parseInputData("영어: "));
		s.setMath(parseInputData("수학: "));
		
		list.add(s);
		System.out.println("성적이 1건 입력되었습니다.");
	}
	
	//성적 체크
	public int parseInputData(String course) throws IOException{
		while(true) {
			System.out.print(course);
			try {
				int study = Integer.parseInt(br.readLine());
				
				//성적 유효 범위(0~100) 체크
				if(study < 0 || study > 100)
					throw new ScoreValueException("[성적은 0 이상 100 이하로 입력 가능합니다.]");
				
				return study;//(정상 범위)
				
			}catch(ScoreValueException e) {
				//성적을 통해 에러 문구를 적어주었기 때문에 getMessage로 뽑아와야 함
				System.out.println(e.getMessage());
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력할 수 있습니다.]");
			}
		}
	}
	
	//성적 출력
	public void printScore() {
		System.out.println("총 학생수: " + list.size());
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("==================================================");
		
		for(Score sc : list) {
			System.out.print(sc.getName() + "\t");
			System.out.print(sc.getKorean() + "\t");
			System.out.print(sc.getEnglish()+ "\t");
			System.out.print(sc.getMath() + "\t");
			System.out.print(sc.makeSum() + "\t") ;
			System.out.printf("%.2f\t", sc.makeAvg());
			System.out.print(sc.makeGrade() + "\t\n");
		}
		System.out.println("\n==================================================");
	}
	public static void main(String[] args) {
		new ScoreMain();
	}

}
