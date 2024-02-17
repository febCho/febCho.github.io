package kr.s07.object;

public class Student02 {
	//멤버 변수 - 사용할 가능성이 있는 것들은 모두 생성 가능
	String name;
	int age;
	String hobby;
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		Student02 student = new Student02();
		//객체가 생성되면 객체의 멤버 변수는 기본값으로 초기화됨
		System.out.println(student.name + "," + student.age
				           + "," + student.hobby);
		System.out.println("=================");
		
		//객체의 멤버 변수에 값 할당
		student.name = "유재성";
		student.age = 32;
		student.hobby = "루미큐브";
		
		System.out.println(student.name + "," + student.age
		           + "," + student.hobby);
	}
}
