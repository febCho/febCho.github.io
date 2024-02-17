package kr.s10.object.method;

public class MethodMain02 {
	/*
	 * [실습]
	 * 입력한 int형 정수값이 음수이면 -1을, 0이면 0을, 양수이면 1을 반환하는
	 * signof 메서드를 작성하자
	 * 
	 * [입력 예시]
	 * 정수 x: 50
	 * 
	 * [출력 예시]
	 * signof(x)는 1입니다.
	 */
	
	public int signof(int a) {
		int sign = 0;
		
		if(a > 0) {
			sign = 1;
		}else if(a < 0){
			sign = -1;
		}
		return sign;
	}
	
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("정수 x: ");
		int x = input.nextInt();
		
		MethodMain02 object = new MethodMain02();
		
		int result = object.signof(x);
		System.out.println("signof(x)는" + result + "입니다.");
		
		input.close();
	}
}
