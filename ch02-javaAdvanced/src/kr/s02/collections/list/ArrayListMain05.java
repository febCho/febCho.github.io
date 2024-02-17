package kr.s02.collections.list;

import java.util.ArrayList;

public class ArrayListMain05 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);//int -> Integer
		list.add(20);
		list.add(15);
		list.add(16);
		
		//요소의 명세를 출력
		System.out.println(list);
		System.out.println("========================");
		
		//반복문을 이욯해 짝수 삭제
		
		//반복문을 이용해서 특정 조건일 때 요소를 삭제할 경우
		//요소를 삭제하면 인덱스 변동이 생기고 요소가 이동을 하기 때문에
		//조건 체크를 하지 못하는 요소가 발생할 수 있음
		//따라서 이 때에는 맨 뒤의 인덱스부터 앞으로 이동하며 조건 체크를 해야 모두 체크가 가능
		
		/*
		for(int i=0;i<list.size();i++) {
			if(list.get(i)%2 == 0) {//짝수
				list.remove(i);
			}
		}
		*/
		
		//마지막 인덱스부터 시작해서 조건 체크하면 건너 뛰는 데이터가 발생하지 않음
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i)%2 == 0) {
				list.remove(i);
			}
		}
		System.out.println(list);
	}
}
