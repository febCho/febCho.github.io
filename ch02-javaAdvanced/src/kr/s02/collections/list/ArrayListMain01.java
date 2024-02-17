package kr.s02.collections.list;

import java.util.ArrayList;

class A{//toString을 재정의하여 원하는 값이 보여지게 할 수 있다.
	//"홍길동"과 100 역시 toString이 재정의되어 저장된 주소 대신 값이 변환된다.
	@Override
	public String toString() {
		return "A";
	}
}
class B{}

public class ArrayListMain01 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		//가변적인 것인지 확인: 0 > 4
		System.out.println("요소의 개수: " + list.size());
		
		//ArrayList에 객체 저장
		//add 메서드가 데이터를 전달 받을 인자의 타입이 동일해야 하기 때문에
		//auto boxing: 기본 자료형이 전부 Object로
		list.add(new A());//A -> Object 자동 형변환
		list.add(new B());//B -> Object 자동 형변환
		list.add("홍길동");//String -> Object 자동 형변환
		list.add(100);//int(기본 자료형) -> Integer(참조 자료형) -> Object 자동 형변환
		
		//저장된 객체의 명세 출력
		System.out.println(list);
		
		//요소의 개수
		System.out.println("요소의 개수: " + list.size());
	}
}
