package kr.s02.collections.list;

import java.util.ArrayList;

public class ArrayListMain08 {
	public static void main(String[] args) {
		//list에는 객체의 주소만 저장될 수 있기 때문에
		//CartItem이라는 자료형의 객체들만 넣을 거라는 제네릭 표현이 可
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		list.add(new CartItem("A1001", 2, 20000));
		list.add(new CartItem("B1001", 1, 70000));
		list.add(new CartItem("C1001", 3, 2500));
		
		//ArrayList의 요소를 반복문을 이용해서 출력
		//항목 표기
		System.out.printf("%s %8s %8s%n", "상품 코드", "수량", "가격");
		System.out.println("===============================");
		for(CartItem item : list) {
			System.out.printf("%s %,9d개 %,11d%n",
					item.getCode(), item.getNum(), item.getPrice());
		}
	}
}
