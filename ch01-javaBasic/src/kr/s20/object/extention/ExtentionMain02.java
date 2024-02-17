package kr.s20.object.extention;

//부모 클래스
class People{
	public void eat() {
		System.out.println("식사하다.");
	}
}
//자식 클래스
class Student extends People{
	public void study() {
		System.out.println("공부하다.");
	}
}

public class ExtentionMain02 {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat();//People의 메서드를 상속 받아서 호출
		s.study();//Student의 메서드 호출
		System.out.println(s.toString());//Object의 메서드를 상속 받아서 호출
	}
}
