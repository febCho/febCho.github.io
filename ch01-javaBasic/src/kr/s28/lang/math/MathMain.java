package kr.s28.lang.math;

public class MathMain {
	public static void main(String[] args) {
		int a = Math.abs(-10);
		System.out.println("절댓값: " + a);
		
		double b = Math.ceil(3.3);
		System.out.println("올림: " + b);
		
		double c = Math.floor(3.7);
		System.out.println("절삭: " + c);
		
		int d = Math.round(3.7f);
		System.out.println("반올림: " + d);
		//double 타입 반올림도 가능
		
		int e = Math.max(3, 5);
		System.out.println("최댓값: " + e);
		
		int f = Math.min(4, 7);
		System.out.println("최솟값: " + f);
	}
}
