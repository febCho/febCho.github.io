package kr.s24.object.supertest;

//부모 클래스
class Parent2{
	int a;
	int b;
	
	//생성자
	public Parent2(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

//자식 클래스
class Child2 extends Parent2{
	//생성자
	public Child2(int a, int b) {
		//부모 클래스의 인자가 있는 생성자 호출
		super(a, b);
	}
}
public class SuperMain05 {
	public static void main(String[] args) {
		Child2 ch = new Child2(100, 200);
		System.out.println(ch.a);
		System.out.println(ch.b);
	}
}
