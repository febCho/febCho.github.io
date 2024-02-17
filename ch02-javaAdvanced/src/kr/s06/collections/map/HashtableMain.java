package kr.s06.collections.map;

import java.util.Hashtable;
import java.util.Enumeration;

public class HashtableMain {
	public static void main(String[] args) {
		         //key     value
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("name", "홍길동");
		ht.put("age", "27");//연산을 하지 않을 거기 때문에 String 타입으로 나이 저장
		ht.put("tel", "010-1234-5678");
		ht.put("job", "경찰");
		ht.put("address", "서울시");
		
		//key, value에 null 불인정
		//ht.put("hobby", null);
		//ht.put(null, "300");
		ht.put("name", "박문수");//같은 key를 사용하면 value를 덮어씌움
		
		//저장된 key, value 목록 출력
		System.out.println(ht);
		System.out.println("==================");
		
		String name = ht.get("name");
		System.out.println("이름은 " + name);
		System.out.println("=================");
		
		//Enumeration을 이용해서 key 구하기
		Enumeration<String> en = ht.keys();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println("key: " + key + ", " + ht.get(key));
		}
	}
}
