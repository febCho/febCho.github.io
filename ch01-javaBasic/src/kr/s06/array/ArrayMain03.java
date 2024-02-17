package kr.s06.array;

public class ArrayMain03 {
	public static void main(String[] args) {
		int sum = 0;//총점을 저장할 변수
		float avg = 0.0f;//평균을 저장할 변수
		
		//배열을 생성한 후에 배열의 길이를 늘리거나 줄일 수 없음 = 배열은 고정 길이
		//배열 선언, 생성(암시적으로 배열 생성), 초기화
		int[] score = {100, 88, 88, 100, 90};
		            // 0,   1,   2,  3,   4, length = 5
		
		//총점 구하기
		for(int i=0;i<score.length;i++) {
			//누적
			sum += score[i]; //i: 0~4까지 for문을 돌며 변화
		}
		
		//평균 구하기
		   // 총점        과목수
		avg = sum / (float)score.length;//sum: int ---> float
		
		System.out.printf("총점: %d%n", sum);
		System.out.printf("평균: %.2f%n", avg);
	}
}
