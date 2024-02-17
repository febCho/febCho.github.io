package kr.s02.collections.list;

import java.util.Vector;

public class VecotrMain01 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		//요소 추가
		v.add("김연아");
		v.add("손연재");
		v.add("김연경");
		v.add("이상화");
		
		//요소 목록 출력
		System.out.println(v);
		
		//반복문을 이용한 요소 출력
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		System.out.println("================");
		
		//확장 for문을 이용한 요소 출력
		for(String name : v) {
			System.out.println(name);
		}
	}
}
