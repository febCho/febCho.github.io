package kr.s04.operator;

public class OperatorMain10 {
	public static void main(String[] args) {
		System.out.println("===조건(삼항)연산자)===");
		int a = 5, b = 10;
		int max; //최대값을 저장할 변수
		int min; //최소값을 저장할 변수
		
		//
		max = a > b ? a : b;
		System.out.println("max = " + max);
		
		min = a < b ? a : b;
		System.out.println("min = " + min);
	}
}
