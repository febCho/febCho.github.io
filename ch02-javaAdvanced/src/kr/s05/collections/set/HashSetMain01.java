package kr.s05.collections.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain01 {
	public static void main(String[] args) {
		//HashSet: 중복값을 불허
		String[] str = {"Java", "JSP", "Java", "Oracle"};
		
		HashSet<String> hs = new HashSet<String>();
		//확장 for문을 이용해서 배열의 요소 호출 및 HashSet에 저장
		for(String n : str) {
			hs.add(n);
		}
		
		//저장된 요소의 목록 출력
		System.out.println(hs);
		System.out.println("===================");
		
		//저장된 요소 출력
		Iterator<String> ir = hs.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
		System.out.println("===================");
		
		//확장 for문을 이용한 요소 출력
		for(String s : hs) {
			System.out.println(s);
		}
	}
}
