package kr.s12.object.overloading;

public class OverloadingMain01 {
	//Method Overloading(중복정의)는 하나의 클래스 내에서 같은 이름을 가지는
	//메서드가 여러 개 정의되는 것을 말함
	//메서드 명은 동일하게 하고 인자의 타입 또는 개수, 배치된 순서가 다를 경우
	//다른 메서드로 인식함
	public void print(int n) {
		System.out.println("정수 n = " + n);
	}
	public void print(double a) {//(int a) > X, 충돌 발생함
        					//즉 변수명이 달라지는 건 중복정의 조건에 해당 X
		System.out.println("실수 a = " + a);
	}
	public void print(double a, long b) {
		System.out.println("실수 a = " + a + ", 정수 b = " + b);
	}
	public void print(long a, double b) {
		System.out.println("정수 a = " + a + ", 실수 b = " + b);
	}
	
	public static void main(String[] args) {
		OverloadingMain01 om = new OverloadingMain01();
		om.print(20);
		om.print(10.5);
		om.print(8.7, 208L);
		om.print(402L, 2.08);
		
	}
}
