package kr.s10.object.method;

public class MethodMain01 {
	//기본적인 메서드의 이해
	
	//반환하는 데이터가 있는 경우
	public int add(int a, int b) {
		return a+b;
	}
	
	//반환하는 데이터가 없는 경우
	public void print(String str) {
		System.out.println(str);
	}
	public static void main(String[] args) {
		//객체 선언 및 생성
		MethodMain01 method = new MethodMain01();
		
		int result = method.add(10, 20);
		System.out.println("result = " + result);
		
		method.print("오늘은 수요일");
	}
}
