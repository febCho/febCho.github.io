package kr.s02.collections.list;

import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();
		list.add("홍길동");//0
		list.add("박문수");//1
		list.add("김유신");//2
		list.add("이순신");//3
		list.add("홍길동");//4
		
		//반복문을 이용한 요소의 출력
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i + " : " + name);
		}
		System.out.println("===================");
		
		//요소의 삭제
		//list.remove(2);//여기서 2는 인덱스 - 데이터 '김유신'이 삭제
		list.remove("홍길동");//요소 - 중복된 데이터는 다 삭제하는 것이 아니라 앞에서부터 삭제
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i + " : " + name);
		}
		System.out.println("===================");
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(40);
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(40);
		
		for(int i=0;i<list2.size();i++) {
			Integer num = list2.get(i);
			System.out.println(i + " : " + num);
		}
		System.out.println("========================");
		
		//요소의 삭제
		//list2.remove(2);//역시나 인덱스 2를 지칭
		list2.remove(Integer.valueOf(40));//요소인 40(int)을 Integer로 변환
		
		for(int i=0;i<list2.size();i++) {
			Integer num = list2.get(i);
			System.out.println(i + " : " + num);
		}
		System.out.println("========================");
		
		//요소의 변경
		       //인덱스, 요소
		list2.set(1, 30);
		
		for(int i=0;i<list2.size();i++) {
			Integer num = list2.get(i);
			System.out.println(i + " : " + num);
		}
		
	}
}
