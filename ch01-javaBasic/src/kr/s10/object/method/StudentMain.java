package kr.s10.object.method;

public class StudentMain {
	//멤버 변수
	String name;
	int korean;
	int math;
	int english;
	
	//멤버 메서드
	
	//총점 구하기
	public int makeSum() {
		return korean + math + english;
	}
	
	//평균 구하기
	public int makeAvg() {
		return makeSum() / 3;
	}
	
	//등급 구하기
	public String makeGrade() {
		String grade;
		//메서드 안에 sum 만들어 누적하고, sign/min 만들어 비교하는 것과 동일함
		switch(makeAvg() / 10) {
		case 10:
		case 9: grade = "A";break;
		case 8: grade = "B";break;
		case 7: grade = "C";break;
		case 6: grade = "D";break;
		default: grade = "F";
		}
		return grade;
	}
	
	public static void main(String[] args) {
		StudentMain student = new StudentMain();
		
		student.name = "홍길동";
		student.korean = 98;
		student.math = 87;
		student.english = 100;
		
		System.out.println("이름: " + student.name);
		System.out.println("국어 : " + student.korean);
		System.out.println("수학 : " + student.math);
		System.out.println("영어 : " + student.english);
		System.out.println("총점 : " + student.makeSum());
		System.out.println("평균 : " + student.makeAvg());
		System.out.println("등급 : " + student.makeGrade());
	}
}
