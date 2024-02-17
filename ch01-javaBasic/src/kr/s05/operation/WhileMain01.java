package kr.s05.operation;

public class WhileMain01 {
	public static void main(String[] args) {
		//while문은 조건 비교에 만족할 때만 수행문을 수행하는 반복문
		int i=1;//초기값
		      //조건식
		while(i <=10) {
			System.out.println(i++);//증감식
		}
		System.out.println("============");
		
		int j=10;
		while(j >=0) {
			System.out.println(j--);
		}
	}
}
