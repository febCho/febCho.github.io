package kr.s02.collections.list;

import java.util.ArrayList;

public class ArrayListMain03 {
	public static void main(String[] args) {
		/*
		 * 제네릭 표현: 객체를 생성할 때 객체에 저장할 수 있는 요소의 타입을 지정
		 */
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");//String -> Object
		list.add("김유신");//String -> Object
		
		//원래라면 컴파일 에러가 나지 않아 데이터 타입이 다르게 입력된 것을 눈치 X
		//-> ArrayList 객체 생성 시 제네릭 표현으로 저장할 요소의 타입을
		//String으로 지정했기 때문에 Integer 타입의 데이터를 저장할 수 없음
		//list.add(1000);//Integer -> Object
		list.add("박문수");//String -> Object
		
		//반복문을 이용한 요소의 출력
		for(int i=0;i<list.size();i++) {
			//1000이라는 다른 자료형의 데이터가 있어도 컴파일 에러가 나지 않음
			//또한, 제네릭 표현을 쓰게 되면, add, get 메서드 모두 Object가 아닌
			//전달된 타입을 쓰기 때문에 굳이 다운캐스팅을 할 필요가 없음
			//String name = (String)list.get(i);
			String name = list.get(i);
			System.out.println(name);
		}
		System.out.println("================");
		
		//확장 for문을 이용한 요소의 출력
		for(String name : list) {
			System.out.println(name);
		}
	}
}
