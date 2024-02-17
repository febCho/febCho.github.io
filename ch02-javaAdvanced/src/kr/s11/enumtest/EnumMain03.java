package kr.s11.enumtest;

//열거형 상수
enum Item{
	ADD, DEL, SEARCH, CANCEL
}
public class EnumMain03 {
	public static void main(String[] args) {
		System.out.println(Item.ADD);
		System.out.println(Item.DEL);
		System.out.println(Item.SEARCH);
		System.out.println(Item.CANCEL);
		System.out.println("====================");
		
		//values() 메서드는 열거 타입의 모든 열거 객체들을 배열로 만들어 반환
		//enum도 자료형으로 사용 가능하므로, Item 타입의 객체가
		//items라는 배열에 values() 메서드를 통해 저장되는 것
		Item[] items = Item.values();
		System.out.println("items.length: " + items.length);
		//반복문을 이용해서 상수 값 및 상수의 순서 값 출력
		for(Item i : items) {
			//배열로 만든 후, 각각의 Item 객체에 접근해 순번 반환
			System.out.println(i + " : " + i.ordinal());
		}
	}
}
