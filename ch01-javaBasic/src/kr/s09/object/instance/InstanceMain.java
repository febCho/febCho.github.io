package kr.s09.object.instance;

public class InstanceMain {
	//클래스의 기본 구조
	//멤버 변수
	int var1;
	String var2;
	
	//생성자 - 생략 가능
	public InstanceMain() {}
	
	//멤버 메서드
	public int sum(int a, int b) {//a, b: 인자, sum: 메서드 명
		return a+b;
	}
	public static void main(String[] args) {
		//객체 선언 및 생성
		//자료형      참조자료형    생성자
		InstanceMain me = new InstanceMain();
		System.out.println("me: " + me);
		//위와 같이 객체에 변수나 메서드를 연결하지 않고 출력할 경우,
		//객체의 참조값이 출력되며 이는 가공된 것으로 별도로 사용할 수 없다.
		
		int result = me.sum(5, 6);//메서드 내부적으로 연산한 값을 result에 반환
		System.out.println("result = " + result);
	}
}
