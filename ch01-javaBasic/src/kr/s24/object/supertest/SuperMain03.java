package kr.s24.object.supertest;

//부모 클래스
class People{
	int a = 100;
	
	//생성자 - 상속 관계를 맺으면 자동으로 생성
	public People() {
		//object의 인자가 없는 생성자 호출
		super();
	}
}

//자식 클래스
class Student extends People{
	int b = 200;
	
	//생성자 - 상속 관계를 맺으면 자동으로 생성
	public Student() {
		//부모 클래스의 인자가 없는 생성자 호출
		super();
	}
}
public class SuperMain03 {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.a);
		System.out.println(s.b);
	}
}
