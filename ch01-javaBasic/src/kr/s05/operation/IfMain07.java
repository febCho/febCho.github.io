package kr.s05.operation;

public class IfMain07 {
	public static void main(String[] args) {
		/*
		 *[실습]
		 * 정수 하나를 입력하여 짝수면 10을 더하고 홀수이면 20을
		 * 더하여 결과를 출력하시오.
		 * 
		 *[입력 예시]
		 * 정수 하나 입력: 5
		 * 
		 *[출력 예시]
		 *결과 : 25
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int v, num;
		
		System.out.print("정수 하나 입력 : ");
		v = input.nextInt();
		
		if(v%2 == 1) {
			num = v + 20;
		}else
			num = v + 10;
		
		System.out.printf("결과 : %d%n", num);
		
		input.close();
	}
}
