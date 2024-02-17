package kr.s02.variable;

public class VariableTypeMain01 {
	public static void main(String[] args) {
		System.out.println("===논리형===");
		//논리형 (true, false)
		boolean b = true;
		System.out.println("b = " + b);
		
		System.out.println("===문자형===");
		//문자형, 크기 : 2byte, 표현 범위 : 0~65.535
		//다국어 처리를 위한 유니코드(unicode) 방식
		char c1 = 'A'; //내부적으로 아스키코드값 65
		System.out.println("c1 = " + c1);
				
		char c2 = 65; //A에 해당하는 아스키코드값 65를 직접 대입
		System.out.println("c2 = " + c2);
				
		char c3 = '\u0041'; //A를 유니코드로 표현
		System.out.println("c3 = " + c3);
				
		char c4 = '자';
		System.out.println("c4 = " + c4);
				
		char c5 = '\uc790'; //자를 유니코드로 표현
		System.out.println("c5 = " + c5);
				
		System.out.println("===정수형===");
		//byte, 크기 : 1byte, 표현범위 : -128~127
		byte b1= 127;
		System.out.println("b1 = " + b1);
				
		//short, 크기 : 2byte, 표헌범위 : -32,768~32.767
		short s1 = 32767;
		System.out.println("s1 = " + s1);
				
		//int, 크기 : 4byte, 표현범위 : -2,147,483,648~2,147,483,647
		int in1 = 1234567;
		System.out.println("in1 = " + in1);
				
		//long, 크기 : 8byte
		long lo1 = 1234567L;//int가 기본 자료형이기 때문에
		System.out.println("lo1 = " + lo1);
				
		System.out.println("===실수형===");
		//float, 크기 : 4byte
		float f1 = 9.2F;//더블이 기본 자료형이기 때문에
		System.out.println("f1 = " + f1);
		//double, 크기 : 8byte
		double d1 = 9.8;
		System.out.println("d1 = " + d1);
				
		System.out.println("===문자열 표시===");
		//문자열 표시(기본 자료형이 아님, 참조 자료형)
		String str = "Hello World";
		System.out.println("str = " + str);
	}
}
