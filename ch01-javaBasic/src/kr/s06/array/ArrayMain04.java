package kr.s06.array;

public class ArrayMain04 {
	public static void main(String[] args) {
		//배열 선언, 생성, 초기화
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score[0]; //배열의 첫번째 값으로 최대값 초기화
		int min = score[0]; //배열의 첫번째 값으로 최소값 초기화
		
		for(int i=1;i<score.length;i++) {//0번 데이터와 대조
			//최대값 구하기
			if(score[i] > max) {
				max = score[i]; //최대값이 변동
			}
			//최소값 구하기
			if(score[i] < min) {
				min = score[i]; //최소값이 변동
			}
		}
		//최대값, 최소값 출력
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
}
