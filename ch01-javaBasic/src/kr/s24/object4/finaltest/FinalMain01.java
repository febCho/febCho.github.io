package kr.s24.object4.finaltest;

class A{
	//지정한 값은 변경 불가능
	final int NUM = 10;
	public static final int NUMBER = 20;
}
public class FinalMain01 {
	public static void main(String[] args) {
		A ap = new A();
		//상수는 변경 불가능: The final field A.NUM cannot be assigned.
		//ap.NUM = 20;
		System.out.println(ap.NUM);
		
		//static 상수 = 객체 생성 없이도 호출 가능
		System.out.println(A.NUMBER);
		
		//지역 상수 - 메인 함수(메서드) 안에서만 존재
		final int NO = 30;
		System.out.println(NO);
	}

}
