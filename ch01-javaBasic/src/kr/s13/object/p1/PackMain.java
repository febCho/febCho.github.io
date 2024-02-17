package kr.s13.object.p1;

import kr.s13.object.p2.PackTwo;

public class PackMain {
	public static void main(String[] args) {
		//kr.s13.object.p1.PackOne p1 = new kr.s13.object.p1.PackOne();
		//같은 패키지의 클래스를 호출해서 객체 생서을 할 때는 패키지 생략 가능
		PackOne p1 = new PackOne();
		
		//다른 패키지의 클래스를 호출할 때는 패키지를 반드시 명시해야 함
		//kr.s13.object.p2.PackTwo p2 = new kr.s13.object.p2.PackTwo();
		
		//import문을 이용해서 호출하고자 하는 클래스의 패키지를 등록하면
		//클래스 명만 기재할 수 있음
		PackTwo p2 = new PackTwo();
		
	}
}
