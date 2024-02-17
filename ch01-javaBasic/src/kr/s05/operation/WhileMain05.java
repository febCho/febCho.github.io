package kr.s05.operation;

public class WhileMain05 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		//0 전까지 입력 받은 정수로 합 구하기 = 멈추려면 0 입력하기
		
		int a, total = 0;
		
		System.out.println("===0 전까지 입력 받은 정수로 합 구하기===");
		
		System.out.print("누적할 정수 데이터 입력: ");
		
		while((a = input.nextInt()) != 0) {
			total += a;//누적
			System.out.print("누적할 정수 데이터 입력: ");
		}
		//0을 입력해 반복문을 멈추고, total에 누적된 데이터를 출력
		System.out.println("total = " + total);
		
		input.close();
	}
}
