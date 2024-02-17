package kr.s11.object.method;

public class MethodArgMain01 {
	//인자 전달 방식: 값에 의한 호출
	//기본 자료형의 값을 인자로 전달하는 방식. 값을 복사하여 전달
	
	public int increase(int n) {
		++n;
		return n;
	}
	
	public static void main(String[] args) {
		int var1 = 100;
		
		//객체 선언 및 생성 후에 increase 호출
		MethodArgMain01 ma = new MethodArgMain01();
		int var2 = ma.increase(var1);
		System.out.println("var1 : " + var1 + ", var2 : " + var2);
	}
}
