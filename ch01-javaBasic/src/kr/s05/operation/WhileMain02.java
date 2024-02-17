package kr.s05.operation;

public class WhileMain02 {
	public static void main(String[] args) {
		//1부터 100까지의 합 구하기
		int sum=0, su=1;//초기값
		
		     //조건식
		while(su <=100) {
			//누적
			sum += su;
			su++;//증감식
		}
		//반복문을 빠져나온 다음 최종적으로 출력할 값은 아래와 같다.
		System.out.println("1부터 100까지의 합 : " + sum);
	}
}
