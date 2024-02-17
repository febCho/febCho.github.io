package kr.s04.operator;

public class OperatorMain04 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때
		 * 학생당 몇 개를 가질 수 있고, 최종적으로 몇 개가 남는지를 구하시오.
		 * 
		 * [출력 예시]
		 * 학생 한 명이 가지는 연필수 : **
		 * 남은 연필수 : **
		 */
		
		int pencil = 534;
		int a = pencil / 30;
		int b = pencil % 30;
		//굳이 pencil이라는 변수를 선언할 필요 없이
		//int a = 534/30;
		//int b = 534%30; 가 낫겠다!
		
		System.out.printf("학생 한 명이 가지는 연필수 : %d자루%n", a);
		System.out.printf("남은 연필수 : %d자루%n", b);
		
		/*
		 * int a = 534;
		 * int b = 30;
		 * 
		 * System.out.println("학생 한 명이 가지는 연필수 : " + a/b);
		 * System.out.println("남은 연필수 : " + a%b);
		 * 
		 *이 방식도 있음!
		 */
	}
}
