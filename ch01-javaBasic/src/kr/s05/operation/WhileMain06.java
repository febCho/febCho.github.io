package kr.s05.operation;

public class WhileMain06 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int a, total = 0;
		System.out.println("===0전까지 입력받은 정수로 합 구하기===");

		while(true) {
			System.out.print("누적할 정수 입력> ");
			a = input.nextInt();
			if(a == 0) {
				break;//반복문을 빠져나감
			}
			//0이 아니라면, total 변수에 계속 누적
			total += a;
		}
		
		//0이 입력되어 while 반복문을 나오면, 최종 누적된 값이 출력
		System.out.println("total = " + total);
		
		input.close();
	}
}
