package kr.s06.collections.map;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class HashMapMain02 {
	public static void main(String[] args) {
		String[] msg = {"Berlin", "Paris", "Seoul", "New York", "London"};
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//HashMap에 key와 value가 쌍으로 저장
		for(int i=0;i<msg.length;i++) {
			map.put(i, msg[i]);
		}
		
		//저장된 key, value 목록을 출력
		System.out.println(map);
		System.out.println("===========================");
		
		//Set<Integer> s = map.keySet();
		//Iterator<Integer> keys = s.iterator();
		//변수 s를 한 번만 쓰는데 굳이 쓰는 건 코드 낭비이니 아래와 같이 합쳐 작성
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			Integer key = keys.next();
			               //얻어낸 key를 map이 가진 get 메서드에 넣어 value 추출
			System.out.println(key + ", " + map.get(key));
		}
	}
}
