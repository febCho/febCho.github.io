package kr.s06.array;

import java.util.Scanner;

public class ArrayMain07 {
	public static void main(String[] args) {
		//값을 직접 배열에 입력하여 성적 처리하는 프로그램 만들기
		Scanner input = new Scanner(System.in);
		//과목명 저장
		String[] course = {"국어", "영어", "수학"};
		//성적 저장
		int[] score = new int[course.length];//course 배열과 score 배열 길이가 같도록 함
		//총점 저장 - 루프 돌려 누적 위해
		int sum = 0;
		//평균 저장
		float avg = 0.0f;
		
		//반복문을 이용해서 입력 처리
		for(int i=0;i<score.length;i++) {
			do {
				System.out.print(course[i] + "=");//과목명 입력칸
				score[i] = input.nextInt();//위에 생성된 배열에 직접 입력
			}while(score[i] < 0 || score[i] > 100);
			//입력한 값이 음수거나 100 이상이면 true로 재입력
			
			//총점 구하기
			sum += score[i]; //i가 루프를 돌며 sum에 계속 누적
		}
		//평균 구하기
		avg = sum / (float)course.length; //=score.length
		
		System.out.println(); //단순 줄바꿈
		
		//과목 점수 출력
		for(int i=0;i<score.length;i++) {
			System.out.printf("%s = %d%n", course[i], score[i]);
		}
		
		//총점과 평균 출력
		System.out.printf("총점 = %d%n", sum);
		System.out.printf("평균 = %.2f%n", avg);
		
		input.close();
	}
}
