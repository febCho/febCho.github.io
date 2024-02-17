package kr.s05.operation;

public class DoWhileMain02 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int korean, english, math, sum;
		char grade;
		float avg;
		
		//do블럭에서 입력한 값을 조건 체크해서 0부터 100사이이면 조건이
		//false가 되어 do~while 블럭을 빠져나감
		do {
			System.out.print("국어= ");
			korean = input.nextInt();
		}while(korean < 0 || korean > 100);
		
		do {
			System.out.print("영어= ");
			english = input.nextInt();
		}while(english < 0 || english > 100);
		
		do {
			System.out.print("수학= ");
			math = input.nextInt();
		}while(math < 0 || math > 100);
		
		//총점 구하기
		sum = korean + english + math;
		//평균 구하기
		avg = sum / 3.0f;
		
		//등급 구하기
		switch((int)(avg/10)) {
		case 10:
		case 9: grade = 'A';break;
		case 8: grade = 'B';break;
		case 7: grade = 'C';break;
		case 6: grade = 'D';break;
		default: grade = 'F';
		}
		
		System.out.println();
		System.out.printf("총점: %d%n", sum);
		System.out.printf("평균: %.2f%n", avg);
		System.out.printf("등급: %c%n", grade);
		
		input.close();
	}
}
