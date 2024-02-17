package kr.s09.inner.statictest;

public class StaticMain {
	
	public static class StaticInner{
		int iv = 200;
		static int cv = 300;
		static void make() {
			System.out.println("하하");
		}
	}
	
	public static void main(String[] args) {
		//StaticMain 클래스에 다른 변수, 메서드 또한 없다면,
		//아래와 같이 외부 클래스의 객체를 만들어줄 필요가 없고
		//StaticMain sm = new StaticMain();
		//StaticMain.StaticInner in = sm.new StaticInner();
		
		//그냥 내부 클래스 자체를 하나의 온전한 클래스처럼 객체 생성하면 됨.
		StaticInner i = new StaticInner();
		System.out.println(i.iv);//인스턴트 변수는 객체 생성 후 호출 가능
		
		//static 변수 - 객체와 무관
		System.out.println(StaticInner.cv);
		//static 메서드 - 객체와 무관
		StaticInner.make();
	}
}
