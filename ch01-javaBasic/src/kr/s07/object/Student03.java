package kr.s07.object;

public class Student03 {
	//멤버 변수
	String name;
	int age;
	String hobby;
	String job;
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		Student03 student = new Student03();
		//객체의 멤버 변수에 값 할당
		student.name = "유재성";
		student.age = 32;
		student.hobby = "루미큐브";
		student.job = "퍼포먼스 AE";
		
		System.out.println("이름: " + student.name);
		System.out.println("나이: " + student.age);
		System.out.println("취미: " + student.hobby);
		System.out.println("직업: " + student.job);
		System.out.println("=================");
		
		Student03 student2 = new Student03();
		
		student2.name = "장영실";
		student2.age = 19;
		student2.hobby = "야구";
		student2.job = "고등학생";
		
		System.out.println("이름: " + student2.name);
		System.out.println("나이: " + student2.age);
		System.out.println("취미: " + student2.hobby);
		System.out.println("직업: " + student2.job);
	}
}
