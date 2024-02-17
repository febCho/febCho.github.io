package kr.s24.object2.poly;

//부모 클래스
class Parent{
	int a = 100;
}

//자식 클래스
class Child extends Parent{
	int b = 200;
}

public class PolyMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		
		//업캐스팅: 자식 클래스 타입에서 부모 클래스 타입으로 자동 형변환 되는 것
		Parent p = ch;//ch 안에 Child 객체를 가리키는 주소가 있고,
		              //이를 p에 복사(저장)해 주는 것
		
		//p를 통해 객체에 접근
		System.out.println(p.a);
		//System.out.println(p.b);
		//↑ 같은 객체에 접근하였음에도, 참조 자료형이 Parent이므로
		//호출 범위가 줄어들어 b는 접근할 수 없음.
		
		//다운캐스팅: 부모 클래스 타입에서 자식 클래스 타입으로 명시적 형변환 되는 것
		Child ch2 = (Child)p;//p가 가지고 있는 주소를 ch2로 복사
		//줄어들었던 영역을 강제로 늘려야 하기 때문에 자료형 명시 필요
		System.out.println(ch2.a);
		System.out.println(ch2.b);
	}
}
