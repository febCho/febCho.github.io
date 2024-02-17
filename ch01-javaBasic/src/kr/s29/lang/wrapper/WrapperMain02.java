package kr.s29.lang.wrapper;

public class WrapperMain02 {
	public static void main(String[] args) {
		Integer obj1 = 10;//auto boxing
		Integer obj2 = 20;
		
		//참조변수끼리 더해서 참조변수(객체)에 넣어줘도 되고
		Integer result = obj1 + obj2;
		System.out.println(result);
		System.out.println("================");
		
		//객체 형태의 참조변수끼리 더해서 기본자료형 변수에 대입도 되고
		int result2 = obj1 + obj2;//auto unboxing
		System.out.println(result2);
	}
}
