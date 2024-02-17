package kr.s04.operator;

public class OperatorMain09 {
	public static void main(String[] args) {
		System.out.println("===조건(삼항)연산자");
		int x = 10, y = -10;
		
		//          조건    참값  거짓값
		int absX = x >= 0 ? x : -x;//절대값 구하기
		int absY = y >= 0 ? y : -y;//절대값 구하기
		
		System.out.println("x= 10일 때, x의 절대값은 " + absX);
		System.out.println("y = -10일 때, y의 절대값은 " + absY);
	}
}
