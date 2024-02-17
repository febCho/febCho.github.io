package kr.s24.object.supertest;

//부모 클래스
class People2{
	int a;
	
	//인자가 있는 생성자 정의
	public People2(int a) {
		this.a = a;
	}
}

//자식 클래스
class Student2 extends People2{
	//생성자
	public Student2() {
		//부모 클래스의 인자의 타입이 int인 생성자를 호출
		//부모 클래스에 기본 생성자가 아닌 인자가 있는 생성자가 있기 때문
		super(100);
	}
}
public class SuperMain04 {
	public static void main(String[] args) {
		Student2 st = new Student2();
		System.out.println(st.a);
	}
}
