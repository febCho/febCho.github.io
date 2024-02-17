package kr.s25.lang.object;

public class ObjectMain {
	public static void main(String[] args) {
		ObjectMain om = new ObjectMain();
		
		//클래스 정보 반환
		System.out.println(om.getClass());
		//클래스 명 반환
		System.out.println(om.getClass().getName());
		//해시코드 반환
		System.out.println(om.hashCode());
		//해시코드를 16진수로 변환
		System.out.println(Integer.toHexString(om.hashCode()));
		//참조값 반환
		System.out.println(om.toString());
		//참조변수를 호출하면 자동적으로 toString() 메서드가 동작해서 참조값을 반환
		System.out.println(om);
	}
}
