package kr.s24.object3.instanceoftest;

//부모 클래스
class Parent{
	//Object의 toString 재정의 - 참조값 반환 > 아래 문구 반환
	@Override
	public String toString() {
		return "Parent 클래스";
	}
}

//자식 클래스
class Child extends Parent{
	//Parent의 toString 재정의
	@Override
	public String toString() {
		return "Child 클래스";
	}
}

public class InstanceofMain01 {
	public static void main(String[] args) {
		//상속 관계에는 자식 클래스를 올려야 하는데,
		//아래와 같이 생성하면 부모 클래스와 Object 클래스만 올라간다.
		Parent p = new Parent();
		
		//컴파일 오류는 없으나 실행 시 오류가 발생한다.
		//메모리에 Child가 없기 때문에 p를 형변환 해줄 수 없다.
		//Child ch = (Child)p;
		
		  //생성된 객체    //사용 가능한 자료형
		if(p instanceof Child) {
			//생성된 객체가 Child 타입을 사용할 수 있는 경우
			Child ch2 = (Child)p;
			System.out.println(ch2);
			System.out.println("~~~~~~~~~~~~");
		}else {
			//생성된 객체가 Child 타입을 사용할 수 없는 경우
			System.out.println(p);
			System.out.println("++++++++++++++");
		}
	}
}
