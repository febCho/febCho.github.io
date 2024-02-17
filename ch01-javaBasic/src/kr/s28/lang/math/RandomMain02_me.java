package kr.s28.lang.math;

import java.util.Scanner;

public class RandomMain02_me {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 가위바위보 게임
		 * 
		 * [입력 예시]
		 * ----------------------
		 * 메뉴> 1. 게임하기, 2. 종료
		 * ----------------------
		 * 메뉴>1
		 * 가위바위보 입력(0. 가위, 1. 바위, 2. 보):
		 *
		 *[출력 예시]
		 *-> 컴퓨터: 가위, 사람: 바위
		 *결과: 사람 승
		 */
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("-----------------------");
			System.out.println("메뉴> 1. 게임하기, 2. 종료");
			System.out.println("-----------------------");
			
			System.out.print("메뉴>");
			int num = input.nextInt();
			
			if(num == 1) {
				System.out.print("가위바위보 입력(0. 가위, 1. 바위, 2. 보):");
				int me = input.nextInt();
				
				String[] game = {"가위", "바위", "보"};
				
				double ran = Math.random();
				int index = (int)(ran*3);//0~2
				String c = game[index];
				String m = game[me];
				
				switch(m) {
				case "가위":
					if(c == "가위") {System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
					System.out.println("결과: 무승부");break;
					}else if(c == "바위") {
						System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
						System.out.println("결과: 컴퓨터 승");break;
					}else if(c == "보") {
						System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
						System.out.println("결과: 사람 승");break;
					}
				case "바위":
					if(c == "바위") {
						System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
					System.out.println("결과: 무승부");break;
					}else if(c == "보") {
						System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
						System.out.println("결과: 컴퓨터 승");break;
					}else if(c == "가위") {
						System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
						System.out.println("결과: 사람 승");break;
				}
				case "보":
					if(c == "보") {
						System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
						System.out.println("결과: 무승부");break;
					}else if(c == "가위") {
						System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
						System.out.println("결과: 컴퓨터 승");break;
					}else if(c == "바위") {
						System.out.println("-> 컴퓨터: " + c + ", 사람: " + m);
						System.out.println("결과: 사람 승");break;
					
			}
				}
			}else if(num == 2) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
	}

		
	}
}
