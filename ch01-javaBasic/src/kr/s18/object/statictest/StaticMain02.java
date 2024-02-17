package kr.s18.object.statictest;

public class StaticMain02 {
	
	//인스턴스 변수
	int a;
	//static(클래스) 변수
	static String s;
	
	public static void main(String[] args) {
		//StaticMain02.s = "서울"; 같은 클래스에 있기 때문에 클래스 명 필요 없음
		s = "서울";
		System.out.println(s);
		System.out.println("==========");
		
		//인스턴스 변수는 객체 생성 후에 호출해야 사용 가능
		//a = 1000;
		StaticMain02 sm = new StaticMain02();
		sm.a = 1000;
		System.out.println(sm.a);
		
		//StaticMain03 인스턴스/static 변수 차이
		//1. static 변수는 다른 클래스에서 호출했을 때
		//클래스 명을 붙이고 호출하면 됨.
		System.out.println(StaticMain03.s2);
		System.out.println(StaticMain03.getString());
		//2. 근데 인스턴스 변수는 다른 클래스에서 호출했을 때
		//객체 생성 후에 호출해야 함.
		StaticMain03 sm2 = new StaticMain03();
		System.out.println(sm2.s1);
	}
}
