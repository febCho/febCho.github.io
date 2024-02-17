package kr.s15.object.constructor;

class Student{
	//멤버 변수
	int korean;
	int english;
	int math;
	int history;
	int science;
	int num;//과목수도 달라져야 하기 때문에
	
	public Student(int k, int e, int m) {
		korean = k;
		english = e;
		math = m;
		num = 3;//과목수 지정
	}
	
	public Student(int k, int e, int m, int h, int s) {
		korean = k;
		english = e;
		math = m;
		history = h;
		science = s;
		num = 5;
		//메서드와 닮아 있지만, 생성자는 객체 생성을 돕고
		//멤버 변수를 초기화 하기 위해 존재한다.
		//즉, 위 내용은 메서드의 수행문이 아닌 초기화이다.
	}
	//총점 구하기
	public int getTotal() {//인자가 없다 = 위 멤버 변수들을 쓰겠다
		int total;
		if(num == 3) {
			total = korean + english + math;
		}else {
			total = korean + english + math + history + science;
		}
		return total;
	}
	//평균 구하기
	public int getAvg() {
		return getTotal() / num;
	}
	
}
public class StudentMain {
	public static void main(String[] args) {
		Student st = new Student(90, 80, 89);
		
		System.out.println("총점: " + st.getTotal());
		System.out.println("평균: " + st.getAvg());
		System.out.println("===================");
		
		Student st2 = new Student(89, 58, 69, 70, 100);
		
		System.out.println("총점: " + st2.getTotal());
		System.out.println("평균: " + st2.getAvg());
		
	}
}
