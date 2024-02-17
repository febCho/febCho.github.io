package kr.s18.object.statictest;

public class StaticMain03 {
	//인스턴스 변수
	String s1 = "여름";
	//static(클래스) 변수
	static String s2 = "겨울";
	
	//static 매서드
	public static String getString() {
		return s2;
	}
	public static void main(String[] args) {
		//main과 같은 static에 단독으로 올라와 있는 메서드이기 때문에 그냥 호출만 하면 됨
		System.out.println(getString());
	}
}
