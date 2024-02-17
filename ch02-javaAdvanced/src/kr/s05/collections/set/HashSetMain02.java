package kr.s05.collections.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class HashSetMain02 {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		while(hs.size()<6) {
			int ir = (int)(Math.random()*45)+1;//1~45
			hs.add(ir);//중복값을 자체적으로 허용하지 않음
		}
		
		System.out.println(hs);
		//Collections.sort(hs); - list 타입만 받기 때문에 HashSet은 타입 변환이 필요
		
		//HashSet -> Set -> Collection
		//생성자에 넣으면, ArrayList가 hs를 Collection 형태로 받아 데이터가 복사된다.
		//ArrayList<Integer> list = new ArrayList<Integer>(hs);
		// ↓↓↓↓↓↓
		//sort 메서드가 list 타입을 원하니까 import 하여 미리 형변환,
		//아래와 같이 기재하면 가장 컴팩트하다.
		List<Integer> list = new ArrayList<Integer>(hs);
		
		//오름차순 정렬
		Collections.sort(list);
		
		//확장 for문을 이용한 출력
		for(int num : list) {//Integer -> int: auto unboxing
			System.out.print(num + "\t");
		}
		
		//만약 아래와 같이 명시했다면 출력 단계에서 Integer -> int: auto unboxing
		//for(Integer num : list){
		//System.out.print(num + "\t");
		//}
	}
}
